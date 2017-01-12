package priv.lyh.arena.dao;


import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;

import java.io.Serializable;


public interface UserInfoDao extends BaseDao<UserLogin>{

    String getMaxId(); //��ȡ��ǰ�û������ID ����id

    boolean checkEmailExist(String email);  //����û������ַ�Ƿ����

    String userCheckLogin(UserLogin userLogin);//����¼  ����id�޸ĵ�¼ʱ��

    void updateTime(Serializable id);  //�����û������½ʱ��

    UserInfo findUserInfo(Serializable id);  // ��ȡ�û���Ϣ

    String addUserInfo(UserInfo userInfo) ; //����û���ϸ��Ϣ  ����id

    String updateUserInfo(UserInfo userInfo); //�û��޸���Ϣ  ����id
}
