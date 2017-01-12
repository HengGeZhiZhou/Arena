package priv.lyh.arena.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import priv.lyh.arena.dao.PositionDao;
import priv.lyh.arena.entity.MobileUser;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Scope("prototype")
public class PositionDaoImpl extends BaseDaoImpl<MobileUser> implements PositionDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<MobileUser> getAroundPeople(Double top, Double left, Double bottom, Double right) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(MobileUser.class);
        detachedCriteria.add(Restrictions.between("muLongitud",new BigDecimal(left),new BigDecimal(right)));
        detachedCriteria.add(Restrictions.between("muLatitude",new BigDecimal(top),new BigDecimal(bottom)));
        return (List<MobileUser>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
    }

    @Override
    public void updatePosition(MobileUser mobileUser) {
        MobileUser mobileUsers=this.getHibernateTemplate().get(MobileUser.class,mobileUser.getMuUId());
        mobileUsers.setMuLatitude(mobileUser.getMuLatitude());
        mobileUsers.setMuLongitud(mobileUser.getMuLongitud());
        update(mobileUsers);
    }
}
