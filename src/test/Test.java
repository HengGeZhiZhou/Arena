package test;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.lyh.arena.entity.ReturnInfo;
import priv.lyh.arena.entity.UserInfo;
import priv.lyh.arena.entity.UserLogin;
import priv.lyh.arena.exception.ServiceException;
import priv.lyh.arena.service.UserInfoService;
import test.dao.TestDao;
import test.service.TestService;
import priv.lyh.arena.util.ResultCode;
import test.service.impl.TestServiceImpl;


import javax.annotation.Resource;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {
    private ClassPathXmlApplicationContext ctx;



    @Resource(name = "userInfoServiceImpl")
    UserInfoService userInfoService;

    @org.junit.Test
    public void testLogin() throws Exception {
        UserLogin userLogin=new UserLogin();
        userLogin.setEmail("lyh");
        userLogin.setPassword("123");
        Gson gson=new Gson();
        System.out.println(gson.toJson(userLogin));
        System.out.println(userInfoService.loginService(userLogin));
    }

    @org.junit.Test
    public void testRegister()  {
        UserLogin userLogin=new UserLogin();
        userLogin.setEmail("moy");
        userLogin.setPassword("ssss");
        try {
            System.out.println(userInfoService.registerService(userLogin));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test(){
       UserInfo  userInfo=new UserInfo();
        userInfo.setId("1701000001");
        userInfo.setName("流论旁生");
        userInfo.setPortrait("aaa");
        userInfo.setSex("男");
        userInfo.setAge("11");
        userInfo.setHeight("1.80");
        userInfo.setWeight("90");
        userInfo.setProfiles("wwwwwwwwwwwwwwwwww");
        userInfo.setPhone("13099927777");
        try {
            System.out.println(userInfoService.updateUserInfoService(userInfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public  void TestMap(){
        ReturnInfo returnInfo=new ReturnInfo();
//        returnInfo.setStatus(ResultCode.loginFail);
        returnInfo.setObj("123123123");
        Gson gson=new Gson();
        String a=gson.toJson(returnInfo);
        System.out.println(a);
        ReturnInfo returnInfo1=gson.fromJson(a,ReturnInfo.class);
//        Map<Integer,String> map=returnInfo1.getStatus();
//        System.out.println(map.keySet());
//        System.out.println(map.values());
    }



    @org.junit.Test
    public void testSpring(){
        ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestServiceImpl ts= (TestServiceImpl) ctx.getBean("testService");
        TestServiceImpl ts1= (TestServiceImpl) ctx.getBean("testService");
        System.out.println(ts.equals(ts1));
        System.out.println(ts.testDao.equals(ts1.testDao));
        ts1.say();
        ts.say();
    }

    @org.junit.Test
    public void TestDao(){
        ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestDao testDao= (TestDao) ctx.getBean("lii");
        System.out.println(testDao.findUser("1701000001").toString());
    }

    @org.junit.Test
    public void testLog4j(){
//        PropertyConfigurator.configure("log4j.properties");
        Log log= LogFactory.getLog(getClass());
        log.debug("debug 级别日志");
        log.info("info 级别日志");
        log.warn("warn 级别日志");
        log.error("error 级别日志");
        log.fatal("fatal 级别日志");
    }

    @org.junit.Test
    public void testGsonUtil(){

    }


}
