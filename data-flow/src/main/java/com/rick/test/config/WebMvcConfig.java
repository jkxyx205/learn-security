package com.rick.test.config;

import com.rick.test.http.converter.yml.Yml2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/28/20 11:45 AM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * https://www.cnblogs.com/slankka/p/11437034.html
     * 加到最后
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new Yml2HttpMessageConverter());
    }
}
