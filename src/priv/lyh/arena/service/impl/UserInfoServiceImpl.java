package priv.lyh.arena.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.lyh.arena.dao.UserInfoDao;
import priv.lyh.arena.entity.ReturnInfo;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.exception.ServiceException;
import priv.lyh.arena.util.*;
import priv.lyh.arena.service.UserInfoService;

import java.io.Serializable;
import java.util.List;


@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao;
    private ReturnInfo returnInfo;

    @Autowired
    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Autowired
    public void setReturnInfo(ReturnInfo returnInfo) {
        this.returnInfo = returnInfo;
    }

    @Override
    public String loginService(UserLogin userLogin) throws ServiceException {
        try {
            String id = userInfoDao.userCheckLogin(userLogin);
            userInfoDao.updateTime(id);
            return id;
        } catch (Exception e) {
            throw new ServiceException("Login fail...");
        }
    }

    @Override
    public String registerService(UserLogin userLogin) throws ServiceException {
        try {
            userLogin.setId(CreateNewUserId.getNewUserId(userInfoDao.getMaxId()));
            userLogin.setLastTime(new java.sql.Timestamp(System.currentTimeMillis()));
            userLogin.setAddTime(new java.sql.Timestamp(System.currentTimeMillis()));
            userInfoDao.save(userLogin);
            return userLogin.getId();
        } catch (Exception e) {
            throw new ServiceException("Register fail...");
        }
    }

    @Override
    public String addUserInfoService(UserInfo userInfo) throws ServiceException {
        try{
            userInfo.setAddTime(new java.sql.Timestamp(System.currentTimeMillis()));
            userInfoDao.addUserInfo(userInfo);
            return userInfo.getId();
        }catch (Exception e){
            throw new ServiceException("Add fail...");
        }
    }

    @Override
    public String updateUserInfoService(UserInfo userInfo) throws ServiceException {
        try {
            userInfo.setAddTime(new java.sql.Timestamp(System.currentTimeMillis()));
            userInfoDao.updateUserInfo(userInfo);
            return userInfo.getId();
        }catch (Exception e){
            throw new ServiceException("Update fail...");
        }
    }
}
