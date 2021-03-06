package test;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.lyh.arena.entity.*;
import priv.lyh.arena.exception.ServiceException;
import priv.lyh.arena.service.PositionService;
import priv.lyh.arena.service.RecordService;
import priv.lyh.arena.service.UserInfoService;
import priv.lyh.arena.util.CreateSafeCode;
import priv.lyh.arena.util.GetPositionUtil;
import priv.lyh.arena.util.SendMailUtil;
import test.dao.TestDao;
import test.service.impl.TestServiceImpl;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {
    private ClassPathXmlApplicationContext ctx;


    @Resource(name = "userInfoServiceImpl")
    private UserInfoService userInfoService;

    @Resource(name = "recordServiceImpl")
    private RecordService recordService;

    @Resource(name = "positionServiceImpl")
    private PositionService positionService;

    @org.junit.Test
    public void testLogin() throws Exception {
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail("zl");
        userLogin.setPassword("123");
        Gson gson = new Gson();
        System.out.println(gson.toJson(userLogin));
        System.out.println(userInfoService.loginService(userLogin));
    }

    @org.junit.Test
    public void testRegister() {
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail("zl");
        userLogin.setPassword("ssss");
        try {
            System.out.println(userInfoService.registerService(userLogin));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1701000003");
        userInfo.setName("流论旁生");
        userInfo.setPortrait("aaa");
        userInfo.setSex("男");
        userInfo.setAge("11");
        userInfo.setHeight("1.80");
        userInfo.setWeight("90");
        userInfo.setProfiles("wwwwwwwwwwwwwwwwww");
        userInfo.setPhone("1232kksds");
        try {
            System.out.println(userInfoService.updateUserInfoService(userInfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void TestMap() {
        ReturnInfo returnInfo = new ReturnInfo();
//        returnInfo.setStatus(ResultCode.loginFail);
        returnInfo.setObj("123123123");
        Gson gson = new Gson();
        String a = gson.toJson(returnInfo);
        System.out.println(a);
        ReturnInfo returnInfo1 = gson.fromJson(a, ReturnInfo.class);
//        Map<Integer,String> map=returnInfo1.getStatus();
//        System.out.println(map.keySet());
//        System.out.println(map.values());
    }


    @org.junit.Test
    public void testSpring() {
        ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestServiceImpl ts = (TestServiceImpl) ctx.getBean("testService");
        TestServiceImpl ts1 = (TestServiceImpl) ctx.getBean("testService");
        System.out.println(ts.equals(ts1));
        System.out.println(ts.testDao.equals(ts1.testDao));
        ts1.say();
        ts.say();
    }

    @org.junit.Test
    public void TestDao() {
        ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestDao testDao = (TestDao) ctx.getBean("lii");
        System.out.println(testDao.findUser("1701000001").toString());
    }

    @org.junit.Test
    public void testLog4j() {
//        PropertyConfigurator.configure("log4j.properties");
        Log log = LogFactory.getLog(getClass());
        log.debug("debug 级别日志");
        log.info("info 级别日志");
        log.warn("warn 级别日志");
        log.error("error 级别日志");
        log.fatal("fatal 级别日志");
    }

    @org.junit.Test
    public void testUpdatePassword() {
        UserLogin userLogin = new UserLogin();
        userLogin.setId("1701000001");
        userLogin.setPassword("luidqsad");
        try {
            userInfoService.updatePasswordService(userLogin);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void sendMail() {
        SendMailUtil sendMailUtil = new SendMailUtil("heelo", "iota.9star@foxmail.com");
        sendMailUtil.run();
    }

    @org.junit.Test
    public void checkEmailExist() {
        try {
            if (!userInfoService.checkEmailExistService("lyh")) {
                System.out.println("邮箱不存在");

            } else {
                System.out.println("邮箱已经存在");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            System.out.println("不存在");
        }
    }

    @org.junit.Test
    public void testCreateSafeCode() {
        System.out.println("随机数字为" + CreateSafeCode.getRandCode());
        System.out.println("随机数字为" + CreateSafeCode.getRandCode());
        System.out.println("随机数字为" + CreateSafeCode.getRandCode());
        System.out.println("随机数字为" + CreateSafeCode.getRandCode());
        System.out.println("随机数字为" + CreateSafeCode.getRandCode());
        System.out.println("随机数字为" + CreateSafeCode.getRandCode());
    }

    @org.junit.Test
    public void testGetUserInfo() {
        try {
            System.out.println(userInfoService.findUserInfo("1701000001").toString());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testRecordCount() {
        System.out.println(recordService.getCount());
    }

    @org.junit.Test
    public void testRecord() {

        List<Record> lists = recordService.findByPage(1);
        for (Record record : lists) {
            System.out.println(record.toString());
        }
    }
    @org.junit.Test
    public void testDistance(){
        System.out.println("相差距离"+GetPositionUtil.distance(103.826878,30.673742,103.827334,30.673978));
    }

    @org.junit.Test
    public void testAround(){
        List<UserInfo> lists= null;
        try {
            lists = positionService.getAroundPeople(30.67402,103.827121);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        for (UserInfo userInfo:lists){
            System.out.println(userInfo.toString());
        }
    }

    @org.junit.Test
    public void testUpdatePosition(){
        MobileUser mobileUser=new MobileUser();
//        mobileUser.setMuId(1);
        mobileUser.setMuUId("1701000003");
        mobileUser.setMuLatitude(new BigDecimal(13.212313));
        mobileUser.setMuLongitud(new BigDecimal(29.221231));
        try {
            positionService.updatePosition(mobileUser);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
