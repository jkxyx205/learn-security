package com.rick.test.converter;

import com.rick.test.model.Phone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: component 自动注册，非@RequestBody 接收对象序列化
 * @author: Rick.Xu
 * @date: 9/28/20 12:14 AM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
@Component
public class PhoneConverter implements Converter<String, Phone> {

    @Override
    public Phone convert(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }

        String[] phonetArr = source.split("-");
        Phone phone = new Phone();
        phone.setCode(phonetArr[0]);
        phone.setNumber(phonetArr[1]);

        return phone;
    }
}
