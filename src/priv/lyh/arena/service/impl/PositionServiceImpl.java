package priv.lyh.arena.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.lyh.arena.dao.PositionDao;
import priv.lyh.arena.dao.UserInfoDao;
import priv.lyh.arena.entity.MobileUser;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.service.PositionService;
import priv.lyh.arena.util.GetPositionUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class PositionServiceImpl implements PositionService {

    private PositionDao positionDao;
    private UserInfoDao userInfoDao;
    @Resource(name = "positionDaoImpl")
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
    @Resource(name = "userInfoDaoImpl")
    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public List<UserInfo> getAroundPeople(double lat, double lon) {
        double[] around=GetPositionUtil.getAround(lat,lon,1000);
       List<MobileUser> usersM= positionDao.getAroundPeople(around[0],around[1],around[2],around[3]);
       List<UserInfo> userInfos = new ArrayList<UserInfo>();
       for (MobileUser user:usersM){
           System.out.println("ÓÃ»§ID:"+user.getMuUId());

           userInfos.add(userInfoDao.findUserInfo(user.getMuUId()));
        }
        return userInfos;
    }
}
