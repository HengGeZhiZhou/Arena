package priv.lyh.arena.util;

import priv.lyh.arena.exception.RequestException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;


public class ReadRequestMessage {


    public static <T> T read(HttpServletRequest request, HttpServletResponse response, Class<T> tClass) throws RequestException {
        try {
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            StringBuffer json = new StringBuffer();
            String line;
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
//            gson½âÎö
            System.out.println("jiexi");
            T t = GsonUtil.GsonToBean(json.toString(), tClass);
            return t;
        } catch (Exception p) {
            throw new RequestException("Request fail...");
        }
    }
}
