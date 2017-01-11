package priv.lyh.arena.service;


import priv.lyh.arena.entity.Record;

import java.util.List;

public interface RecordService {
    List<Record> findByPage(Integer currPage);
}
