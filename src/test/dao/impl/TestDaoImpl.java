package test.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import priv.lyh.arena.entity.UserLogin;
import test.dao.TestDao;

import javax.annotation.Resource;
import java.io.Serializable;

@Repository("lii")
public class TestDaoImpl extends HibernateDaoSupport implements TestDao {

    @Resource(name = "sessionFactory")
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public UserLogin findUser(Serializable id) {
        return this.getHibernateTemplate().get(UserLogin.class,id);
    }
}
