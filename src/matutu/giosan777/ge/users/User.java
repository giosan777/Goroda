package matutu.giosan777.ge.users;// giosan777 ...

public class User {

    private static long userSesion1=0;
    private static long userSesion2=0;

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
