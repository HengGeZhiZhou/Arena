package priv.lyh.arena.util;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMailUtil extends Thread {
    //���ڸ��û������ʼ�������
    private  int port=465;

    private String from = "1018676477@qq.com";
    //������û���
    private String username = "1018676477";
    //���������
    private String password = "nnrovhiaiuiebehc";
    //�����ʼ��ķ�������ַ
    private String host = "smtp.qq.com ";


    public SendMailUtil(){
    }


    @Override
    public void run() {
        try{
            Properties prop = new Properties();
//            props.put("mail.smtp.host",host);
//            props.put("mail.smtp.port","465");
//            props.put("mail.smtp.auth","true");
            prop.setProperty("mail.smtp.host", host);
            prop.setProperty("mail.smtp.port","465");
            prop.setProperty("mail.smtp.auth", "true");
            prop.setProperty("mail.transport.protocol", "smtp");
            Session session = Session.getInstance(prop);
            session.setDebug(true);
            Transport ts = session.getTransport();
            ts.connect(host, username, password);
            Message message = createEmail(session);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            System.out.println("���ͳɹ�");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Message createEmail(Session session) throws Exception{

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1263901076@qq.com"));
        message.setSubject("�û�ע���ʼ�");
        String info = "��֤����123123";
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
}
