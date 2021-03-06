package priv.lyh.arena.service;

import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.exception.ServiceException;

import java.io.Serializable;


public interface UserInfoService {
        String loginService(UserLogin userLogin) throws ServiceException;  //检查登录  返回id

        boolean checkEmailExistService(String email) throws ServiceException;  //检查邮箱是否存在

        String registerService(UserLogin userLogin) throws ServiceException ;  //注册  返回id

        String updatePasswordService(UserLogin userLogin) throws ServiceException;//修改密码 返回

        UserInfo findUserInfo(Serializable id) throws ServiceException; //获取用户信息

        String  addUserInfoService(UserInfo userInfo)throws ServiceException  ; //添加详细信息 返回id

        String updateUserInfoService(UserInfo userInfo)throws ServiceException;//修改信息 返回id
}
