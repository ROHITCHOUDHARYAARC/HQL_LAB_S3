package com.klef.fsadcom.klef.fsad.ProductHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        // INSERT OPERATION
        Product p = new Product();
        p.name = "Laptop";
        p.description = "Gaming Laptop";
        p.date = new Date();
        p.status = "Available";

        s.persist(p);

        t.commit();
        System.out.println("Product Inserted");

        s.close();


        // UPDATE OPERATION
        Session s2 = HibernateUtil.getSessionFactory().openSession();
        Transaction t2 = s2.beginTransaction();

        Product pr = s2.get(Product.class,1);

        if(pr!=null)
        {
            pr.name="Updated Laptop";
            pr.status="Out of Stock";
        }

        t2.commit();
        System.out.println("Product Updated");

        s2.close();
    }
}