/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matutu.giosan777.ge.userPoint;

import matutu.giosan777.ge.entity.UsersEntity;
import matutu.giosan777.ge.persistence.HibernateUtil;
import org.hibernate.Session;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        UsersEntity usersEntity = new UsersEntity();
        if (usersEntity.getMail().equals(mail)) {
            return "aris ukve";
        }
        usersEntity.setMail(mail);
        usersEntity.setPass(pass);

        session.save(usersEntity);
        session.getTransaction().commit();
        return "false";
    }

}
/*

    @GET
    @Produces("text/plain")
    public String getHelloText(@QueryParam("name") @DefaultValue("World") String name) {
        return "Hello, " + name + "!";
*/
