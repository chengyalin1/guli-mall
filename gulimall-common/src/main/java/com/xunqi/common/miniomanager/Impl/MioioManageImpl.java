package com.xunqi.common.miniomanager.Impl;


import com.xunqi.common.config.MinioConfig;
import com.xunqi.common.miniomanager.MinioManager;
import com.xunqi.common.service.MinioService;
import com.xunqi.common.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author chengyl
 * @since 2022-03-04 08:40:02
 */
@Service
public class MioioManageImpl implements MinioManager {
    @Autowired
    private MinioService minioService;

    @Autowired
    private MinioConfig minioConfig;

    @Override
    public R uploadFiles(MultipartFile file, String bucketName) {
        try {
            bucketName = StringUtils.isNotBlank(bucketName) ? bucketName : minioConfig.getBucketName();
            if (!minioService.bucketExists(bucketName)) {
                minioService.makeBucket(bucketName);
            }
            String fileName = file.getOriginalFilename();
            String objectName = new SimpleDateFormat("yyyy/MM/dd/").format(new Date())
                + UUID.randomUUID().toString().replaceAll("-", "")
                + Objects.requireNonNull(fileName).substring(fileName.lastIndexOf("."));

            InputStream inputStream = file.getInputStream();
            minioService.putObject(bucketName, objectName, inputStream);
            inputStream.close();
            return R.ok().put("url", (minioService.getObjectUrl(bucketName, objectName)));

        } catch (Exception e) {
            e.printStackTrace();
            return R.error("上传失败");
        }
    }
}
