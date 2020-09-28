package com.rick.test.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rick.test.model.Address;

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
public class AddressJsonSerializer extends JsonSerializer<Address> {

    @Override
    public void serialize(Address address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        address.setAddrDetail("China "+ address.getAddrDetail());
        jsonGenerator.writeObject(address);
    }
}
