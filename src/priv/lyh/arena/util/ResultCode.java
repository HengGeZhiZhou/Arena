package priv.lyh.arena.util;

import java.util.HashMap;
import java.util.Map;


public interface ResultCode {
    //���ʳɹ������ 666
    Map<Integer, String> requestSuccess = new HashMap<Integer, String>() {{
        put(666, "request Success");
    }};
    //��¼ע��ʧ�ܽ���룺100-200
    Map<Integer, String> loginFail = new HashMap<Integer, String>() {{
        put(100, "��¼ʧ��");
    }};

    Map<Integer,String> registerFail=new HashMap<Integer, String>(){{
        put(110,"ע��ʧ�ܣ������ѱ�ʹ��");
    }};

    Map<Integer,String> addUserInfoFail=new HashMap<Integer, String>(){{
        put(120,"����û�ʧ�ܣ��û������ֻ����ѱ�ʹ��");
    }};
}
