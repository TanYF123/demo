package com.tyf.springboot.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FastJsonConfiguration {
    @Bean
    public HttpMessageConverters fastJsonConverter() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //自定义格式化输出
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,                 //优雅的格式化
                SerializerFeature.WriteNullStringAsEmpty,       //使用空字符代替null
                SerializerFeature.WriteNullNumberAsZero,        //使用0代替null数字
                SerializerFeature.WriteDateUseDateFormat,       //日期格式化
                SerializerFeature.DisableCircularReferenceDetect);//禁止循环引用
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }
}
