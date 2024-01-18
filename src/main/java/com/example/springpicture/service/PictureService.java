package com.example.springpicture.service;


import com.example.springpicture.model.Picture;
import com.example.springpicture.service.IPictureService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PictureService implements IPictureService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override

    public List<Picture> findAll() {
        String queryStr = "SELECT s FROM Picture AS s";
        TypedQuery<Picture> query = entityManager.createQuery(queryStr, Picture.class);
        return query.getResultList();
    }


    @Override


    public void save(Picture picture) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(picture); // Lưu đối tượng song vào cơ sở dữ liệu
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }}
