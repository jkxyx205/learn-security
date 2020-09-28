package com.rick.test.persistence.converter;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/28/20 4:46 PM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseJSONConverter {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        // optional: customisations to the object mapper
//        MAPPER.registerModule(new JodaModule());
        MAPPER.setSerializationInclusion(Include.NON_NULL);
    }

    public static ObjectMapper getMapper() {
        return MAPPER;
    }
}
