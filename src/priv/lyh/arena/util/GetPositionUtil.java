package priv.lyh.arena.util;

/**
 * Created by Administrator on 2017/1/12.
 */
public class GetPositionUtil {

    public static double[] getAround(double lat, double lon, int raidus) {

        Double latitude = lat;
        Double longitude = lon;

        Double degree = (24901 * 1609) / 360.0;
        double raidusMile = raidus;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        return new double[] { minLat, minLng, maxLat, maxLng };
    }


    public static double distance(double centerLon, double centerLat, double targetLon, double targetLat) {

        double jl_jd = 102834.74258026089786013677476285;// ÿ���ȵ�λ��;
        double jl_wd = 111712.69150641055729984301412873;// ÿγ�ȵ�λ��;
        double b = Math.abs((centerLat - targetLat) * jl_jd);
        double a = Math.abs((centerLon - targetLon) * jl_wd);
        return Math.sqrt((a * a + b * b));
    }
}