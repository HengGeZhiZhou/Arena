package priv.lyh.arena.util;

import java.util.HashMap;
import java.util.Map;


public interface ResultCode {

    int REQUEST_SUCCESS = 100;
    String REQUEST_SUCCESS_MSG = "请求成功";

    int SEND_FAIL = 101;
    String SEND_FAIL_MSG = "发送数据有误，请重新输入";

    int LOGIN_FAIL = 102;
    String LOGIN_FAIL_MSG = "登录失败";

    int REGISTER_FAIL = 103;
    String REGISTER_FAIL_MSG = "注册失败，邮箱已被使用";

    int ADD_USER_INFO_FAIL = 120;
    String ADD_USER_INFO_FAIL_MSG = "添加用户失败，用户名或手机号已被使用";


}
