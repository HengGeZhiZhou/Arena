package test.service.impl;

import org.springframework.stereotype.Service;
import test.service.TestService;

/**
 * Created by Administrator on 2017/1/8.
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Override
    public void say() {
        System.out.println("hello service");
    }
}
