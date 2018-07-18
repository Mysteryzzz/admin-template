package com.mlearn.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.InputStream;

public class QiNiuUtil {

    private static final String ACCESS_KEY = "FYZ2-x4KSE3guIf2VLwx7ufC-UOYd9sFuZ3IAjzF";
    private static final String SECRET_KEY = "6PyHxCRo_DPJ6-B7G-R4Sl4JgxsiUUI1rUz3ZpEp";
    private static final String BUCKET = "rezeros";
    private static final String PATH = "http://pbuheihcs.bkt.clouddn.com";


    public static String fileUpload(InputStream file, String fileName) {


        Configuration configuration = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(configuration);


        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET);
        try {
            Response response = uploadManager.put(file, fileName, upToken, null, null);
            // 解析上传成功的结果
            DefaultPutRet putRet = JsonUtil.json2Obj(response.bodyString(), DefaultPutRet.class);

            String returnPath = PATH + "/" + putRet.key;
            return returnPath;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

        return "error in uploading";
    }


}
