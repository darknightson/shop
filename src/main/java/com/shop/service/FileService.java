package com.shop.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Log
@Service
public class FileService {

    public String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {

        UUID uuid = UUID.randomUUID();
        String extension = originalName.substring(originalName.lastIndexOf("."));
        String saveFileName = uuid.toString() + extension;
        String fileUploadFullPath = uploadPath + "/" + saveFileName;
        FileOutputStream fos = new FileOutputStream(fileUploadFullPath);

        fos.write(fileData);
        fos.close();
        return saveFileName;
    }

    public void deleteFile(String filePath) throws Exception {
        File deleteFile = new File(filePath);
        if (deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일 삭제 성공");
        }
        else {
            log.info("파일 삭제 실패");
        }
    }
}
