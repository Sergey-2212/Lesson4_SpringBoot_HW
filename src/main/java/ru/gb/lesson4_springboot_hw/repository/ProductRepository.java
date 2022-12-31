package ru.gb.lesson4_springboot_hw.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.lesson4_springboot_hw.data.Product;
import ru.gb.lesson4_springboot_hw.repository.dbservice.DBUtils;
import ru.gb.lesson4_springboot_hw.repository.dbservice.ProductDao;

import java.util.List;

@Component
public class ProductRepository implements ProductDao {

    private DBUtils db;

    @Autowired
    public void setDb(DBUtils db) {
        this.db = db;
    }


    @Override
    public Product getProductById(Long id) {
        System.out.println("Repository: id - " + id);
        try(Session session = db.getSession()) {
            session.beginTransaction();
//            Product product = (Product) session.createQuery("FROM Product where id = :id")
//                            .setParameter("id", id).getSingleResult();
            Product product = session.find(Product.class, id);
            session.getTransaction().commit();
            System.out.println(product);
            return product;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try(Session session = db.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select prod from Product prod")
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try(Session session = db.getSession()) {
            session.beginTransaction();
            session.createQuery("delete Product prod where prod.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void addNewProduct(Product product) {
        try(Session session = db.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try(Session session = db.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    public void updateCostById(Long id, Double cost) {
        try(Session session = db.getSession()) {
            session.beginTransaction();
            session.createQuery("update Product prod set prod.cost = :cost where prod.id = :id")
                    .setParameter("id", id)
                    .setParameter("cost", cost)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

}
