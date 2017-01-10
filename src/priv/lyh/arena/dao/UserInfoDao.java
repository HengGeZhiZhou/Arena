package priv.lyh.arena.dao;


import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;

import java.io.Serializable;


public interface UserInfoDao extends BaseDao<UserLogin>{

    String getMaxId(); //��ȡ��ǰ�û������ID ����id

    String userCheckLogin(UserLogin userLogin);//����¼  ����id�޸ĵ�¼ʱ��

    void updateTime(Serializable id);  //�����û������½ʱ��

    String addUserInfo(UserInfo userInfo) throws Exception; //����û���ϸ��Ϣ  ����id

    String updateUserInfo(UserInfo userInfo) throws Exception; //�û��޸���Ϣ  ����id
}
