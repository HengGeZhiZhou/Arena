package priv.lyh.arena.util;

import java.util.HashMap;
import java.util.Map;


public interface ResultCode {
    int REQUEST_SUCCESS = 100;
    String REQUEST_SUCCESS_MSG = "请求成功";

    int SEND_FAIL = 101;
    String SEND_FAIL_MSG = "请求失败";

    int LOGIN_FAIL = 102;
    String LOGIN_FAIL_MSG = "登录失败";

    int REGISTER_FAIL = 103;
    String REGISTER_FAIL_MSG = "注册失败，邮箱已被使用";

    int ADD_USERINFO_FAIL = 104;
    String ADD_USERINFO_FAIL_MSG = "添加用户失败，用户名或手机号已被使用";

    int UPDATE_FAIL = 105;
    String UPDATE_FAIL_MSG = "更新失败";

    int EMAIL_EXIST=106;
    String EMAIL_EXIST_MSG="邮箱已被注册";

    int FIND_USERINFO_FAIL=107;
    String FIND_USERINFO_FAIL_MSG="查找用户失败,此用户不存在";
}
