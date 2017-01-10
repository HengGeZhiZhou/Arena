package priv.lyh.arena.action;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import priv.lyh.arena.entity.ReturnInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.exception.RequestException;
import priv.lyh.arena.exception.ServiceException;
import priv.lyh.arena.service.UserInfoService;
import priv.lyh.arena.util.ReadRequestMessage;
import priv.lyh.arena.util.ResultCode;

import javax.annotation.Resource;

import static priv.lyh.arena.util.ResultCode.*;


@Component("userLogin")
@Scope("prototype")
public class UserLoginAction extends BaseAction {

    private UserInfoService userInfoService;
    private ReturnInfo returnInfo;

    @Autowired
    public void setReturnInfo(ReturnInfo returnInfo) {
        this.returnInfo = returnInfo;
    }

    public ReturnInfo getReturnInfo() {
        return returnInfo;
    }

    @Resource
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    @SuppressWarnings("unchecked")
    public String register() throws RequestException, ServiceException {
        try {
            UserLogin userLogin =ReadRequestMessage.read(this.request,this.response,UserLogin.class);
            String id = userInfoService.registerService(userLogin);
            returnInfo.setCode(REQUEST_SUCCESS);
            returnInfo.setMsg(REQUEST_SUCCESS_MSG);
            returnInfo.setObj(id);
        } catch (RequestException e) {
            returnInfo.setCode(SEND_FAIL);
            returnInfo.setMsg(SEND_FAIL_MSG);
            throw new RequestException(SEND_FAIL_MSG);
        } catch (Exception e) {
            returnInfo.setCode(REGISTER_FAIL);
            returnInfo.setMsg(REGISTER_FAIL_MSG);
            throw new ServiceException(REGISTER_FAIL_MSG);
        }
        return "register";
    }

//    @SuppressWarnings("unchecked")
//    public String loginCheck(){
//
//    }


}
