package activeMq;


public class TestConsumer {

    public static void main(String[] args) {
        Comsumer comsumer = new Comsumer();
        comsumer.init();
        TestConsumer testConsumer = new TestConsumer();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
    }

    private class ConsumerMq implements Runnable {
        Comsumer comsumer;

        public ConsumerMq(Comsumer comsumer) {
            this.comsumer = comsumer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    comsumer.getMessage("Jaycekon-MQ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
