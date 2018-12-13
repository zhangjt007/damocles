package com.solo.damocles.lab.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.*;

import java.io.IOException;

/**
 * ResourceLoader测试类
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/11 11:38 AM
 */
public class ResourceLoaderTest {
    public static final Logger logger = LoggerFactory.getLogger(ResourceLoaderTest.class);

    public static void main(String[] args) {

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource fileResource1 = resourceLoader.getResource("/Users/solo/log/appserver/app.log");
        logger.info("fileResource1 is FileSystemResource:" + (fileResource1 instanceof FileSystemResource));

        Resource fileResource2 = resourceLoader.getResource("/Users/solo/log/appserver/app.log");
        logger.info("fileResource2 is ClassPathResource:" + (fileResource2 instanceof ClassPathResource));

        Resource urlResource1 = resourceLoader.getResource("file:/Users/solo/log/appserver/app.log");
        logger.info("urlResource1 is UrlResource:" + (urlResource1 instanceof UrlResource));

        Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
        logger.info("urlResource1 is urlResource:" + (urlResource2 instanceof UrlResource));
    }
}
