package priv.lyh.arena.dao;


import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;

import java.io.Serializable;


public interface UserInfoDao extends BaseDao<UserLogin>{

    String getMaxId(); //获取当前用户中最大ID 返回id

    String userCheckLogin(UserLogin userLogin);//检查登录  返回id修改登录时间

    void updateTime(Serializable id);  //更新用户最近登陆时间

    String addUserInfo(UserInfo userInfo) throws Exception; //添加用户详细信息  返回id

    String updateUserInfo(UserInfo userInfo) throws Exception; //用户修改信息  返回id
}
