package com.rick.test.Validator;

import com.rick.test.model.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/28/20 3:18 PM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
public class PhoneNumberValidator implements
        ConstraintValidator<PhoneNumberConstraint, Phone> {

    @Override
    public void initialize(PhoneNumberConstraint constraintAnnotation) {
    }

    /**
     * @param phone
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Phone phone, ConstraintValidatorContext context) {
        if (Objects.isNull(phone)) {
            return true;
        }

        return (phone.getCode() + "-" + phone.getNumber()).matches("\\d+[-]\\d+");
    }
}
