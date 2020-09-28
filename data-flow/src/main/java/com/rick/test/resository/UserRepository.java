package com.rick.test.resository;

import com.rick.test.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/28/20 3:45 PM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
public interface UserRepository extends JpaRepository<UserDTO, Long> {
}
