package com.wanhe.springboottest.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File
import javax.servlet.MultipartConfigElement

@Configuration
open class MultipartConfig {
    @Value("\${spring.http.multipart.max-file-size}")
    private lateinit var maxFileSize: String
    @Value("\${spring.http.multipart.max-request-size}")
    private lateinit var maxRequestSize: String

    val UPLOAD_PATH = "upload"
    val DOWNLOAD_PATH = "upload"

    @Bean
    open fun multipartConfigElement(): MultipartConfigElement {
        File(UPLOAD_PATH).mkdirs()
        File(DOWNLOAD_PATH).mkdirs()

        val factory = MultipartConfigFactory()
        factory.setLocation(UPLOAD_PATH)
        factory.setMaxFileSize(maxFileSize)
        factory.setMaxRequestSize(maxRequestSize)
        return factory.createMultipartConfig()
    }
}