package org.hibernate.services;

import org.hibernate.dao.ItemI;
import org.hibernate.models.Item;
import org.hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ItemService implements ItemI {


    @Override
    public void createItem(Item item) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            s.persist(item);
            tx.commit();
        } catch (HibernateException exception) {
            if (tx!=null) tx.rollback();
            exception.printStackTrace();
        } finally {
            s.close();
        }


    }

    @Override
    public int deleteItem(Item item) {
        return 0;
    }

    @Override
    public void updateItem(Item item) {

    }

    @Override
    public List<Item> getItems() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Item> i = null;
        try {
            tx = s.beginTransaction();
            Query q = s.createQuery("from Item",Item.class);
            i = q.getResultList();
            tx.commit();
        } catch (HibernateException exception) {
            if (tx!=null) tx.rollback();
            exception.printStackTrace();
        } finally {
            s.close();
        }
        return i;
    }

}
