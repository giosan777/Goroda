package matutu.giosan777.ge.DAO.Impl;

import matutu.giosan777.ge.DAO.UserDAO;
import matutu.giosan777.ge.entity.UsersEntity;
import matutu.giosan777.ge.persistence.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDAO {
    @Override
    public List getAllUser() {
        Session session = null;
        List userList = new ArrayList<UsersEntity>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            userList = session.createCriteria(UsersEntity.class).list();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка getAll", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return userList;
    }

    @Override
    public void addUser(UsersEntity usersEntity) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usersEntity);

            session.getTransaction().commit();
            System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }
}
