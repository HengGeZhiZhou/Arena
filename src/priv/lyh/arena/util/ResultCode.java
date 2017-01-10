package priv.lyh.arena.util;

import java.util.HashMap;
import java.util.Map;


public interface ResultCode {

    int REQUEST_SUCCESS = 100;
    String REQUEST_SUCCESS_MSG = "����ɹ�";

    int SEND_FAIL = 101;
    String SEND_FAIL_MSG = "����������������������";

    int LOGIN_FAIL = 102;
    String LOGIN_FAIL_MSG = "��¼ʧ��";

    int REGISTER_FAIL = 103;
    String REGISTER_FAIL_MSG = "ע��ʧ�ܣ������ѱ�ʹ��";

    int ADD_USER_INFO_FAIL = 120;
    String ADD_USER_INFO_FAIL_MSG = "����û�ʧ�ܣ��û������ֻ����ѱ�ʹ��";


}
