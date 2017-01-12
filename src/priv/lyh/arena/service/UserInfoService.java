package priv.lyh.arena.service;

import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.exception.ServiceException;

import java.io.Serializable;


public interface UserInfoService {
        String loginService(UserLogin userLogin) throws ServiceException;  //����¼  ����id

        boolean checkEmailExistService(String email) throws ServiceException;  //��������Ƿ����

        String registerService(UserLogin userLogin) throws ServiceException ;  //ע��  ����id

        String updatePasswordService(UserLogin userLogin) throws ServiceException;//�޸����� ����

        UserInfo findUserInfo(Serializable id) throws ServiceException; //��ȡ�û���Ϣ

        String  addUserInfoService(UserInfo userInfo)throws ServiceException  ; //�����ϸ��Ϣ ����id

        String updateUserInfoService(UserInfo userInfo)throws ServiceException;//�޸���Ϣ ����id
}
