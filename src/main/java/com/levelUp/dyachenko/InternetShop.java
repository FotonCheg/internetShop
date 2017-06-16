package com.levelUp.dyachenko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InternetShop {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    //Такой объект походу так же нужно инжектить через спринг

    public static void main(String[] args){
        InternetShop is = new InternetShop();
        //Создали экземпляр самого приложения, что в будещем можно будет просто заинжектить спрингом

        Category zima = new Category();
        zima.setName("zima");

        Category vesna = new Category();
        vesna.setName("vesna");

        Category leto = new Category();
        leto.setName("leto");

        Category osen = new Category();
        osen.setName("osen");

        //Создали категории, которые в дальнейшем будем использовать

        Client client = new Client();
        client.setName("Yaroslav");
        client.setPhoneNumber("0730937900");
        //Зарегистрировался клиент

        Product product1 = new Product();
        product1.setName("Karolina");
        product1.getCategorySet().add(zima);
        product1.getCategorySet().add(vesna);
        product1.getCategorySet().add(osen);
        ProductDescription description1 = new ProductDescription();
        description1.setDescription("Desctiption for Karolina");
        product1.setDescription(description1);
        product1.setCost(997);
        int price1 = (int) ((product1.getCost()+product1.getCost()*0.1)-(product1.getCost()+product1.getCost()*0.1)%25);
        product1.setPrice(price1);

        Product product2 = new Product();
        product2.setName("Eva");
        product2.getCategorySet().add(vesna);
        product2.getCategorySet().add(osen);
        ProductDescription description2 = new ProductDescription();
        description2.setDescription("Desctiption for Eva");
        product2.setDescription(description2);
        product2.setCost(1176);
        int price2 = (int) ((product2.getCost()+product2.getCost()*0.1)-(product2.getCost()+product2.getCost()*0.1)%25);
        product2.setPrice(price2);

        Product product3 = new Product();
        product3.setName("Annet");
        product3.getCategorySet().add(leto);
        ProductDescription description3 = new ProductDescription();
        description3.setDescription("Desctiption for Annet");
        product3.setDescription(description3);
        product3.setCost(2777);
        int price3 = (int) ((product3.getCost()+product3.getCost()*0.1)-(product3.getCost()+product3.getCost()*0.1)%25);
        product3.setPrice(price3);
        //Добавили продукты на склад, указали их имена и категории, к которым они относятся

        SomeOrder someOrder1 = new SomeOrder();
        someOrder1.setName("Заказ 1");
        someOrder1.getProductSet().add(product1);
        someOrder1.getProductSet().add(product2);
        //Сделали первый заказ с двумя продуктами

        SomeOrder someOrder2 = new SomeOrder();
        someOrder2.setName("Заказ 2");
        someOrder2.getProductSet().add(product3);
        //Сделали второй заказ с одним продуктом

        client.getSomeOrderSet().add(someOrder1);
        client.getSomeOrderSet().add(someOrder2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(client);

        session.getTransaction().commit();
        session.close();

    }

    public void addCategory(String name){
        Category category = new Category();
        category.setName(name);
        Session session = sessionFactory.openSession();
        session.getTransaction();

        session.save(category);
    }
}
