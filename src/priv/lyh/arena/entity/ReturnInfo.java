package priv.lyh.arena.entity;


import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class ReturnInfo<T> {
    private Map<Integer,String> status;
    private T obj;

    public Map<Integer, String> getStatus() {
        return status;
    }

    public void setStatus(Map<Integer, String> status) {
        this.status = status;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ReturnInfo{" +
                "status=" + status +
                ", obj=" + obj +
                '}';
    }
}
