package com.rick.test.http.converter.yml;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.OutputStream;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: 添加新到media转换 @Component注解会加载在所有converter的第一个。优先json Converter。要改变顺序，WebMvcConfigurer中去实现方法extendMessageConverters
 * @author: Rick.Xuj
 * @date: 9/28/20 10:04 AM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
//@Component
public class Yml2HttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public Yml2HttpMessageConverter() {
        super(new MediaType[]{new MediaType("application", "yml"), new MediaType("application", "ymal")});
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        Yaml yaml = new Yaml();
        return yaml.loadAs(httpInputMessage.getBody(), aClass);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        Yaml yaml = new Yaml();
        OutputStream outputStream = httpOutputMessage.getBody();
        outputStream.write(yaml.dump(o).getBytes());
        outputStream.close();
    }
}
