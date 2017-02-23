package matutu.giosan777.ge.users;// giosan777 ...

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private static long userSesion1=0;
    private static long userSesion2=0;

    private volatile static List<Map<Long, Long>> paraList = new ArrayList<>();


    public synchronized static void addPara() {
        Map<Long, Long> map = new HashMap<>();
        map.put(userSesion1, userSesion2);
        paraList.add(map);
        userSesion1 = 0;
        userSesion2 = 0;
        return;
    }

    public static long getUserSesion1() {
        return userSesion1;
    }

    public static void setUserSesion1(long userSesion1) {
        User.userSesion1 = userSesion1;
    }

    public static long getUserSesion2() {
        return userSesion2;
    }

    public static void setUserSesion2(long userSesion2) {
        User.userSesion2 = userSesion2;
    }
}
