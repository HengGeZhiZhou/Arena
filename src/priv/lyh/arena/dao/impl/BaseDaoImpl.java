package priv.lyh.arena.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import priv.lyh.arena.dao.BaseDao;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class<T> clazz;

    @Resource(name = "sessionFactory")
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }


    //拿到泛型实体类T
    public BaseDaoImpl(){
        //BaseDaoImpl<User>获取此类泛型框中的第一个泛型
        ParameterizedType pt=(ParameterizedType)this.getClass().getGenericSuperclass();
        clazz=(Class<T>)pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(Object entity) {
        getHibernateTemplate().save(entity);
    }


    @Override
    public void update(Object enetity) {
        getHibernateTemplate().update(enetity);
    }

    @Override
    public void delete(Serializable id) {
        getHibernateTemplate().delete(findObjectById(id));
    }


    @Override
    public T findObjectById(Serializable id) {
        return getHibernateTemplate().get(clazz, id);
    }


    @Override
    public List<T> findObjects() {
        return (List<T>) getHibernateTemplate().find("from "+clazz.getSimpleName());
    }
}
