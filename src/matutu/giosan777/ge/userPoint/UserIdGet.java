package matutu.giosan777.ge.userPoint;// giosan777 ...


import matutu.giosan777.ge.Threads.SessionSetThread;
import matutu.giosan777.ge.users.User;
import matutu.giosan777.ge.users.UsersList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("Session")
public class UserIdGet {
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/getUserId")
    public String getUserID() {
        long rand = (long) (Math.random() * 99999999 + 1);
        String s = String.valueOf(rand);
        return s;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/addUserId")
    public String addUserID(@QueryParam("longID")
                            @DefaultValue("null")
                            String longID) {
        SessionSetThread sessionSetThread=SessionSetThread.getInstance();
        sessionSetThread.startThread();
        if (!longID.equals("nuul")) {
            long usID = Long.valueOf(longID);
            UsersList.getInstance().addUserId(usID);
            return "addIdOk";
        }
        return "addIdnull";
    }

}
