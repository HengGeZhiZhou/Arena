package priv.lyh.arena.service;

import priv.lyh.arena.entity.UserInfo;

import java.util.List;

public interface PositionService {
    List<UserInfo> getAroundPeople(double lat, double lon) ; //��ȡ��Χ�ڵ���
}
