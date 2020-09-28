package com.rick.test.persistence.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

/**
 * https://zenidas.wordpress.com/recipes/jpa-converter-as-json/
 * // TODO 这个有问题，测试未通过
 * @param <T>
 */
public abstract class BaseArrayConverter<T> extends BaseJSONConverter implements
        AttributeConverter<T[], String> {

    private Class<T[]> entityTypeClass;

    @Override
    public String convertToDatabaseColumn(T[] attribute) {
        final ObjectMapper mapper = getMapper();
//        if (attribute == null || attribute.length == 0) {
//            return "";
//        }
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public T[] convertToEntityAttribute(String dbData) {
        final ObjectMapper mapper = getMapper();
        try {
            if (StringUtils.isEmpty(dbData)) {
                return null;
            }
            return mapper.readValue(dbData, getEntityTypeClass());
        } catch (IOException e) {
            return null;
        }
    }

    private void initGenericType() {
        if (entityTypeClass == null) {
            ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            entityTypeClass = ((Class<T[]>) parameterizedType.getActualTypeArguments()[0]);
        }
    }

    private Class<T[]> getEntityTypeClass() {
        initGenericType();
        return entityTypeClass;
    }
}
