package com.app.cloudinary;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = ObjectUtils.asMap(
            "cloud_name", "dl4oacfha",
            "api_key", "799599243955591",
            "api_secret", "zTU0QrcmhiHvtQ1DbMgeCN_dyEk"
        );
        return new Cloudinary(config);
    }
}
