package priv.lyh.arena.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import priv.lyh.arena.entity.ReturnInfo;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.exception.RequestException;
import priv.lyh.arena.exception.ServiceException;
import priv.lyh.arena.service.UserInfoService;
import priv.lyh.arena.util.ReadRequestMessage;


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
            UserLogin userLogin = ReadRequestMessage.read(this.request, this.response, UserLogin.class);
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
        return "result";
    }

    @SuppressWarnings("unchecked")
    public String loginCheck() throws RequestException, ServiceException {
        try {
            UserLogin userLogin = ReadRequestMessage.read(this.request, this.response, UserLogin.class);
            String id = userInfoService.loginService(userLogin);
            returnInfo.setCode(REQUEST_SUCCESS);
            returnInfo.setMsg(REQUEST_SUCCESS_MSG);
            returnInfo.setObj(id);
        } catch (RequestException e) {
            returnInfo.setCode(SEND_FAIL);
            returnInfo.setMsg(SEND_FAIL_MSG);
            throw new RequestException(SEND_FAIL_MSG);
        } catch (Exception e) {
            returnInfo.setCode(LOGIN_FAIL);
            returnInfo.setMsg(LOGIN_FAIL_MSG);
            throw new ServiceException(LOGIN_FAIL_MSG);
        }
        return "result";
    }

    public String updateUserPassword() throws RequestException, ServiceException {
        try {
            UserLogin userLogin = ReadRequestMessage.read(this.request, this.response, UserLogin.class);
            String id = userInfoService.updatePasswordService(userLogin);
            returnInfo.setCode(REQUEST_SUCCESS);
            returnInfo.setMsg(REQUEST_SUCCESS_MSG);
            returnInfo.setObj(id);
        } catch (RequestException e) {
            returnInfo.setCode(SEND_FAIL);
            returnInfo.setMsg(SEND_FAIL_MSG);
            throw new RequestException(SEND_FAIL_MSG);
        } catch (Exception e) {
            returnInfo.setCode(UPDATE_FAIL);
            returnInfo.setMsg(UPDATE_FAIL_MSG);
            throw new ServiceException(UPDATE_FAIL_MSG);
        }
        return "result";
    }

    @SuppressWarnings("unchecked")
    public String addUserInfo() throws RequestException, ServiceException {
        try {
            UserInfo userInfo = ReadRequestMessage.read(this.request, this.response, UserInfo.class);
            String id = userInfoService.addUserInfoService(userInfo);
            returnInfo.setCode(REQUEST_SUCCESS);
            returnInfo.setMsg(REQUEST_SUCCESS_MSG);
            returnInfo.setObj(id);
        } catch (RequestException e) {
            returnInfo.setCode(SEND_FAIL);
            returnInfo.setMsg(SEND_FAIL_MSG);
            throw new RequestException(SEND_FAIL_MSG);
        } catch (Exception e) {
            returnInfo.setCode(ADD_USERINFO_FAIL);
            returnInfo.setMsg(ADD_USERINFO_FAIL_MSG);
            throw new ServiceException(ADD_USERINFO_FAIL_MSG);
        }
        return "result";
    }


    @SuppressWarnings("unchecked")
    public String updateUserInfo() throws RequestException, ServiceException {
        try {
            UserInfo userInfo = ReadRequestMessage.read(this.request, this.response, UserInfo.class);
            String id = userInfoService.updateUserInfoService(userInfo);
            returnInfo.setCode(REQUEST_SUCCESS);
            returnInfo.setMsg(REQUEST_SUCCESS_MSG);
            returnInfo.setObj(id);
        } catch (RequestException e) {
            returnInfo.setCode(SEND_FAIL);
            returnInfo.setMsg(SEND_FAIL_MSG);
            throw new RequestException(SEND_FAIL_MSG);
        } catch (ServiceException e) {
            returnInfo.setCode(UPDATE_FAIL);
            returnInfo.setMsg(UPDATE_FAIL_MSG);
            throw new ServiceException(UPDATE_FAIL_MSG);
        }
        return "result";
    }


}
