package com.rick.test.controller;

import com.rick.test.model.Phone;
import com.rick.test.model.UserDTO;
import com.rick.test.resository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/27/20 11:57 PM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping// (produces = "application/yml")
    public UserDTO getData(@RequestBody @Valid UserDTO userDTO, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception(result.getAllErrors().toString());
        }
        userRepository.save(userDTO);

        log.info(userDTO.toString());
        log.info("------------------------");
//        log.info(userRepository.findById(1000L).get().toString());

        return userDTO;
    }

    @GetMapping("phone")
    public Phone getData2(Phone phone) {
        log.info(phone.toString());
        return phone;
    }
}
