package com.xunqi.common.miniomanager;


import com.xunqi.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chengyl
 * @since 2022-03-04 08:40:54
 */
public interface MinioManager {
    R uploadFiles(MultipartFile file, String bucketName);
}
