package com.xunqi.gulimall.product.controller;

import com.xunqi.common.miniomanager.MinioManager;
import com.xunqi.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chengyl
 * @since 2022-03-06 14:26:49
 */
@RestController
@RequestMapping("product/category")
public class MInioController {
    private final MinioManager minioManager;

    public MInioController(MinioManager minioManager) {
        this.minioManager = minioManager;
    }

    /**
     * 上传文件
     */
    @RequestMapping("/uploade")
    public R update(MultipartFile file ){

        return minioManager.uploadFiles(file, null);
    }
}
