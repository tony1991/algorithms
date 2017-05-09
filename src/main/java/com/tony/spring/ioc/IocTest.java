package com.tony.spring.ioc;

import com.tony.spring.ioc.model.User;
import com.tony.spring.ioc.service.UserService;

public class IocTest {

    public static void main(String[] args) throws Exception {
        // 加载配置文件
        BeanFactory context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        User user = new User();
        
        UserService service = (UserService) context.getBean("userService");
        service.add(user);
    }
}
