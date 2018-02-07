package activeMq;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producter {

    //ActiveMq 的默认用户名
    private static final String USERNAME = "amdin";
    //ActiveMq 的默认登录密码
    private static final String PASSWORD = "admin";
    //ActiveMQ 的链接地址
    private static final String BROKEN_URL = "http://localhost:8161/";


    AtomicInteger count = new AtomicInteger(0);
    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;
    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();

    public void init() {
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true, Session.SESSION_TRANSACTED);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String disname) {
        try {
            Queue queue = session.createQueue(disname);
            MessageProducer messageProducer = null;
            if (threadLocal.get() != null) {
                messageProducer = threadLocal.get();
                threadLocal.set(messageProducer);
            }
            while (true) {
                Thread.sleep(1000);
                int num = count.getAndIncrement();
                TextMessage msg = session.createTextMessage(Thread.currentThread().getName() + "productor:我是product, count:" + num);
                System.out.println(Thread.currentThread().getName() + "producor: i write something ,count:" + num);
                messageProducer.send(msg);
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
