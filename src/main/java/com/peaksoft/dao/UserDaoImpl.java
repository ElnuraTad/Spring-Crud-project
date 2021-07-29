package com.peaksoft.dao;

import com.peaksoft.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return sessionFactory
                .openSession()
                .createQuery("FROM User")
                .getResultList();
    }

    @Override
    public void addUser(User user){
        sessionFactory.openSession().save(user);
    }

    @Override
    public User getById(Integer id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Override
    public void updateUser(User user, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user1 = session.get(User.class, id);
        user1.setAge(user.getAge());
        user1.setName(user.getName());

    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }

    @Override
    public User get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);

    }

}
