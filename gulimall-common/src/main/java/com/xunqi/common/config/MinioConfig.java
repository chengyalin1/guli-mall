package com.xunqi.common.config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
  * @className: MinioConfig
  * @author Hope
  * @date 2020/7/28 13:43 
  * @description: MinioConfig
  */

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {


    @ApiModelProperty("默认存储桶")
    private String bucketName="ceshi";

    @Bean
    public MinioClient getMinioClient() throws InvalidEndpointException, InvalidPortException {
        MinioClient minioClient = new MinioClient("1.15.24.17", 9000, "admin", "12345678", false);

        return minioClient;
    }
}