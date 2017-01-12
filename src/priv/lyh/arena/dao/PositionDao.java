package priv.lyh.arena.dao;


import priv.lyh.arena.entity.MobileUser;

import java.util.List;

public interface PositionDao extends BaseDao<MobileUser> {

    List<MobileUser> getAroundPeople(Double top, Double left, Double bottom, Double right);

    void updatePosition(MobileUser mobileUser);

}
