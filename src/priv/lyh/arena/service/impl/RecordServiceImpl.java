package priv.lyh.arena.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.lyh.arena.dao.RecordDao;
import priv.lyh.arena.entity.PageBean;
import priv.lyh.arena.entity.Record;
import priv.lyh.arena.service.RecordService;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class RecordServiceImpl implements RecordService {

    @Resource(name = "recordDaoImpl")
    private  RecordDao recordDao;

    private static int pageSize = 6;

    public int  getCount(){
        return recordDao.findCount();
    }


    @Override
    public List<Record> findByPage(Integer currPage) {
        List<Record> list=recordDao.findByPage(1,2);
        return list;
    }
}
