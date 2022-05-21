package com.geekbrains.realbuilder.hibernate5.repository;

import com.geekbrains.realbuilder.hibernate5.model.Students;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private final SessionFactory factory;

    public StudentRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long countAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Long countResult = (Long) session
                    .getNamedQuery("countAll")
                    .uniqueResult();
            session.getTransaction().commit();
            return countResult;
        }
    }

    @Override
    public List findByName(String name) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List studentsList = session.getNamedQuery("findByName")
                    .setParameter("name", name)
                    .list();
            session.getTransaction().commit();
            return studentsList;
        }
    }

    @Override
    public List findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List studentsList = session.createQuery("from Students").list();
            session.getTransaction().commit();
            return studentsList;
        }
    }

    @Override
    public Students findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Students students = session.get(Students.class, id);
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public void merge(Students entity) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Students students = (Students) session.merge(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Students> mergeBatch(List<Students> entities) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            entities.forEach(session::merge);
            for (Students entity : entities) {
                entity = (Students) session.merge(entity);
            }
            session.getTransaction().commit();
            return entities;
        }
    }

    @Override
    public boolean delete(Students entity) {
        return deleteById(entity.getId());
    }

    @Override
    public boolean deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.getNamedQuery("deleteById")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from Students").executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
        }
    }
}
