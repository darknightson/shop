package com.shop.dto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
//@PropertySource("file:/Users/anthony/2023study/shop/file/sms.properties")
public class ProperTestConfig {

    //@Value("${smsYn}")
    private String smsYn;
}
