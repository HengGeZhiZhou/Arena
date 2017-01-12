package priv.lyh.arena.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.lyh.arena.dao.PositionDao;
import priv.lyh.arena.dao.UserInfoDao;

import priv.lyh.arena.entity.MobileUser;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.exception.ServiceException;
import priv.lyh.arena.util.*;
import priv.lyh.arena.service.UserInfoService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;


@Service
@Transactional
@Scope("prototype")
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao;
    private PositionDao positionDao;

   @Resource(name = "userInfoDaoImpl")
    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Resource(name = "positionDaoImpl")
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
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
    public boolean checkEmailExistService(String email) throws ServiceException {
        try {
            return userInfoDao.checkEmailExist(email);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String registerService(UserLogin userLogin) throws ServiceException {
        try {
            userLogin.setId(CreateNewUserId.getNewUserId(userInfoDao.getMaxId()));
            userLogin.setLastTime(new java.sql.Timestamp(System.currentTimeMillis()));
            userLogin.setAddTime(new java.sql.Timestamp(System.currentTimeMillis()));
            userInfoDao.save(userLogin);
            positionDao.save(new MobileUser(userLogin.getId(),new BigDecimal(0),new BigDecimal(0)));
            return userLogin.getId();
        } catch (Exception e) {
            throw new ServiceException("Register fail...");
        }
    }

    @Override
    public String updatePasswordService(UserLogin userLogin) throws ServiceException {
        try {
            UserLogin user = userInfoDao.findObjectById(userLogin.getId());
            user.setPassword(userLogin.getPassword());
            userInfoDao.update(user);
            return user.getId();
        } catch (Exception e) {
            throw new ServiceException("Update password fail...");
        }
    }

    @Override
    public UserInfo findUserInfo(Serializable id) throws ServiceException {
        try{
            return userInfoDao.findUserInfo(id);
        }
        catch (Exception e){
         throw new ServiceException("No this  User");
        }
    }

    @Override
    public String addUserInfoService(UserInfo userInfo) throws ServiceException {
        try {
            userInfo.setAddTime(new java.sql.Timestamp(System.currentTimeMillis()));
            userInfoDao.addUserInfo(userInfo);
            return userInfo.getId();
        } catch (Exception e) {
            throw new ServiceException("Add fail...");
        }
    }

    @Override
    public String updateUserInfoService(UserInfo userInfo) throws ServiceException {
        try {
            userInfo.setAddTime(new java.sql.Timestamp(System.currentTimeMillis()));
            userInfoDao.updateUserInfo(userInfo);
            return userInfo.getId();
        } catch (Exception e) {
            throw new ServiceException("Update fail...");
        }
    }
}
