package priv.lyh.arena.util;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMailUtil extends Thread {

    @Override
    public void run() {
        try {
//            Properties properties=new Properties();
//            properties.setProperty("mail.smtp.port","587");
//            properties.setProperty("mail.smtp.auth","true");
//            properties.setProperty("mail.smtp.starttls.enable","true");
//            properties.setProperty("mail.transport.protocol","smtp");
            Session session = Session.getInstance(PropertiesUtil.getPropertiesConnect());
            session.setDebug(true);
            Transport ts = session.getTransport();
            ts.connect(PropertiesUtil.getAccountHost()
                    , PropertiesUtil.getAccountUsername(),
                    PropertiesUtil.getAccountPassword());
            Message message = createEmail(session);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            System.out.println("发送成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Message createEmail(Session session) throws Exception {

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(PropertiesUtil.getAccountForm()));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1263901076@qq.com"));
        message.setSubject("用户注册邮件");
        String info = "验证码是123123sdasdas";
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
}
