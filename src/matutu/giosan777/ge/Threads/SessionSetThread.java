package matutu.giosan777.ge.Threads;// giosan777 ...

import matutu.giosan777.ge.users.User;
import matutu.giosan777.ge.users.UsersList;

public class SessionSetThread {
    static SessionSetThread sessionSetThread = new SessionSetThread();

    private SessionSetThread(){}
    public static SessionSetThread getInstance(){
        if (sessionSetThread == null) {
            sessionSetThread = new SessionSetThread();
        }
        return sessionSetThread;
    }

    public void startThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long id = UsersList.getInstance().getId();
                    if (id != 0) {
                        if (User.getUserSesion1() != 0) {
                            User.setUserSesion1(id);
                        } else if (User.getUserSesion2() != 0) {
                            User.setUserSesion2(id);
                        }
                    }
                }
            }
        });
        thread.start();
    }

}
