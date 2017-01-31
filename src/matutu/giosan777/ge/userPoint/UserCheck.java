/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matutu.giosan777.ge.userPoint;

import matutu.giosan777.ge.entity.UsersEntity;
import matutu.giosan777.ge.factory.FactoryDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Iterator;

@Path("user")
public class UserCheck {

    public UserCheck() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/getUser")
    public String getUser(@QueryParam("mail")
                             @DefaultValue("null")
                                     String mail,
                             @QueryParam("pass")
                             @DefaultValue("0")
                                     String pass) {
        Collection collection;
        if (!mail.equals("nuul") && !(pass.length() < 6)) {

            collection = FactoryDAO.getInstance().getUserDao().getAllUser();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                UsersEntity usersEntity =(UsersEntity) iterator.next();
                if (usersEntity.getMail().equals(mail) && usersEntity.getPass().equals(pass)) {
                    return "1";
                }
            }

        }


        return "null";
    }



}
/*

    @GET
    @Produces("text/plain")
    public String getHelloText(@QueryParam("name") @DefaultValue("World") String name) {
        return "Hello, " + name + "!";
*/
