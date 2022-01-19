package com.abhishek.DemoHIbernateObjectPersistenceLifeCycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.abhishek.DemoHIbernateObjectPersistenceLifeCycle.Laptop;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration confg = new Configuration().configure().addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(confg.getProperties()).buildServiceRegistry();
        SessionFactory sf = confg.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Laptop l = new Laptop();
        l.setLid(1);
        l.setBrand("ACER");
        l.setPrice(750);
        
        session.save(l);
        l.setPrice(600);
        session.delete(l);
        session.getTransaction().commit();
        
        //session.delete(l);
        l.setPrice(700);
    }
}
