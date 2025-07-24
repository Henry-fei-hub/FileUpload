package delicacy.file.servlet;

import delicacy.servlet.AbstractProcessores;

public class FileUploadProcessors extends AbstractProcessores{


        @Override
	public void initTables() {
    	DAOS.put("StaticResourceTransfer", "com.file.db.handler.StaticResourceTransferHandler");
		DAOS.put("ImageConfig", "com.file.db.handler.ImageConfigHandler");
		DAOS.put("FileManage", "com.file.db.handler.FileManageHandler");
	}

}

