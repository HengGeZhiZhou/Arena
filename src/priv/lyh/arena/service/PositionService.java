package priv.lyh.arena.service;

import priv.lyh.arena.entity.MobileUser;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.exception.ServiceException;

import java.util.List;

public interface PositionService {

    List<UserInfo> getAroundPeople(double lat, double lon) throws ServiceException; //��ȡ��Χ�ڵ���

    void updatePosition(MobileUser mobileUser) throws ServiceException; //�����Լ�λ����Ϣ

}
