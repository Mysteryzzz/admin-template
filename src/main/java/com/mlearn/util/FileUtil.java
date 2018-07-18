package com.mlearn.util;

import com.mlearn.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {

    public static String saveFileReturnPath(MultipartFile file, String path) {
        String sqlPath = null;
        if (file.isEmpty()) {
            return sqlPath;
        }
        String localPath = "D:\\images\\";
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String contentType = file.getContentType();
        String suffixName = contentType.substring(contentType.indexOf("/") + 1);
        String fileName = uuid + "." + suffixName;
        try {
            file.transferTo(new File(localPath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlPath = "/" + path + "/" + fileName;
        return sqlPath;
    }
}
