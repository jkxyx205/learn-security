package com.rick.test.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.rick.test.model.Phone;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: @RequestBody 接收对象序列化
 * @author: Rick.Xu
 * @date: 9/28/20 12:36 AM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
@JsonComponent
public class PhoneJsonDeserializer extends JsonDeserializer<Phone> {
    @Override
    public Phone deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String[] phonetArr = node.asText().split("-");
        Phone phone = new Phone();
        phone.setCode(phonetArr[0]);
        phone.setNumber(phonetArr[1]);
        return phone;
    }
}
