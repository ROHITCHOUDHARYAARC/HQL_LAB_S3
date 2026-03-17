package com.example.HQL_LAB_S3;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {

    public void saveProduct(Product product) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(product); // ✅ modern method
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Product p = session.get(Product.class, id);
            if (p != null) session.remove(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product", Product.class).list();
        }
    }

    public List<Product> getProductsAscByPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class).list();
        }
    }

    public List<Product> getProductsDescByPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class).list();
        }
    }

    public List<Product> getProductsWherePriceGreater(Double price) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("FROM Product p WHERE p.price > :price", Product.class)
                    .setParameter("price", price)
                    .list();
        }
    }

    public List<Object[]> getCountByPriceGroup() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("SELECT p.price, COUNT(p) FROM Product p GROUP BY p.price", Object[].class)
                    .list();
        }
    }

    public Product getProductById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        }
    }
}