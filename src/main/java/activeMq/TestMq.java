package activeMq;

public class TestMq {

    public static void main(String[] args) {
        Producter producter = new Producter();
        producter.init();

        TestMq testMq = new TestMq();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
    }


    private class ProductorMq implements Runnable {

        Producter producter;

        public ProductorMq(Producter producter) {
            this.producter = producter;
        }

        @Override
        public void run() {
            while (true) {
                producter.sendMessage("Jaycekon-MQ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
