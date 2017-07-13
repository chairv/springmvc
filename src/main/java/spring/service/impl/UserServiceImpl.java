package spring.service.impl;

import org.springframework.stereotype.Service;

import spring.service.UserService;

/**
 * Created by tancw on 2017/7/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void show() {
        System.out.println("userServie");
    }
}
