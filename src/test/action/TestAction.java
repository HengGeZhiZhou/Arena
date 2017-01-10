package test.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import priv.lyh.arena.entity.UserLogin;
import test.service.TestService;

import javax.annotation.Resource;


@Component("luo")
@Scope("prototype")
public class TestAction extends ActionSupport {

    private UserLogin userLogin=new UserLogin();

    public void  setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    @Resource
    TestService testService;
    public String execute(){
//        testService.say();
        userLogin.setId("1");
        userLogin.setEmail("lyh");
        userLogin.setPassword("123");
        return "success";
    }

}
