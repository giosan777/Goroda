/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matutu.giosan777.ge.userPoint;

import matutu.giosan777.ge.DAO.Impl.UserDaoImpl;
import matutu.giosan777.ge.entity.UsersEntity;
import matutu.giosan777.ge.factory.FactoryDAO;
import matutu.giosan777.ge.persistence.HibernateUtil;
import org.hibernate.Session;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Path("user")
public class UserCheck {

    public UserCheck() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String momeString(@QueryParam("mail")
                             @DefaultValue("null")
                                     String mail,
                             @QueryParam("pass")
                             @DefaultValue("0")
                                     String pass) {
        Collection collection = FactoryDAO.getInstance().getUserDao().getAllUser();
        Iterator iterator = collection.iterator();

        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            UsersEntity usersEntity =(UsersEntity) iterator.next();
            stringBuilder.append(usersEntity.getMail() + " da kido " + usersEntity.getPass());
        }

        return stringBuilder.toString();
    }

}
/*

    @GET
    @Produces("text/plain")
    public String getHelloText(@QueryParam("name") @DefaultValue("World") String name) {
        return "Hello, " + name + "!";
*/
