package priv.lyh.arena.util;

import java.util.HashMap;
import java.util.Map;


public interface ResultCode {
    //访问成功结果码 666
    Map<Integer, String> requestSuccess = new HashMap<Integer, String>() {{
        put(666, "request Success");
    }};
    //登录注册失败结果码：100-200
    Map<Integer, String> loginFail = new HashMap<Integer, String>() {{
        put(100, "登录失败");
    }};

    Map<Integer,String> registerFail=new HashMap<Integer, String>(){{
        put(110,"注册失败，邮箱已被使用");
    }};

    Map<Integer,String> addUserInfoFail=new HashMap<Integer, String>(){{
        put(120,"添加用户失败，用户名或手机号已被使用");
    }};
}
