package priv.lyh.arena.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import priv.lyh.arena.dao.RecordDao;
import priv.lyh.arena.entity.Record;

import java.util.List;


public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao {

    @Override
    @SuppressWarnings("unchecked")
    public int findCount() {
        String hql="select count(*) from Record";
        List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size()>0) return list.get(0).intValue();
        return 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Record> findByPage(int begin, int end) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Record.class);
        return (List<Record>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,end);
    }
}
