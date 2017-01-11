package priv.lyh.arena.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import priv.lyh.arena.exception.RequestException;

public class GsonUtil {

    private static Gson gson=new GsonBuilder().create();

    public static <T> T GsonToBean(String gsonString, Class<T> cls) throws RequestException {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

}
