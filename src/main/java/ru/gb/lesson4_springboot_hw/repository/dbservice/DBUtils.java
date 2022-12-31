package ru.gb.lesson4_springboot_hw.repository.dbservice;

import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

    private SessionFactory factory;
    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        System.out.println("init");
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void shutdown() {
        if(factory.isOpen()) {
            factory.close();
        }
    }


}
