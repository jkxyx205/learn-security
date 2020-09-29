package com.rick.test.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rick.test.validator.PhoneNumberConstraint;
import com.rick.test.converter.AddressJsonSerializer;
import com.rick.test.persistence.converter.ObjectConverter;
import com.rick.test.persistence.converter.ObjectListConverter;
import com.rick.test.persistence.converter.ObjectSetConverter;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/27/20 11:47 PM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
@Data
@Entity
@Table(name = "t_user")
public class UserDTO {
    @Id
    private Long id;

    @NotBlank
    private String username;

    private Short age;

    private Double score;

    private SexEnum sex;

    /**
     * HashSet实现，不能保证顺序。一
     */
    @Convert(converter = ObjectSetConverter.class)
     private Set<String> tags;

    /**
     * 一般前端做唯一检查，后台用List或Array接收，做去重处理
     */
//    @Convert(converter = ObjectArrayConverter.class)
//    private String[] tags;


    @Convert(converter = ObjectConverter.class)
    @JsonSerialize(using = AddressJsonSerializer.class)
    private Address address;

    private Boolean vip;

    private LocalDate birthday;

    /**
     * ArrayList实现
     */
//    @Convert(converter = ObjectConverter.class)
    @Convert(converter = ObjectListConverter.class)
    private List<Award> awardList;

    /**
     * 数组: 测试失败
     */
//    @Convert(converter = ObjectArrayConverter.class)
//    private Award[] awardArray;

    /**
     * 自定义转换器；
     * PhoneJsonDeserializer：@RequestBody接收
     * PhoneConverter：非@RequestBody接收
     */
    @PhoneNumberConstraint
    @Convert(converter = ObjectConverter.class)
    private Phone phone;

}
