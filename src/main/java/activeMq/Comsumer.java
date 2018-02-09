package activeMq;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Comsumer {


    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();
    AtomicInteger count = new AtomicInteger();

    public void init() {
        try {
            connectionFactory = new ActiveMQConnectionFactory(AQConf.USERNAME, AQConf.PASSWORD, AQConf.BROKEN_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (Exception e) {
        }
    }

    public void getMessage(String disname) {
        try {
            Queue queue = session.createQueue(disname);
            MessageConsumer consumer = null;
            if (threadLocal.get() != null) {
                consumer = threadLocal.get();
            } else {
                consumer = session.createConsumer(queue);
                threadLocal.set(consumer);
            }
            while (true) {
                Thread.sleep(1000);
                TextMessage msg = (TextMessage) consumer.receive();
                if (msg == null) continue;
                msg.acknowledge();
                System.out.println(Thread.currentThread().getName() + ": Consumer:我是消费者,我正在消费Msg" + msg.getText() + "---->" + count.getAndIncrement());
            }
        } catch (Exception e) {

        }

    }
}
