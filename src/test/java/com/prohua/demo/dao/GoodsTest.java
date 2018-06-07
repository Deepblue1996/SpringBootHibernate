package com.prohua.demo.dao;

import com.prohua.demo.Entity.GoodsEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GoodsTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        // 创建配置对象
        Configuration config = new Configuration().configure();
        //config.addClass(Students.class);
        // 创建服务注册对象
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        // 创建会话工厂对象
        sessionFactory = config.buildSessionFactory(standardServiceRegistry);
        // 创建会话对象
        session = sessionFactory.openSession();
        // 开启事务
        transaction = session.beginTransaction();
    }

    @After
    public void destory() {
        // 提交事务
        transaction.commit();
        // 关闭会话
        session.close();
        // 关闭会话工厂
        sessionFactory.close();
    }

    @Test
    public void testSaveStudents() {
        GoodsEntity s = new GoodsEntity(4);
        session.save(s);
    }

    @Test
    public void testSelectStudents() {
        Criteria c = session.createCriteria(GoodsEntity.class);
        //c.add(Restrictions.eq("id", 1));//eq是等于，gt是大于，lt是小于,or是或

        List<GoodsEntity> list = c.list();
        for (GoodsEntity admin : list) {
            System.out.println("打印:" + admin.getSid());
        }
    }
}
