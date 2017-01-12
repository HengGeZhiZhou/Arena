package priv.lyh.arena.dao;


import priv.lyh.arena.entity.MobileUser;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;

import java.io.Serializable;


public interface UserInfoDao extends BaseDao<UserLogin>{

    String getMaxId(); //获取当前用户中最大ID 返回id

    boolean checkEmailExist(String email);  //检查用户邮箱地址是否存在

    String userCheckLogin(UserLogin userLogin);//检查登录  返回id修改登录时间

    void updateTime(Serializable id);  //更新用户最近登陆时间

    void addUserPosition(MobileUser mobileUser); //用户注册是假如位置信息

    UserInfo findUserInfo(Serializable id);  // 获取用户信息

    String addUserInfo(UserInfo userInfo) ; //添加用户详细信息  返回id

    String updateUserInfo(UserInfo userInfo); //用户修改信息  返回id
}
