package com.file.business;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.ImagingOpException;
import java.awt.image.IndexColorModel;
import java.awt.image.Kernel;
import java.awt.image.RasterFormatException;
import java.awt.image.RescaleOp;

import javax.imageio.ImageIO;

public class Scalr {
	/**
	 * System property name used to define the debug boolean flag.
	 * <p/>
	 * Value is "<code>imgscalr.debug</code>".
	 */
	public static final String DEBUG_PROPERTY_NAME = "imgscalr.debug";

	/**
	 * System property name used to define a custom log prefix.
	 * <p/>
	 * Value is "<code>imgscalr.logPrefix</code>".
	 */
	public static final String LOG_PREFIX_PROPERTY_NAME = "imgscalr.logPrefix";

	/**
	 * Flag used to indicate if debugging output has been enabled by setting the
	 * "<code>imgscalr.debug</code>" system property to <code>true</code>. This
	 * value will be <code>false</code> if the "<code>imgscalr.debug</code>"
	 * system property is undefined or set to <code>false</code>.
	 * <p/>
	 * This property can be set on startup with:<br/>
	 * <code>
	 * -Dimgscalr.debug=true
	 * </code> or by calling {@link System#setProperty(String, String)} to set a
	 * new property value for {@link #DEBUG_PROPERTY_NAME} before this class is
	 * loaded.
	 * <p/>
	 * Default value is <code>false</code>.
	 */
	public static final boolean DEBUG = Boolean.getBoolean(DEBUG_PROPERTY_NAME);

	/**
	 * Prefix to every log message this library logs. Using a well-defined
	 * prefix helps make it easier both visually and programmatically to scan
	 * log files for messages produced by this library.
	 * <p/>
	 * This property can be set on startup with:<br/>
	 * <code>
	 * -Dimgscalr.logPrefix=&lt;YOUR PREFIX HERE&gt;
	 * </code> or by calling {@link System#setProperty(String, String)} to set a
	 * new property value for {@link #LOG_PREFIX_PROPERTY_NAME} before this
	 * class is loaded.
	 * <p/>
	 * Default value is "<code>[imgscalr] </code>" (including the space).
	 */
	public static final String LOG_PREFIX = System.getProperty(
			LOG_PREFIX_PROPERTY_NAME, "[imgscalr] ");

	/**
	 * A {@link ConvolveOp} using a very light "blur" kernel that acts like an
	 * anti-aliasing filter (softens the image a bit) when applied to an image.
	 * <p/>
	 * A common request by users of the library was that they wished to "soften"
	 * resulting images when scaling them down drastically. After quite a bit of
	 * A/B testing, the kernel used by this Op was selected as the closest match
	 * for the target which was the softer results from the deprecated
	 * {@link AreaAveragingScaleFilter} (which is used internally by the
	 * deprecated {@link Image#getScaledInstance(int, int, int)} method in the
	 * JDK that imgscalr is meant to replace).
	 * <p/>
	 * This ConvolveOp uses a 3x3 kernel with the values:
	 * <table cellpadding="4" border="1">
	 * <tr>
	 * <td>.0f</td>
	 * <td>.08f</td>
	 * <td>.0f</td>
	 * </tr>
	 * <tr>
	 * <td>.08f</td>
	 * <td>.68f</td>
	 * <td>.08f</td>
	 * </tr>
	 * <tr>
	 * <td>.0f</td>
	 * <td>.08f</td>
	 * <td>.0f</td>
	 * </tr>
	 * </table>
	 * <p/>
	 * For those that have worked with ConvolveOps before, this Op uses the
	 * {@link ConvolveOp#EDGE_NO_OP} instruction to not process the pixels along
	 * the very edge of the image (otherwise EDGE_ZERO_FILL would create a
	 * black-border around the image). If you have not worked with a ConvolveOp
	 * before, it just means this default OP will "do the right thing" and not
	 * give you garbage results.
	 * <p/>
	 * This ConvolveOp uses no {@link RenderingHints} values as internally the
	 * {@link ConvolveOp} class only uses hints when doing a color conversion
	 * between the source and destination {@link BufferedImage} targets.
	 * imgscalr allows the {@link ConvolveOp} to create its own destination
	 * image every time, so no color conversion is ever needed and thus no
	 * hints.
	 * <h3>Performance</h3>
	 * Use of this (and other) {@link ConvolveOp}s are hardware accelerated when
	 * possible. For more information on if your image op is hardware
	 * accelerated or not, check the source code of the underlying JDK class
	 * that actually executes the Op code, <a href=
	 * "http://www.docjar.com/html/api/sun/awt/image/ImagingLib.java.html"
	 * >sun.awt.image.ImagingLib</a>.
	 * <h3>Known Issues</h3>
	 * In all versions of Java (tested up to Java 7 preview Build 131), running
	 * this op against a GIF with transparency and attempting to save the
	 * resulting image as a GIF results in a corrupted/empty file. The file must
	 * be saved out as a PNG to maintain the transparency.
	 * 
	 * @since 3.0
	 */
	public static final ConvolveOp OP_ANTIALIAS = new ConvolveOp(
			new Kernel(3, 3, new float[] { .0f, .08f, .0f, .08f, .68f, .08f,
					.0f, .08f, .0f }), ConvolveOp.EDGE_NO_OP, null);

	/**
	 * A {@link RescaleOp} used to make any input image 10% darker.
	 * <p/>
	 * This operation can be applied multiple times in a row if greater than 10%
	 * changes in brightness are desired.
	 * 
	 * @since 4.0
	 */
	public static final RescaleOp OP_DARKER = new RescaleOp(0.9f, 0, null);

	/**
	 * A {@link RescaleOp} used to make any input image 10% brighter.
	 * <p/>
	 * This operation can be applied multiple times in a row if greater than 10%
	 * changes in brightness are desired.
	 * 
	 * @since 4.0
	 */
	public static final RescaleOp OP_BRIGHTER = new RescaleOp(1.1f, 0, null);

	/**
	 * A {@link ColorConvertOp} used to convert any image to a grayscale color
	 * palette.
	 * <p/>
	 * Applying this op multiple times to the same image has no compounding
	 * effects.
	 * 
	 * @since 4.0
	 */
	public static final ColorConvertOp OP_GRAYSCALE = new ColorConvertOp(
			ColorSpace.getInstance(ColorSpace.CS_GRAY), null);

	/**
	 * Static initializer used to prepare some of the variables used by this
	 * class.
	 */
	static {
		log(0, "Debug output ENABLED");
	}

	/**
	 * Used to define the different scaling hints that the algorithm can use.
	 * 
	 * @author Riyad Kalla (software@thebuzzmedia.com)
	 * @since 1.1
	 */
	public static enum Method {
		/**
		 * Used to indicate that the scaling implementation should decide which
		 * method to use in order to get the best looking scaled image in the
		 * least amount of time.
		 * <p/>
		 * The scaling algorithm will use the
		 * {@link Scalr#THRESHOLD_QUALITY_BALANCED} or
		 * {@link Scalr#THRESHOLD_BALANCED_SPEED} thresholds as cut-offs to
		 * decide between selecting the <code>QUALITY</code>,
		 * <code>BALANCED</code> or <code>SPEED</code> scaling algorithms.
		 * <p/>
		 * By default the thresholds chosen will give nearly the best looking
		 * result in the fastest amount of time. We intend this method to work
		 * for 80% of people looking to scale an image quickly and get a good
		 * looking result.
		 */
		AUTOMATIC,
		/**
		 * Used to indicate that the scaling implementation should scale as fast
		 * as possible and return a result. For smaller images (800px in size)
		 * this can result in noticeable aliasing but it can be a few magnitudes
		 * times faster than using the QUALITY method.
		 */
		SPEED,
		/**
		 * Used to indicate that the scaling implementation should use a scaling
		 * operation balanced between SPEED and QUALITY. Sometimes SPEED looks
		 * too low quality to be useful (e.g. text can become unreadable when
		 * scaled using SPEED) but using QUALITY mode will increase the
		 * processing time too much. This mode provides a "better than SPEED"
		 * quality in a "less than QUALITY" amount of time.
		 */
		BALANCED,
		/**
		 * Used to indicate that the scaling implementation should do everything
		 * it can to create as nice of a result as possible. This approach is
		 * most important for smaller pictures (800px or smaller) and less
		 * important for larger pictures as the difference between this method
		 * and the SPEED method become less and less noticeable as the
		 * source-image size increases. Using the AUTOMATIC method will
		 * automatically prefer the QUALITY method when scaling an image down
		 * below 800px in size.
		 */
		QUALITY,
		/**
		 * Used to indicate that the scaling implementation should go above and
		 * beyond the work done by {@link Method#QUALITY} to make the image look
		 * exceptionally good at the cost of more processing time. This is
		 * especially evident when generating thumbnails of images that look
		 * jagged with some of the other {@link Method}s (even
		 * {@link Method#QUALITY}).
		 */
		ULTRA_QUALITY;
	}

	/**
	 * Used to define the different modes of resizing that the algorithm can
	 * use.
	 * 
	 * @author Riyad Kalla (software@thebuzzmedia.com)
	 * @since 3.1
	 */
	public static enum Mode {
		/**
		 * Used to indicate that the scaling implementation should calculate
		 * dimensions for the resultant image by looking at the image's
		 * orientation and generating proportional dimensions that best fit into
		 * the target width and height given
		 * 
		 * See "Image Proportions" in the {@link Scalr} class description for
		 * more detail.
		 */
		AUTOMATIC,
		/**
		 * Used to fit the image to the exact dimensions given regardless of the
		 * image's proportions. If the dimensions are not proportionally
		 * correct, this will introduce vertical or horizontal stretching to the
		 * image.
		 * <p/>
		 * It is recommended that you use one of the other <code>FIT_TO</code>
		 * modes or {@link Mode#AUTOMATIC} if you want the image to look
		 * correct, but if dimension-fitting is the #1 priority regardless of
		 * how it makes the image look, that is what this mode is for.
		 */
		FIT_EXACT,
		/**
		 * Used to indicate that the scaling implementation should calculate
		 * dimensions for the resultant image that best-fit within the given
		 * width, regardless of the orientation of the image.
		 */
		FIT_TO_WIDTH,
		/**
		 * Used to indicate that the scaling implementation should calculate
		 * dimensions for the resultant image that best-fit within the given
		 * height, regardless of the orientation of the image.
		 */
		FIT_TO_HEIGHT;
	}

	/**
	 * Used to define the different types of rotations that can be applied to an
	 * image during a resize operation.
	 * 
	 * @author Riyad Kalla (software@thebuzzmedia.com)
	 * @since 3.2
	 */
	public static enum Rotation {
		/**
		 * 90-degree, clockwise rotation (to the right). This is equivalent to a
		 * quarter-turn of the image to the right; moving the picture on to its
		 * right side.
		 */
		CW_90,
		/**
		 * 180-degree, clockwise rotation (to the right). This is equivalent to
		 * 1 half-turn of the image to the right; rotating the picture around
		 * until it is upside down from the original position.
		 */
		CW_180,
		/**
		 * 270-degree, clockwise rotation (to the right). This is equivalent to
		 * a quarter-turn of the image to the left; moving the picture on to its
		 * left side.
		 */
		CW_270,
		/**
		 * Flip the image horizontally by reflecting it around the y axis.
		 * <p/>
		 * This is not a standard rotation around a center point, but instead
		 * creates the mirrored reflection of the image horizontally.
		 * <p/>
		 * More specifically, the vertical orientation of the image stays the
		 * same (the top stays on top, and the bottom on bottom), but the right
		 * and left sides flip. This is different than a standard rotation where
		 * the top and bottom would also have been flipped.
		 */
		FLIP_HORZ,
		/**
		 * Flip the image vertically by reflecting it around the x axis.
		 * <p/>
		 * This is not a standard rotation around a center point, but instead
		 * creates the mirrored reflection of the image vertically.
		 * <p/>
		 * More specifically, the horizontal orientation of the image stays the
		 * same (the left stays on the left and the right stays on the right),
		 * but the top and bottom sides flip. This is different than a standard
		 * rotation where the left and right would also have been flipped.
		 */
		FLIP_VERT;
	}

	/**
	 * Threshold (in pixels) at which point the scaling operation using the
	 * {@link Method#AUTOMATIC} method will decide if a {@link Method#BALANCED}
	 * method will be used (if smaller than or equal to threshold) or a
	 * {@link Method#SPEED} method will be used (if larger than threshold).
	 * <p/>
	 * The bigger the image is being scaled to, the less noticeable degradations
	 * in the image becomes and the faster algorithms can be selected.
	 * <p/>
	 * The value of this threshold (1600) was chosen after visual, by-hand, A/B
	 * testing between different types of images scaled with this library; both
	 * photographs and screenshots. It was determined that images below this
	 * size need to use a {@link Method#BALANCED} scale method to look decent in
	 * most all cases while using the faster {@link Method#SPEED} method for
	 * images bigger than this threshold showed no noticeable degradation over a
	 * <code>BALANCED</code> scale.
	 */
	public static final int THRESHOLD_BALANCED_SPEED = 1600;

	/**
	 * Threshold (in pixels) at which point the scaling operation using the
	 * {@link Method#AUTOMATIC} method will decide if a {@link Method#QUALITY}
	 * method will be used (if smaller than or equal to threshold) or a
	 * {@link Method#BALANCED} method will be used (if larger than threshold).
	 * <p/>
	 * The bigger the image is being scaled to, the less noticeable degradations
	 * in the image becomes and the faster algorithms can be selected.
	 * <p/>
	 * The value of this threshold (800) was chosen after visual, by-hand, A/B
	 * testing between different types of images scaled with this library; both
	 * photographs and screenshots. It was determined that images below this
	 * size need to use a {@link Method#QUALITY} scale method to look decent in
	 * most all cases while using the faster {@link Method#BALANCED} method for
	 * images bigger than this threshold showed no noticeable degradation over a
	 * <code>QUALITY</code> scale.
	 */
	public static final int THRESHOLD_QUALITY_BALANCED = 800;

	/**
	 * Used to apply, in the order given, 1 or more {@link BufferedImageOp}s to
	 * a given {@link BufferedImage} and return the result.
	 * <p/>
	 * <strong>Feature</strong>: This implementation works around <a
	 * href="http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4965606">a
	 * decade-old JDK bug</a> that can cause a {@link RasterFormatException}
	 * when applying a perfectly valid {@link BufferedImageOp}s to images.
	 * <p/>
	 * <strong>Feature</strong>: This implementation also works around
	 * {@link BufferedImageOp}s failing to apply and throwing
	 * {@link ImagingOpException}s when run against a <code>src</code> image
	 * type that is poorly supported. Unfortunately using {@link ImageIO} and
	 * standard Java methods to load images provides no consistency in getting
	 * images in well-supported formats. This method automatically accounts and
	 * corrects for all those problems (if necessary).
	 * <p/>
	 * It is recommended you always use this method to apply any
	 * {@link BufferedImageOp}s instead of relying on directly using the
	 * {@link BufferedImageOp#filter(BufferedImage, BufferedImage)} method.
	 * <p/>
	 * <strong>Performance</strong>: Not all {@link BufferedImageOp}s are
	 * hardware accelerated operations, but many of the most popular (like
	 * {@link ConvolveOp}) are. For more information on if your image op is
	 * hardware accelerated or not, check the source code of the underlying JDK
	 * class that actually executes the Op code, <a href=
	 * "http://www.docjar.com/html/api/sun/awt/image/ImagingLib.java.html"
	 * >sun.awt.image.ImagingLib</a>.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will have the ops applied to it.
	 * @param ops
	 *            <code>1</code> or more ops to apply to the image.
	 * 
	 * @return a new {@link BufferedImage} that represents the <code>src</code>
	 *         with all the given operations applied to it.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>ops</code> is <code>null</code> or empty.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 */
	public static BufferedImage apply(BufferedImage src, BufferedImageOp... ops)
			throws IllegalArgumentException, ImagingOpException {
		long t = System.currentTimeMillis();

		if (src == null)
			throw new IllegalArgumentException("src cannot be null");
		if (ops == null || ops.length == 0)
			throw new IllegalArgumentException("ops cannot be null or empty");

		int type = src.getType();

		/*
		 * Ensure the src image is in the best supported image type before we
		 * continue, otherwise it is possible our calls below to getBounds2D and
		 * certainly filter(...) may fail if not.
		 * 
		 * Java2D makes an attempt at applying most BufferedImageOps using
		 * hardware acceleration via the ImagingLib internal library.
		 * 
		 * Unfortunately may of the BufferedImageOp are written to simply fail
		 * with an ImagingOpException if the operation cannot be applied with no
		 * additional information about what went wrong or attempts at
		 * re-applying it in different ways.
		 * 
		 * This is assuming the failing BufferedImageOp even returns a null
		 * image after failing to apply; some simply return a corrupted/black
		 * image that result in no exception and it is up to the user to
		 * discover this.
		 * 
		 * In internal testing, EVERY failure I've ever seen was the result of
		 * the source image being in a poorly-supported BufferedImage Type like
		 * BGR or ABGR (even though it was loaded with ImageIO).
		 * 
		 * To avoid this nasty/stupid surprise with BufferedImageOps, we always
		 * ensure that the src image starts in an optimally supported format
		 * before we try and apply the filter.
		 */
		if (!(type == BufferedImage.TYPE_INT_RGB || type == BufferedImage.TYPE_INT_ARGB))
			src = copyToOptimalImage(src);

		if (DEBUG)
			log(0, "Applying %d BufferedImageOps...", ops.length);

		boolean hasReassignedSrc = false;

		for (int i = 0; i < ops.length; i++) {
			long subT = System.currentTimeMillis();
			BufferedImageOp op = ops[i];

			// Skip null ops instead of throwing an exception.
			if (op == null)
				continue;

			if (DEBUG)
				log(1, "Applying BufferedImageOp [class=%s, toString=%s]...",
						op.getClass(), op.toString());

			/*
			 * Must use op.getBounds instead of src.getWidth and src.getHeight
			 * because we are trying to create an image big enough to hold the
			 * result of this operation (which may be to scale the image
			 * smaller), in that case the bounds reported by this op and the
			 * bounds reported by the source image will be different.
			 */
			Rectangle2D resultBounds = op.getBounds2D(src);

			// Watch out for flaky/misbehaving ops that fail to work right.
			if (resultBounds == null)
				throw new ImagingOpException(
						"BufferedImageOp ["
								+ op.toString()
								+ "] getBounds2D(src) returned null bounds for the target image; this should not happen and indicates a problem with application of this type of op.");

			/*
			 * We must manually create the target image; we cannot rely on the
			 * null-destination filter() method to create a valid destination
			 * for us thanks to this JDK bug that has been filed for almost a
			 * decade:
			 * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4965606
			 */
			BufferedImage dest = createOptimalImage(src,
					(int) Math.round(resultBounds.getWidth()),
					(int) Math.round(resultBounds.getHeight()));

			// Perform the operation, update our result to return.
			BufferedImage result = op.filter(src, dest);

			/*
			 * Flush the 'src' image ONLY IF it is one of our interim temporary
			 * images being used when applying 2 or more operations back to
			 * back. We never want to flush the original image passed in.
			 */
			if (hasReassignedSrc)
				src.flush();

			/*
			 * Incase there are more operations to perform, update what we
			 * consider the 'src' reference to our last result so on the next
			 * iteration the next op is applied to this result and not back
			 * against the original src passed in.
			 */
			src = result;

			/*
			 * Keep track of when we re-assign 'src' to an interim temporary
			 * image, so we know when we can explicitly flush it and clean up
			 * references on future iterations.
			 */
			hasReassignedSrc = true;

			if (DEBUG)
				log(1,
						"Applied BufferedImageOp in %d ms, result [width=%d, height=%d]",
						System.currentTimeMillis() - subT, result.getWidth(),
						result.getHeight());
		}

		if (DEBUG)
			log(0, "All %d BufferedImageOps applied in %d ms", ops.length,
					System.currentTimeMillis() - t);

		return src;
	}

	/**
	 * Used to crop the given <code>src</code> image from the top-left corner
	 * and applying any optional {@link BufferedImageOp}s to the result before
	 * returning it.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image to crop.
	 * @param width
	 *            The width of the bounding cropping box.
	 * @param height
	 *            The height of the bounding cropping box.
	 * @param ops
	 *            <code>0</code> or more ops to apply to the image. If
	 *            <code>null</code> or empty then <code>src</code> is return
	 *            unmodified.
	 * 
	 * @return a new {@link BufferedImage} representing the cropped region of
	 *         the <code>src</code> image with any optional operations applied
	 *         to it.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if any coordinates of the bounding crop box is invalid within
	 *             the bounds of the <code>src</code> image (e.g. negative or
	 *             too big).
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 */
	public static BufferedImage crop(BufferedImage src, int width, int height,
			BufferedImageOp... ops) throws IllegalArgumentException,
			ImagingOpException {
		return crop(src, 0, 0, width, height, ops);
	}

	/**
	 * Used to crop the given <code>src</code> image and apply any optional
	 * {@link BufferedImageOp}s to it before returning the result.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image to crop.
	 * @param x
	 *            The x-coordinate of the top-left corner of the bounding box
	 *            used for cropping.
	 * @param y
	 *            The y-coordinate of the top-left corner of the bounding box
	 *            used for cropping.
	 * @param width
	 *            The width of the bounding cropping box.
	 * @param height
	 *            The height of the bounding cropping box.
	 * @param ops
	 *            <code>0</code> or more ops to apply to the image. If
	 *            <code>null</code> or empty then <code>src</code> is return
	 *            unmodified.
	 * 
	 * @return a new {@link BufferedImage} representing the cropped region of
	 *         the <code>src</code> image with any optional operations applied
	 *         to it.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if any coordinates of the bounding crop box is invalid within
	 *             the bounds of the <code>src</code> image (e.g. negative or
	 *             too big).
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 */
	public static BufferedImage crop(BufferedImage src, int x, int y,
			int width, int height, BufferedImageOp... ops)
			throws IllegalArgumentException, ImagingOpException {
		long t = System.currentTimeMillis();

		if (src == null)
			throw new IllegalArgumentException("src cannot be null");
		if (x < 0 || y < 0 || width < 0 || height < 0)
			throw new IllegalArgumentException("Invalid crop bounds: x [" + x
					+ "], y [" + y + "], width [" + width + "] and height ["
					+ height + "] must all be >= 0");

		int srcWidth = src.getWidth();
		int srcHeight = src.getHeight();

		if ((x + width) > srcWidth)
			throw new IllegalArgumentException(
					"Invalid crop bounds: x + width [" + (x + width)
							+ "] must be <= src.getWidth() [" + srcWidth + "]");
		if ((y + height) > srcHeight)
			throw new IllegalArgumentException(
					"Invalid crop bounds: y + height [" + (y + height)
							+ "] must be <= src.getHeight() [" + srcHeight
							+ "]");

		if (DEBUG)
			log(0,
					"Cropping Image [width=%d, height=%d] to [x=%d, y=%d, width=%d, height=%d]...",
					srcWidth, srcHeight, x, y, width, height);

		// Create a target image of an optimal type to render into.
		BufferedImage result = createOptimalImage(src, width, height);
		Graphics g = result.getGraphics();

		/*
		 * Render the region specified by our crop bounds from the src image
		 * directly into our result image (which is the exact size of the crop
		 * region).
		 */
		g.drawImage(src, 0, 0, width, height, x, y, (x + width), (y + height),
				null);
		g.dispose();

		if (DEBUG)
			log(0, "Cropped Image in %d ms", System.currentTimeMillis() - t);

		// Apply any optional operations (if specified).
		if (ops != null && ops.length > 0)
			result = apply(result, ops);

		return result;
	}

	/**
	 * Used to apply padding around the edges of an image using
	 * {@link Color#BLACK} to fill the extra padded space and then return the
	 * result.
	 * <p/>
	 * The amount of <code>padding</code> specified is applied to all sides;
	 * more specifically, a <code>padding</code> of <code>2</code> would add 2
	 * extra pixels of space (filled by the given <code>color</code>) on the
	 * top, bottom, left and right sides of the resulting image causing the
	 * result to be 4 pixels wider and 4 pixels taller than the <code>src</code>
	 * image.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image the padding will be added to.
	 * @param padding
	 *            The number of pixels of padding to add to each side in the
	 *            resulting image. If this value is <code>0</code> then
	 *            <code>src</code> is returned unmodified.
	 * @param ops
	 *            <code>0</code> or more ops to apply to the image. If
	 *            <code>null</code> or empty then <code>src</code> is return
	 *            unmodified.
	 * 
	 * @return a new {@link BufferedImage} representing <code>src</code> with
	 *         the given padding applied to it.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>padding</code> is &lt; <code>1</code>.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 */
	public static BufferedImage pad(BufferedImage src, int padding,
			BufferedImageOp... ops) throws IllegalArgumentException,
			ImagingOpException {
		return pad(src, padding, Color.BLACK);
	}

	/**
	 * Used to apply padding around the edges of an image using the given color
	 * to fill the extra padded space and then return the result. {@link Color}s
	 * using an alpha channel (i.e. transparency) are supported.
	 * <p/>
	 * The amount of <code>padding</code> specified is applied to all sides;
	 * more specifically, a <code>padding</code> of <code>2</code> would add 2
	 * extra pixels of space (filled by the given <code>color</code>) on the
	 * top, bottom, left and right sides of the resulting image causing the
	 * result to be 4 pixels wider and 4 pixels taller than the <code>src</code>
	 * image.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image the padding will be added to.
	 * @param padding
	 *            The number of pixels of padding to add to each side in the
	 *            resulting image. If this value is <code>0</code> then
	 *            <code>src</code> is returned unmodified.
	 * @param color
	 *            The color to fill the padded space with. {@link Color}s using
	 *            an alpha channel (i.e. transparency) are supported.
	 * @param ops
	 *            <code>0</code> or more ops to apply to the image. If
	 *            <code>null</code> or empty then <code>src</code> is return
	 *            unmodified.
	 * 
	 * @return a new {@link BufferedImage} representing <code>src</code> with
	 *         the given padding applied to it.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>padding</code> is &lt; <code>1</code>.
	 * @throws IllegalArgumentException
	 *             if <code>color</code> is <code>null</code>.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 */
	public static BufferedImage pad(BufferedImage src, int padding,
			Color color, BufferedImageOp... ops)
			throws IllegalArgumentException, ImagingOpException {
		long t = System.currentTimeMillis();

		if (src == null)
			throw new IllegalArgumentException("src cannot be null");
		if (padding < 1)
			throw new IllegalArgumentException("padding [" + padding
					+ "] must be > 0");
		if (color == null)
			throw new IllegalArgumentException("color cannot be null");

		int srcWidth = src.getWidth();
		int srcHeight = src.getHeight();

		/*
		 * Double the padding to account for all sides of the image. More
		 * specifically, if padding is "1" we add 2 pixels to width and 2 to
		 * height, so we have 1 new pixel of padding all the way around our
		 * image.
		 */
		int sizeDiff = (padding * 2);
		int newWidth = srcWidth + sizeDiff;
		int newHeight = srcHeight + sizeDiff;

		if (DEBUG)
			log(0,
					"Padding Image from [originalWidth=%d, originalHeight=%d, padding=%d] to [newWidth=%d, newHeight=%d]...",
					srcWidth, srcHeight, padding, newWidth, newHeight);

		boolean colorHasAlpha = (color.getAlpha() != 255);
		boolean imageHasAlpha = (src.getTransparency() != BufferedImage.OPAQUE);

		BufferedImage result;

		/*
		 * We need to make sure our resulting image that we render into contains
		 * alpha if either our original image OR the padding color we are using
		 * contain it.
		 */
		if (colorHasAlpha || imageHasAlpha) {
			if (DEBUG)
				log(1,
						"Transparency FOUND in source image or color, using ARGB image type...");

			result = new BufferedImage(newWidth, newHeight,
					BufferedImage.TYPE_INT_ARGB);
		} else {
			if (DEBUG)
				log(1,
						"Transparency NOT FOUND in source image or color, using RGB image type...");

			result = new BufferedImage(newWidth, newHeight,
					BufferedImage.TYPE_INT_RGB);
		}

		Graphics g = result.getGraphics();

		// "Clear" the background of the new image with our padding color first.
		g.setColor(color);
		g.fillRect(0, 0, newWidth, newHeight);

		// Draw the image into the center of the new padded image.
		g.drawImage(src, padding, padding, null);
		g.dispose();

		if (DEBUG)
			log(0, "Padding Applied in %d ms", System.currentTimeMillis() - t);

		// Apply any optional operations (if specified).
		if (ops != null && ops.length > 0)
			result = apply(result, ops);

		return result;
	}

	/**
	 * Resize a given image (maintaining its original proportion) to a width and
	 * height no bigger than <code>targetSize</code> and apply the given
	 * {@link BufferedImageOp}s (if any) to the result before returning it.
	 * <p/>
	 * A scaling method of {@link Method#AUTOMATIC} and mode of
	 * {@link Mode#AUTOMATIC} are used.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param targetSize
	 *            The target width and height (square) that you wish the image
	 *            to fit within.
	 * @param ops
	 *            <code>0</code> or more optional image operations (e.g.
	 *            sharpen, blur, etc.) that can be applied to the final result
	 *            before returning the image.
	 * 
	 * @return a new {@link BufferedImage} representing the scaled
	 *         <code>src</code> image.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>targetSize</code> is &lt; 0.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 */
	public static BufferedImage resize(BufferedImage src, int targetSize,
			BufferedImageOp... ops) throws IllegalArgumentException,
			ImagingOpException {
		return resize(src, Method.AUTOMATIC, Mode.AUTOMATIC, targetSize,
				targetSize, ops);
	}

	/**
	 * Resize a given image (maintaining its original proportion) to a width and
	 * height no bigger than <code>targetSize</code> using the given scaling
	 * method and apply the given {@link BufferedImageOp}s (if any) to the
	 * result before returning it.
	 * <p/>
	 * A mode of {@link Mode#AUTOMATIC} is used.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param scalingMethod
	 *            The method used for scaling the image; preferring speed to
	 *            quality or a balance of both.
	 * @param targetSize
	 *            The target width and height (square) that you wish the image
	 *            to fit within.
	 * @param ops
	 *            <code>0</code> or more optional image operations (e.g.
	 *            sharpen, blur, etc.) that can be applied to the final result
	 *            before returning the image.
	 * 
	 * @return a new {@link BufferedImage} representing the scaled
	 *         <code>src</code> image.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>scalingMethod</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>targetSize</code> is &lt; 0.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 * 
	 * @see Method
	 */
	public static BufferedImage resize(BufferedImage src, Method scalingMethod,
			int targetSize, BufferedImageOp... ops)
			throws IllegalArgumentException, ImagingOpException {
		return resize(src, scalingMethod, Mode.AUTOMATIC, targetSize,
				targetSize, ops);
	}

	/**
	 * Resize a given image (maintaining its original proportion) to a width and
	 * height no bigger than <code>targetSize</code> (or fitting the image to
	 * the given WIDTH or HEIGHT explicitly, depending on the {@link Mode}
	 * specified) and apply the given {@link BufferedImageOp}s (if any) to the
	 * result before returning it.
	 * <p/>
	 * A scaling method of {@link Method#AUTOMATIC} is used.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param resizeMode
	 *            Used to indicate how imgscalr should calculate the final
	 *            target size for the image, either fitting the image to the
	 *            given width ({@link Mode#FIT_TO_WIDTH}) or fitting the image
	 *            to the given height ({@link Mode#FIT_TO_HEIGHT}). If
	 *            {@link Mode#AUTOMATIC} is passed in, imgscalr will calculate
	 *            proportional dimensions for the scaled image based on its
	 *            orientation (landscape, square or portrait). Unless you have
	 *            very specific size requirements, most of the time you just
	 *            want to use {@link Mode#AUTOMATIC} to "do the right thing".
	 * @param targetSize
	 *            The target width and height (square) that you wish the image
	 *            to fit within.
	 * @param ops
	 *            <code>0</code> or more optional image operations (e.g.
	 *            sharpen, blur, etc.) that can be applied to the final result
	 *            before returning the image.
	 * 
	 * @return a new {@link BufferedImage} representing the scaled
	 *         <code>src</code> image.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>resizeMode</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>targetSize</code> is &lt; 0.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 * 
	 * @see Mode
	 */
	public static BufferedImage resize(BufferedImage src, Mode resizeMode,
			int targetSize, BufferedImageOp... ops)
			throws IllegalArgumentException, ImagingOpException {
		return resize(src, Method.AUTOMATIC, resizeMode, targetSize,
				targetSize, ops);
	}

	/**
	 * Resize a given image (maintaining its original proportion) to a width and
	 * height no bigger than <code>targetSize</code> (or fitting the image to
	 * the given WIDTH or HEIGHT explicitly, depending on the {@link Mode}
	 * specified) using the given scaling method and apply the given
	 * {@link BufferedImageOp}s (if any) to the result before returning it.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param scalingMethod
	 *            The method used for scaling the image; preferring speed to
	 *            quality or a balance of both.
	 * @param resizeMode
	 *            Used to indicate how imgscalr should calculate the final
	 *            target size for the image, either fitting the image to the
	 *            given width ({@link Mode#FIT_TO_WIDTH}) or fitting the image
	 *            to the given height ({@link Mode#FIT_TO_HEIGHT}). If
	 *            {@link Mode#AUTOMATIC} is passed in, imgscalr will calculate
	 *            proportional dimensions for the scaled image based on its
	 *            orientation (landscape, square or portrait). Unless you have
	 *            very specific size requirements, most of the time you just
	 *            want to use {@link Mode#AUTOMATIC} to "do the right thing".
	 * @param targetSize
	 *            The target width and height (square) that you wish the image
	 *            to fit within.
	 * @param ops
	 *            <code>0</code> or more optional image operations (e.g.
	 *            sharpen, blur, etc.) that can be applied to the final result
	 *            before returning the image.
	 * 
	 * @return a new {@link BufferedImage} representing the scaled
	 *         <code>src</code> image.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>scalingMethod</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>resizeMode</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>targetSize</code> is &lt; 0.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 * 
	 * @see Method
	 * @see Mode
	 */
	public static BufferedImage resize(BufferedImage src, Method scalingMethod,
			Mode resizeMode, int targetSize, BufferedImageOp... ops)
			throws IllegalArgumentException, ImagingOpException {
		return resize(src, scalingMethod, resizeMode, targetSize, targetSize,
				ops);
	}

	/**
	 * Resize a given image (maintaining its original proportion) to the target
	 * width and height and apply the given {@link BufferedImageOp}s (if any) to
	 * the result before returning it.
	 * <p/>
	 * A scaling method of {@link Method#AUTOMATIC} and mode of
	 * {@link Mode#AUTOMATIC} are used.
	 * <p/>
	 * <strong>TIP</strong>: See the class description to understand how this
	 * class handles recalculation of the <code>targetWidth</code> or
	 * <code>targetHeight</code> depending on the image's orientation in order
	 * to maintain the original proportion.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param targetWidth
	 *            The target width that you wish the image to have.
	 * @param targetHeight
	 *            The target height that you wish the image to have.
	 * @param ops
	 *            <code>0</code> or more optional image operations (e.g.
	 *            sharpen, blur, etc.) that can be applied to the final result
	 *            before returning the image.
	 * 
	 * @return a new {@link BufferedImage} representing the scaled
	 *         <code>src</code> image.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>targetWidth</code> is &lt; 0 or if
	 *             <code>targetHeight</code> is &lt; 0.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 */
	public static BufferedImage resize(BufferedImage src, int targetWidth,
			int targetHeight, BufferedImageOp... ops)
			throws IllegalArgumentException, ImagingOpException {
		return resize(src, Method.AUTOMATIC, Mode.AUTOMATIC, targetWidth,
				targetHeight, ops);
	}

	/**
	 * Resize a given image (maintaining its original proportion) to the target
	 * width and height using the given scaling method and apply the given
	 * {@link BufferedImageOp}s (if any) to the result before returning it.
	 * <p/>
	 * A mode of {@link Mode#AUTOMATIC} is used.
	 * <p/>
	 * <strong>TIP</strong>: See the class description to understand how this
	 * class handles recalculation of the <code>targetWidth</code> or
	 * <code>targetHeight</code> depending on the image's orientation in order
	 * to maintain the original proportion.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param scalingMethod
	 *            The method used for scaling the image; preferring speed to
	 *            quality or a balance of both.
	 * @param targetWidth
	 *            The target width that you wish the image to have.
	 * @param targetHeight
	 *            The target height that you wish the image to have.
	 * @param ops
	 *            <code>0</code> or more optional image operations (e.g.
	 *            sharpen, blur, etc.) that can be applied to the final result
	 *            before returning the image.
	 * 
	 * @return a new {@link BufferedImage} representing the scaled
	 *         <code>src</code> image.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>scalingMethod</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>targetWidth</code> is &lt; 0 or if
	 *             <code>targetHeight</code> is &lt; 0.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 * 
	 * @see Method
	 */
	public static BufferedImage resize(BufferedImage src, Method scalingMethod,
			int targetWidth, int targetHeight, BufferedImageOp... ops) {
		return resize(src, scalingMethod, Mode.AUTOMATIC, targetWidth,
				targetHeight, ops);
	}

	/**
	 * Resize a given image (maintaining its original proportion) to the target
	 * width and height (or fitting the image to the given WIDTH or HEIGHT
	 * explicitly, depending on the {@link Mode} specified) and apply the given
	 * {@link BufferedImageOp}s (if any) to the result before returning it.
	 * <p/>
	 * A scaling method of {@link Method#AUTOMATIC} is used.
	 * <p/>
	 * <strong>TIP</strong>: See the class description to understand how this
	 * class handles recalculation of the <code>targetWidth</code> or
	 * <code>targetHeight</code> depending on the image's orientation in order
	 * to maintain the original proportion.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param resizeMode
	 *            Used to indicate how imgscalr should calculate the final
	 *            target size for the image, either fitting the image to the
	 *            given width ({@link Mode#FIT_TO_WIDTH}) or fitting the image
	 *            to the given height ({@link Mode#FIT_TO_HEIGHT}). If
	 *            {@link Mode#AUTOMATIC} is passed in, imgscalr will calculate
	 *            proportional dimensions for the scaled image based on its
	 *            orientation (landscape, square or portrait). Unless you have
	 *            very specific size requirements, most of the time you just
	 *            want to use {@link Mode#AUTOMATIC} to "do the right thing".
	 * @param targetWidth
	 *            The target width that you wish the image to have.
	 * @param targetHeight
	 *            The target height that you wish the image to have.
	 * @param ops
	 *            <code>0</code> or more optional image operations (e.g.
	 *            sharpen, blur, etc.) that can be applied to the final result
	 *            before returning the image.
	 * 
	 * @return a new {@link BufferedImage} representing the scaled
	 *         <code>src</code> image.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>resizeMode</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>targetWidth</code> is &lt; 0 or if
	 *             <code>targetHeight</code> is &lt; 0.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 * 
	 * @see Mode
	 */
	public static BufferedImage resize(BufferedImage src, Mode resizeMode,
			int targetWidth, int targetHeight, BufferedImageOp... ops)
			throws IllegalArgumentException, ImagingOpException {
		return resize(src, Method.AUTOMATIC, resizeMode, targetWidth,
				targetHeight, ops);
	}

	/**
	 * Resize a given image (maintaining its original proportion) to the target
	 * width and height (or fitting the image to the given WIDTH or HEIGHT
	 * explicitly, depending on the {@link Mode} specified) using the given
	 * scaling method and apply the given {@link BufferedImageOp}s (if any) to
	 * the result before returning it.
	 * <p/>
	 * <strong>TIP</strong>: See the class description to understand how this
	 * class handles recalculation of the <code>targetWidth</code> or
	 * <code>targetHeight</code> depending on the image's orientation in order
	 * to maintain the original proportion.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param scalingMethod
	 *            The method used for scaling the image; preferring speed to
	 *            quality or a balance of both.
	 * @param resizeMode
	 *            Used to indicate how imgscalr should calculate the final
	 *            target size for the image, either fitting the image to the
	 *            given width ({@link Mode#FIT_TO_WIDTH}) or fitting the image
	 *            to the given height ({@link Mode#FIT_TO_HEIGHT}). If
	 *            {@link Mode#AUTOMATIC} is passed in, imgscalr will calculate
	 *            proportional dimensions for the scaled image based on its
	 *            orientation (landscape, square or portrait). Unless you have
	 *            very specific size requirements, most of the time you just
	 *            want to use {@link Mode#AUTOMATIC} to "do the right thing".
	 * @param targetWidth
	 *            The target width that you wish the image to have.
	 * @param targetHeight
	 *            The target height that you wish the image to have.
	 * @param ops
	 *            <code>0</code> or more optional image operations (e.g.
	 *            sharpen, blur, etc.) that can be applied to the final result
	 *            before returning the image.
	 * 
	 * @return a new {@link BufferedImage} representing the scaled
	 *         <code>src</code> image.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>scalingMethod</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>resizeMode</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>targetWidth</code> is &lt; 0 or if
	 *             <code>targetHeight</code> is &lt; 0.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 * 
	 * @see Method
	 * @see Mode
	 */
	public static BufferedImage resize(BufferedImage src, Method scalingMethod,
			Mode resizeMode, int targetWidth, int targetHeight,
			BufferedImageOp... ops) throws IllegalArgumentException,
			ImagingOpException {
		long t = System.currentTimeMillis();

		if (src == null)
			throw new IllegalArgumentException("src cannot be null");
		if (targetWidth < 0)
			throw new IllegalArgumentException("targetWidth must be >= 0");
		if (targetHeight < 0)
			throw new IllegalArgumentException("targetHeight must be >= 0");
		if (scalingMethod == null)
			throw new IllegalArgumentException(
					"scalingMethod cannot be null. A good default value is Method.AUTOMATIC.");
		if (resizeMode == null)
			throw new IllegalArgumentException(
					"resizeMode cannot be null. A good default value is Mode.AUTOMATIC.");

		BufferedImage result = null;

		int currentWidth = src.getWidth();
		int currentHeight = src.getHeight();

		// <= 1 is a square or landscape-oriented image, > 1 is a portrait.
		float ratio = ((float) currentHeight / (float) currentWidth);

		if (DEBUG)
			log(0,
					"Resizing Image [size=%dx%d, resizeMode=%s, orientation=%s, ratio(H/W)=%f] to [targetSize=%dx%d]",
					currentWidth, currentHeight, resizeMode,
					(ratio <= 1 ? "Landscape/Square" : "Portrait"), ratio,
					targetWidth, targetHeight);

		/*
		 * First determine if ANY size calculation needs to be done, in the case
		 * of FIT_EXACT, ignore image proportions and orientation and just use
		 * what the user sent in, otherwise the proportion of the picture must
		 * be honored.
		 * 
		 * The way that is done is to figure out if the image is in a
		 * LANDSCAPE/SQUARE or PORTRAIT orientation and depending on its
		 * orientation, use the primary dimension (width for LANDSCAPE/SQUARE
		 * and height for PORTRAIT) to recalculate the alternative (height and
		 * width respectively) value that adheres to the existing ratio.
		 * 
		 * This helps make life easier for the caller as they don't need to
		 * pre-compute proportional dimensions before calling the API, they can
		 * just specify the dimensions they would like the image to roughly fit
		 * within and it will do the right thing without mangling the result.
		 */
		if (resizeMode != Mode.FIT_EXACT) {
			if ((ratio <= 1 && resizeMode == Mode.AUTOMATIC)
					|| (resizeMode == Mode.FIT_TO_WIDTH)) {
				// First make sure we need to do any work in the first place
				if (targetWidth == src.getWidth())
					return src;

				// Save for detailed logging (this is cheap).
				int originalTargetHeight = targetHeight;

				/*
				 * Landscape or Square Orientation: Ignore the given height and
				 * re-calculate a proportionally correct value based on the
				 * targetWidth.
				 */
				targetHeight = Math.round((float) targetWidth * ratio);

				if (DEBUG && originalTargetHeight != targetHeight)
					log(1,
							"Auto-Corrected targetHeight [from=%d to=%d] to honor image proportions.",
							originalTargetHeight, targetHeight);
			} else {
				// First make sure we need to do any work in the first place
				if (targetHeight == src.getHeight())
					return src;

				// Save for detailed logging (this is cheap).
				int originalTargetWidth = targetWidth;

				/*
				 * Portrait Orientation: Ignore the given width and re-calculate
				 * a proportionally correct value based on the targetHeight.
				 */
				targetWidth = Math.round((float) targetHeight / ratio);

				if (DEBUG && originalTargetWidth != targetWidth)
					log(1,
							"Auto-Corrected targetWidth [from=%d to=%d] to honor image proportions.",
							originalTargetWidth, targetWidth);
			}
		} else {
			if (DEBUG)
				log(1,
						"Resize Mode FIT_EXACT used, no width/height checking or re-calculation will be done.");
		}

		// If AUTOMATIC was specified, determine the real scaling method.
		if (scalingMethod == Scalr.Method.AUTOMATIC)
			scalingMethod = determineScalingMethod(targetWidth, targetHeight,
					ratio);

		if (DEBUG)
			log(1, "Using Scaling Method: %s", scalingMethod);

		// Now we scale the image
		if (scalingMethod == Scalr.Method.SPEED) {
			result = scaleImage(src, targetWidth, targetHeight,
					RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		} else if (scalingMethod == Scalr.Method.BALANCED) {
			result = scaleImage(src, targetWidth, targetHeight,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		} else if (scalingMethod == Scalr.Method.QUALITY
				|| scalingMethod == Scalr.Method.ULTRA_QUALITY) {
			/*
			 * If we are scaling up (in either width or height - since we know
			 * the image will stay proportional we just check if either are
			 * being scaled up), directly using a single BICUBIC will give us
			 * better results then using Chris Campbell's incremental scaling
			 * operation (and take a lot less time).
			 * 
			 * If we are scaling down, we must use the incremental scaling
			 * algorithm for the best result.
			 */
			if (targetWidth > currentWidth || targetHeight > currentHeight) {
				if (DEBUG)
					log(1,
							"QUALITY scale-up, a single BICUBIC scale operation will be used...");

				/*
				 * BILINEAR and BICUBIC look similar the smaller the scale jump
				 * upwards is, if the scale is larger BICUBIC looks sharper and
				 * less fuzzy. But most importantly we have to use BICUBIC to
				 * match the contract of the QUALITY rendering scalingMethod.
				 * This note is just here for anyone reading the code and
				 * wondering how they can speed their own calls up.
				 */
				result = scaleImage(src, targetWidth, targetHeight,
						RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			} else {
				if (DEBUG)
					log(1,
							"QUALITY scale-down, incremental scaling will be used...");

				/*
				 * Originally we wanted to use BILINEAR interpolation here
				 * because it takes 1/3rd the time that the BICUBIC
				 * interpolation does, however, when scaling large images down
				 * to most sizes bigger than a thumbnail we witnessed noticeable
				 * "softening" in the resultant image with BILINEAR that would
				 * be unexpectedly annoying to a user expecting a "QUALITY"
				 * scale of their original image. Instead BICUBIC was chosen to
				 * honor the contract of a QUALITY scale of the original image.
				 */
				result = scaleImageIncrementally(src, targetWidth,
						targetHeight, scalingMethod,
						RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			}
		}

		if (DEBUG)
			log(0, "Resized Image in %d ms", System.currentTimeMillis() - t);

		// Apply any optional operations (if specified).
		if (ops != null && ops.length > 0)
			result = apply(result, ops);

		return result;
	}

	/**
	 * Used to apply a {@link Rotation} and then <code>0</code> or more
	 * {@link BufferedImageOp}s to a given image and return the result.
	 * <p/>
	 * <strong>TIP</strong>: This operation leaves the original <code>src</code>
	 * image unmodified. If the caller is done with the <code>src</code> image
	 * after getting the result of this operation, remember to call
	 * {@link BufferedImage#flush()} on the <code>src</code> to free up native
	 * resources and make it easier for the GC to collect the unused image.
	 * 
	 * @param src
	 *            The image that will have the rotation applied to it.
	 * @param rotation
	 *            The rotation that will be applied to the image.
	 * @param ops
	 *            Zero or more optional image operations (e.g. sharpen, blur,
	 *            etc.) that can be applied to the final result before returning
	 *            the image.
	 * 
	 * @return a new {@link BufferedImage} representing <code>src</code> rotated
	 *         by the given amount and any optional ops applied to it.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>rotation</code> is <code>null</code>.
	 * @throws ImagingOpException
	 *             if one of the given {@link BufferedImageOp}s fails to apply.
	 *             These exceptions bubble up from the inside of most of the
	 *             {@link BufferedImageOp} implementations and are explicitly
	 *             defined on the imgscalr API to make it easier for callers to
	 *             catch the exception (if they are passing along optional ops
	 *             to be applied). imgscalr takes detailed steps to avoid the
	 *             most common pitfalls that will cause {@link BufferedImageOp}s
	 *             to fail, even when using straight forward JDK-image
	 *             operations.
	 * 
	 * @see Rotation
	 */
	public static BufferedImage rotate(BufferedImage src, Rotation rotation,
			BufferedImageOp... ops) throws IllegalArgumentException,
			ImagingOpException {
		long t = System.currentTimeMillis();

		if (src == null)
			throw new IllegalArgumentException("src cannot be null");
		if (rotation == null)
			throw new IllegalArgumentException("rotation cannot be null");

		if (DEBUG)
			log(0, "Rotating Image [%s]...", rotation);

		/*
		 * Setup the default width/height values from our image.
		 * 
		 * In the case of a 90 or 270 (-90) degree rotation, these two values
		 * flip-flop and we will correct those cases down below in the switch
		 * statement.
		 */
		int newWidth = src.getWidth();
		int newHeight = src.getHeight();

		/*
		 * We create a transform per operation request as (oddly enough) it ends
		 * up being faster for the VM to create, use and destroy these instances
		 * than it is to re-use a single AffineTransform per-thread via the
		 * AffineTransform.setTo(...) methods which was my first choice (less
		 * object creation); after benchmarking this explicit case and looking
		 * at just how much code gets run inside of setTo() I opted for a new AT
		 * for every rotation.
		 * 
		 * Besides the performance win, trying to safely reuse AffineTransforms
		 * via setTo(...) would have required ThreadLocal instances to avoid
		 * race conditions where two or more resize threads are manipulating the
		 * same transform before applying it.
		 * 
		 * Misusing ThreadLocals are one of the #1 reasons for memory leaks in
		 * server applications and since we have no nice way to hook into the
		 * init/destroy Servlet cycle or any other initialization cycle for this
		 * library to automatically call ThreadLocal.remove() to avoid the
		 * memory leak, it would have made using this library *safely* on the
		 * server side much harder.
		 * 
		 * So we opt for creating individual transforms per rotation op and let
		 * the VM clean them up in a GC. I only clarify all this reasoning here
		 * for anyone else reading this code and being tempted to reuse the AT
		 * instances of performance gains; there aren't any AND you get a lot of
		 * pain along with it.
		 */
		AffineTransform tx = new AffineTransform();

		switch (rotation) {
		case CW_90:
			/*
			 * A 90 or -90 degree rotation will cause the height and width to
			 * flip-flop from the original image to the rotated one.
			 */
			newWidth = src.getHeight();
			newHeight = src.getWidth();

			// Reminder: newWidth == result.getHeight() at this point
			tx.translate(newWidth, 0);
			tx.rotate(Math.toRadians(90));

			break;

		case CW_270:
			/*
			 * A 90 or -90 degree rotation will cause the height and width to
			 * flip-flop from the original image to the rotated one.
			 */
			newWidth = src.getHeight();
			newHeight = src.getWidth();

			// Reminder: newHeight == result.getWidth() at this point
			tx.translate(0, newHeight);
			tx.rotate(Math.toRadians(-90));
			break;

		case CW_180:
			tx.translate(newWidth, newHeight);
			tx.rotate(Math.toRadians(180));
			break;

		case FLIP_HORZ:
			tx.translate(newWidth, 0);
			tx.scale(-1.0, 1.0);
			break;

		case FLIP_VERT:
			tx.translate(0, newHeight);
			tx.scale(1.0, -1.0);
			break;
		}

		// Create our target image we will render the rotated result to.
		BufferedImage result = createOptimalImage(src, newWidth, newHeight);
		Graphics2D g2d = (Graphics2D) result.createGraphics();

		/*
		 * Render the resultant image to our new rotatedImage buffer, applying
		 * the AffineTransform that we calculated above during rendering so the
		 * pixels from the old position are transposed to the new positions in
		 * the resulting image correctly.
		 */
		g2d.drawImage(src, tx, null);
		g2d.dispose();

		if (DEBUG)
			log(0, "Rotation Applied in %d ms, result [width=%d, height=%d]",
					System.currentTimeMillis() - t, result.getWidth(),
					result.getHeight());

		// Apply any optional operations (if specified).
		if (ops != null && ops.length > 0)
			result = apply(result, ops);

		return result;
	}

	/**
	 * Used to write out a useful and well-formatted log message by any piece of
	 * code inside of the imgscalr library.
	 * <p/>
	 * If a message cannot be logged (logging is disabled) then this method
	 * returns immediately.
	 * <p/>
	 * <strong>NOTE</strong>: Because Java will auto-box primitive arguments
	 * into Objects when building out the <code>params</code> array, care should
	 * be taken not to call this method with primitive values unless
	 * {@link Scalr#DEBUG} is <code>true</code>; otherwise the VM will be
	 * spending time performing unnecessary auto-boxing calculations.
	 * 
	 * @param depth
	 *            The indentation level of the log message.
	 * @param message
	 *            The log message in <a href=
	 *            "http://download.oracle.com/javase/6/docs/api/java/util/Formatter.html#syntax"
	 *            >format string syntax</a> that will be logged.
	 * @param params
	 *            The parameters that will be swapped into all the place holders
	 *            in the original messages before being logged.
	 * 
	 * @see Scalr#LOG_PREFIX
	 * @see Scalr#LOG_PREFIX_PROPERTY_NAME
	 */
	protected static void log(int depth, String message, Object... params) {
		if (Scalr.DEBUG) {
			System.out.print(Scalr.LOG_PREFIX);

			for (int i = 0; i < depth; i++)
				System.out.print("\t");

			System.out.printf(message, params);
			System.out.println();
		}
	}

	/**
	 * Used to create a {@link BufferedImage} with the most optimal RGB TYPE (
	 * {@link BufferedImage#TYPE_INT_RGB} or {@link BufferedImage#TYPE_INT_ARGB}
	 * ) capable of being rendered into from the given <code>src</code>. The
	 * width and height of both images will be identical.
	 * <p/>
	 * This does not perform a copy of the image data from <code>src</code> into
	 * the result image; see {@link #copyToOptimalImage(BufferedImage)} for
	 * that.
	 * <p/>
	 * We force all rendering results into one of these two types, avoiding the
	 * case where a source image is of an unsupported (or poorly supported)
	 * format by Java2D causing the rendering result to end up looking terrible
	 * (common with GIFs) or be totally corrupt (e.g. solid black image).
	 * <p/>
	 * Originally reported by Magnus Kvalheim from Movellas when scaling certain
	 * GIF and PNG images.
	 * 
	 * @param src
	 *            The source image that will be analyzed to determine the most
	 *            optimal image type it can be rendered into.
	 * 
	 * @return a new {@link BufferedImage} representing the most optimal target
	 *         image type that <code>src</code> can be rendered into.
	 * 
	 * @see <a
	 *      href="http://www.mail-archive.com/java2d-interest@capra.eng.sun.com/msg05621.html">How
	 *      Java2D handles poorly supported image types</a>
	 * @see <a
	 *      href="http://code.google.com/p/java-image-scaling/source/browse/trunk/src/main/java/com/mortennobel/imagescaling/MultiStepRescaleOp.java">Thanks
	 *      to Morten Nobel for implementation hint</a>
	 */
	protected static BufferedImage createOptimalImage(BufferedImage src) {
		return createOptimalImage(src, src.getWidth(), src.getHeight());
	}

	/**
	 * Used to create a {@link BufferedImage} with the given dimensions and the
	 * most optimal RGB TYPE ( {@link BufferedImage#TYPE_INT_RGB} or
	 * {@link BufferedImage#TYPE_INT_ARGB} ) capable of being rendered into from
	 * the given <code>src</code>.
	 * <p/>
	 * This does not perform a copy of the image data from <code>src</code> into
	 * the result image; see {@link #copyToOptimalImage(BufferedImage)} for
	 * that.
	 * <p/>
	 * We force all rendering results into one of these two types, avoiding the
	 * case where a source image is of an unsupported (or poorly supported)
	 * format by Java2D causing the rendering result to end up looking terrible
	 * (common with GIFs) or be totally corrupt (e.g. solid black image).
	 * <p/>
	 * Originally reported by Magnus Kvalheim from Movellas when scaling certain
	 * GIF and PNG images.
	 * 
	 * @param src
	 *            The source image that will be analyzed to determine the most
	 *            optimal image type it can be rendered into.
	 * @param width
	 *            The width of the newly created resulting image.
	 * @param height
	 *            The height of the newly created resulting image.
	 * 
	 * @return a new {@link BufferedImage} representing the most optimal target
	 *         image type that <code>src</code> can be rendered into.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>width</code> or <code>height</code> are &lt; 0.
	 * 
	 * @see <a
	 *      href="http://www.mail-archive.com/java2d-interest@capra.eng.sun.com/msg05621.html">How
	 *      Java2D handles poorly supported image types</a>
	 * @see <a
	 *      href="http://code.google.com/p/java-image-scaling/source/browse/trunk/src/main/java/com/mortennobel/imagescaling/MultiStepRescaleOp.java">Thanks
	 *      to Morten Nobel for implementation hint</a>
	 */
	protected static BufferedImage createOptimalImage(BufferedImage src,
			int width, int height) throws IllegalArgumentException {
		if (width < 0 || height < 0)
			throw new IllegalArgumentException("width [" + width
					+ "] and height [" + height + "] must be >= 0");

		return new BufferedImage(
				width,
				height,
				(src.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB
						: BufferedImage.TYPE_INT_ARGB));
	}

	/**
	 * Used to copy a {@link BufferedImage} from a non-optimal type into a new
	 * {@link BufferedImage} instance of an optimal type (RGB or ARGB). If
	 * <code>src</code> is already of an optimal type, then it is returned
	 * unmodified.
	 * <p/>
	 * This method is meant to be used by any calling code (imgscalr's or
	 * otherwise) to convert any inbound image from a poorly supported image
	 * type into the 2 most well-supported image types in Java2D (
	 * {@link BufferedImage#TYPE_INT_RGB} or {@link BufferedImage#TYPE_INT_ARGB}
	 * ) in order to ensure all subsequent graphics operations are performed as
	 * efficiently and correctly as possible.
	 * <p/>
	 * When using Java2D to work with image types that are not well supported,
	 * the results can be anything from exceptions bubbling up from the depths
	 * of Java2D to images being completely corrupted and just returned as solid
	 * black.
	 * 
	 * @param src
	 *            The image to copy (if necessary) into an optimally typed
	 *            {@link BufferedImage}.
	 * 
	 * @return a representation of the <code>src</code> image in an optimally
	 *         typed {@link BufferedImage}, otherwise <code>src</code> if it was
	 *         already of an optimal type.
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>src</code> is <code>null</code>.
	 */
	protected static BufferedImage copyToOptimalImage(BufferedImage src)
			throws IllegalArgumentException {
		if (src == null)
			throw new IllegalArgumentException("src cannot be null");

		// Calculate the type depending on the presence of alpha.
		int type = (src.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB
				: BufferedImage.TYPE_INT_ARGB);
		BufferedImage result = new BufferedImage(src.getWidth(),
				src.getHeight(), type);

		// Render the src image into our new optimal source.
		Graphics g = result.getGraphics();
		g.drawImage(src, 0, 0, null);
		g.dispose();

		return result;
	}

	/**
	 * Used to determine the scaling {@link Method} that is best suited for
	 * scaling the image to the targeted dimensions.
	 * <p/>
	 * This method is intended to be used to select a specific scaling
	 * {@link Method} when a {@link Method#AUTOMATIC} method is specified. This
	 * method utilizes the {@link Scalr#THRESHOLD_QUALITY_BALANCED} and
	 * {@link Scalr#THRESHOLD_BALANCED_SPEED} thresholds when selecting which
	 * method should be used by comparing the primary dimension (width or
	 * height) against the threshold and seeing where the image falls. The
	 * primary dimension is determined by looking at the orientation of the
	 * image: landscape or square images use their width and portrait-oriented
	 * images use their height.
	 * 
	 * @param targetWidth
	 *            The target width for the scaled image.
	 * @param targetHeight
	 *            The target height for the scaled image.
	 * @param ratio
	 *            A height/width ratio used to determine the orientation of the
	 *            image so the primary dimension (width or height) can be
	 *            selected to test if it is greater than or less than a
	 *            particular threshold.
	 * 
	 * @return the fastest {@link Method} suited for scaling the image to the
	 *         specified dimensions while maintaining a good-looking result.
	 */
	protected static Method determineScalingMethod(int targetWidth,
			int targetHeight, float ratio) {
		// Get the primary dimension based on the orientation of the image
		int length = (ratio <= 1 ? targetWidth : targetHeight);

		// Default to speed
		Method result = Method.SPEED;

		// Figure out which scalingMethod should be used
		if (length <= Scalr.THRESHOLD_QUALITY_BALANCED)
			result = Method.QUALITY;
		else if (length <= Scalr.THRESHOLD_BALANCED_SPEED)
			result = Method.BALANCED;

		if (DEBUG)
			log(2, "AUTOMATIC scaling method selected: %s", result.name());

		return result;
	}

	/**
	 * Used to implement a straight-forward image-scaling operation using Java
	 * 2D.
	 * <p/>
	 * This method uses the Oracle-encouraged method of
	 * <code>Graphics2D.drawImage(...)</code> to scale the given image with the
	 * given interpolation hint.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param targetWidth
	 *            The target width for the scaled image.
	 * @param targetHeight
	 *            The target height for the scaled image.
	 * @param interpolationHintValue
	 *            The {@link RenderingHints} interpolation value used to
	 *            indicate the method that {@link Graphics2D} should use when
	 *            scaling the image.
	 * 
	 * @return the result of scaling the original <code>src</code> to the given
	 *         dimensions using the given interpolation method.
	 */
	protected static BufferedImage scaleImage(BufferedImage src,
			int targetWidth, int targetHeight, Object interpolationHintValue) {
		// Setup the rendering resources to match the source image's
		BufferedImage result = createOptimalImage(src, targetWidth,
				targetHeight);
		Graphics2D resultGraphics = result.createGraphics();

		// Scale the image to the new buffer using the specified rendering hint.
		resultGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				interpolationHintValue);
		resultGraphics.drawImage(src, 0, 0, targetWidth, targetHeight, null);

		// Just to be clean, explicitly dispose our temporary graphics object
		resultGraphics.dispose();

		// Return the scaled image to the caller.
		return result;
	}

	/**
	 * Used to implement Chris Campbell's incremental-scaling algorithm: <a
	 * href="http://today.java.net/pub/a/today/2007/04/03/perils
	 * -of-image-getscaledinstance
	 * .html">http://today.java.net/pub/a/today/2007/04/03/perils
	 * -of-image-getscaledinstance.html</a>.
	 * <p/>
	 * Modifications to the original algorithm are variable names and comments
	 * added for clarity and the hard-coding of using BICUBIC interpolation as
	 * well as the explicit "flush()" operation on the interim BufferedImage
	 * instances to avoid resource leaking.
	 * 
	 * @param src
	 *            The image that will be scaled.
	 * @param targetWidth
	 *            The target width for the scaled image.
	 * @param targetHeight
	 *            The target height for the scaled image.
	 * @param scalingMethod
	 *            The scaling method specified by the user (or calculated by
	 *            imgscalr) to use for this incremental scaling operation.
	 * @param interpolationHintValue
	 *            The {@link RenderingHints} interpolation value used to
	 *            indicate the method that {@link Graphics2D} should use when
	 *            scaling the image.
	 * 
	 * @return an image scaled to the given dimensions using the given rendering
	 *         hint.
	 */
	protected static BufferedImage scaleImageIncrementally(BufferedImage src,
			int targetWidth, int targetHeight, Method scalingMethod,
			Object interpolationHintValue) {
		boolean hasReassignedSrc = false;
		int incrementCount = 0;
		int currentWidth = src.getWidth();
		int currentHeight = src.getHeight();

		/*
		 * The original QUALITY mode, representing Chris Campbell's algorithm,
		 * is to step down by 1/2s every time when scaling the image
		 * incrementally. Users pointed out that using this method to scale
		 * images with noticeable straight lines left them really jagged in
		 * smaller thumbnail format.
		 * 
		 * After investigation it was discovered that scaling incrementally by
		 * smaller increments was the ONLY way to make the thumbnail sized
		 * images look less jagged and more accurate; almost matching the
		 * accuracy of Mac's built in thumbnail generation which is the highest
		 * quality resize I've come across (better than GIMP Lanczos3 and
		 * Windows 7).
		 * 
		 * A divisor of 7 was chose as using 5 still left some jaggedness in the
		 * image while a divisor of 8 or higher made the resulting thumbnail too
		 * soft; like our OP_ANTIALIAS convolve op had been forcibly applied to
		 * the result even if the user didn't want it that soft.
		 * 
		 * Using a divisor of 7 for the ULTRA_QUALITY seemed to be the sweet
		 * spot.
		 * 
		 * NOTE: Below when the actual fraction is used to calculate the small
		 * portion to subtract from the current dimension, this is a
		 * progressively smaller and smaller chunk. When the code was changed to
		 * do a linear reduction of the image of equal steps for each
		 * incremental resize (e.g. say 50px each time) the result was
		 * significantly worse than the progressive approach used below; even
		 * when a very high number of incremental steps (13) was tested.
		 */
		int fraction = (scalingMethod == Method.ULTRA_QUALITY ? 7 : 2);

		do {
			int prevCurrentWidth = currentWidth;
			int prevCurrentHeight = currentHeight;

			/*
			 * If the current width is bigger than our target, cut it in half
			 * and sample again.
			 */
			if (currentWidth > targetWidth) {
				currentWidth -= (currentWidth / fraction);

				/*
				 * If we cut the width too far it means we are on our last
				 * iteration. Just set it to the target width and finish up.
				 */
				if (currentWidth < targetWidth)
					currentWidth = targetWidth;
			}

			/*
			 * If the current height is bigger than our target, cut it in half
			 * and sample again.
			 */

			if (currentHeight > targetHeight) {
				currentHeight -= (currentHeight / fraction);

				/*
				 * If we cut the height too far it means we are on our last
				 * iteration. Just set it to the target height and finish up.
				 */

				if (currentHeight < targetHeight)
					currentHeight = targetHeight;
			}

			/*
			 * Stop when we cannot incrementally step down anymore.
			 * 
			 * This used to use a || condition, but that would cause problems
			 * when using FIT_EXACT such that sometimes the width OR height
			 * would not change between iterations, but the other dimension
			 * would (e.g. resizing 500x500 to 500x250).
			 * 
			 * Now changing this to an && condition requires that both
			 * dimensions do not change between a resize iteration before we
			 * consider ourselves done.
			 */
			if (prevCurrentWidth == currentWidth
					&& prevCurrentHeight == currentHeight)
				break;

			if (DEBUG)
				log(2, "Scaling from [%d x %d] to [%d x %d]", prevCurrentWidth,
						prevCurrentHeight, currentWidth, currentHeight);

			// Render the incremental scaled image.
			BufferedImage incrementalImage = scaleImage(src, currentWidth,
					currentHeight, interpolationHintValue);

			/*
			 * Before re-assigning our interim (partially scaled)
			 * incrementalImage to be the new src image before we iterate around
			 * again to process it down further, we want to flush() the previous
			 * src image IF (and only IF) it was one of our own temporary
			 * BufferedImages created during this incremental down-sampling
			 * cycle. If it wasn't one of ours, then it was the original
			 * caller-supplied BufferedImage in which case we don't want to
			 * flush() it and just leave it alone.
			 */
			if (hasReassignedSrc)
				src.flush();

			/*
			 * Now treat our incremental partially scaled image as the src image
			 * and cycle through our loop again to do another incremental
			 * scaling of it (if necessary).
			 */
			src = incrementalImage;

			/*
			 * Keep track of us re-assigning the original caller-supplied source
			 * image with one of our interim BufferedImages so we know when to
			 * explicitly flush the interim "src" on the next cycle through.
			 */
			hasReassignedSrc = true;

			// Track how many times we go through this cycle to scale the image.
			incrementCount++;
		} while (currentWidth != targetWidth || currentHeight != targetHeight);

		if (DEBUG)
			log(2, "Incrementally Scaled Image in %d steps.", incrementCount);

		/*
		 * Once the loop has exited, the src image argument is now our scaled
		 * result image that we want to return.
		 */
		return src;
	}
}
