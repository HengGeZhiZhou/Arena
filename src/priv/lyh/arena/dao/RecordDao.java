package priv.lyh.arena.dao;

import priv.lyh.arena.entity.Record;

import java.util.List;


public interface RecordDao extends BaseDao<Record> {

     int findCount();      //��ȡ��ҳ��

    List<Record> findByPage(int begin,int end);  //����ҳ����Ҽ�¼

}
