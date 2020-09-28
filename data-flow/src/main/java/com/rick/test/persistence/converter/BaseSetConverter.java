package com.rick.test.persistence.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Set;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/28/20 5:07 PM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
public abstract class BaseSetConverter<T> extends BaseJSONConverter implements AttributeConverter<Set<T>, String> {

    @Override
    public String convertToDatabaseColumn(Set<T> attribute) {
        final ObjectMapper mapper = getMapper();
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public Set<T> convertToEntityAttribute(String dbData) {
        final ObjectMapper mapper = getMapper();
        try {
            if (StringUtils.isEmpty(dbData)) {
                return null;
            }
            return mapper.readValue(dbData, new TypeReference<Set<T>>() {});
        } catch (IOException e) {
            return null;
        }
    }
}