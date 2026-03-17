package com.klef.fsadcom.klef.fsad.ProductHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
    private static SessionFactory sf;

    static
    {
        Configuration cfg = new Configuration();

        cfg.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url",
        		"jdbc:mysql://localhost:3306/fsadexamproductdp");
        cfg.setProperty("hibernate.connection.username","root");
        cfg.setProperty("hibernate.connection.password","WELCOME@123RKC");

        cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.hbm2ddl.auto","update");
        cfg.setProperty("hibernate.show_sql","true");

        cfg.addAnnotatedClass(Product.class);

        sf = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory()
    {
        return sf;
    }
}