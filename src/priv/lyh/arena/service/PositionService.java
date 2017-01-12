package priv.lyh.arena.service;

import priv.lyh.arena.entity.MobileUser;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.exception.ServiceException;

import java.util.List;

public interface PositionService {

    List<UserInfo> getAroundPeople(double lat, double lon) throws ServiceException; //获取范围内的人

    void updatePosition(MobileUser mobileUser) throws ServiceException; //更新自己位置信息

}
