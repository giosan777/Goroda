/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matutu.giosan777.ge.userPoint;

import matutu.giosan777.ge.entity.UsersEntity;
import matutu.giosan777.ge.factory.FactoryDAO;
import matutu.giosan777.ge.users.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Iterator;

@Path("UserGetAndAdd")
public class UserCheck {

    public UserCheck() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/getUser")
    public String getUser(@QueryParam("getmail")
                          @DefaultValue("null")
                                  String mail,
                          @QueryParam("getpass")
                          @DefaultValue("null")
                                  String pass) {
        Collection collection;
        if (!mail.equals("nuul") && !(pass.length() < 6)) {

            collection = FactoryDAO.getInstance().getUserDao().getAllUser();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                UsersEntity usersEntity = (UsersEntity) iterator.next();
                if (usersEntity.getMail().equals(mail) && usersEntity.getPass().equals(pass)) {
                    return "gettrue";
                }
            }

        }
        return "getnull";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/addUsers")
    public String addUsers(@QueryParam("addMail")
                           @DefaultValue("null")
                                   String addMail,
                           @QueryParam("addPass")
                           @DefaultValue("null")
                                   String addPass) {
        if ((getUser(addMail, addPass).equals("gettrue"))) {
            return "userAddError";
        }
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setMail(addMail);
        usersEntity.setPass(addPass);
        FactoryDAO.getInstance().getUserDao().addUser(usersEntity);
        String s = getUser(addMail, addPass);
        System.out.println(s);
        if (s.equals("gettrue")) {
            return "regtrue";
        }
        return "regnull";
    }


}
