package priv.lyh.arena.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private static Gson gson=new GsonBuilder().create();

    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }
    
}
