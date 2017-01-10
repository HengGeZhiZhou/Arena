package priv.lyh.arena.action;

import com.google.gson.Gson;

import org.junit.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import priv.lyh.arena.entity.ReturnInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.service.UserInfoService;
import priv.lyh.arena.util.ResultCode;

import javax.annotation.Resource;
import java.io.BufferedReader;


@Component("userLogin")
@Scope("prototype")
public class UserLoginAction extends BaseAction {

    private UserInfoService userInfoService;
    private ReturnInfo returnInfo;

    public ReturnInfo getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(ReturnInfo returnInfo) {
        this.returnInfo = returnInfo;
    }

    @Resource
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    public String register() throws Exception {
        Gson gson = new Gson();
        this.response.setContentType("text/html;charset=utf-8");
        this.response.setCharacterEncoding("UTF-8");
        StringBuffer json = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        Gson gson1 = new Gson();
        UserLogin userLogin = gson1.fromJson(json.toString(), UserLogin.class);
        System.out.println(userInfoService.registerService(userLogin));
        returnInfo.setStatus(ResultCode.requestSuccess);
        returnInfo.setObj(140000111);
        return "success";
    }
}
