package priv.lyh.arena.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import priv.lyh.arena.dao.RecordDao;
import priv.lyh.arena.entity.Record;

import java.util.List;

@Repository
@Scope("prototype")
public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao {

    @Override
    @SuppressWarnings("unchecked")
    public int findCount() {
        String hql="select count(*) from Record where id=? and type=?";
        List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql,"1701000001","basketball");
        if (list.size()>0) return list.get(0).intValue();
        return 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Record> findByPage(int begin, int end) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Record.class);
        detachedCriteria.add(Restrictions.eq("id","1701000001"));
        detachedCriteria.add(Restrictions.eq("type","basketball"));
        detachedCriteria.add(Restrictions.between("count",1,2));
        return (List<Record>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
    }
}
