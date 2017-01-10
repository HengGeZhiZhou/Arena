package test.dao;

import priv.lyh.arena.entity.UserLogin;

import java.io.Serializable;


public interface TestDao {
    UserLogin findUser(Serializable id);
}
