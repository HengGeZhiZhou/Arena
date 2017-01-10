package priv.lyh.arena.service;

import org.springframework.stereotype.Service;
import priv.lyh.arena.entity.ReturnInfo;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.exception.ServiceException;

import java.io.Serializable;
import java.util.List;


public interface UserInfoService {
        String loginService(UserLogin userLogin) throws ServiceException;  //����¼  ����id
//
        String registerService(UserLogin userLogin) throws ServiceException ;  //ע��  ����id
//
        String  addUserInfoService(UserInfo userInfo)throws ServiceException  ; //������ϸ��Ϣ ����id
//
        String updateUserInfoService(UserInfo userInfo)throws ServiceException;//�޸���Ϣ ����id
}