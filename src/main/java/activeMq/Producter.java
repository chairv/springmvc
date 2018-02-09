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

    AtomicInteger count = new AtomicInteger(0);
    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;
    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();

    public void init() {
        connectionFactory = new ActiveMQConnectionFactory(AQConf.USERNAME, AQConf.PASSWORD, AQConf.BROKEN_URL);
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
            } else {
                messageProducer = session.createProducer(queue);
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
