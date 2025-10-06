public class multithreaded {
    public static class OddEvenPrinter {

        private final Object lock = new Object();
        private int number = 1;  // start with 1
        private final int MAX = 20;

        class OddThread extends Thread {
            @Override
            public void run() {
                synchronized (lock) {
                    while (number <= MAX) {
                        while (number % 2 == 0) { // wait if it's even's turn
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (number <= MAX) {
                            System.out.println("Odd: " + number);
                            number++;
                            lock.notify(); // wake up even thread
                        }
                    }
                }
            }
        }

        class EvenThread extends Thread {
            @Override
            public void run() {
                synchronized (lock) {
                    while (number <= MAX) {
                        while (number % 2 == 1) { // wait if it's odd's turn
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (number <= MAX) {
                            System.out.println("Even: " + number);
                            number++;
                            lock.notify(); // wake up odd thread
                        }
                    }
                }
            }
        }

        public static void main(String[] args) {
            OddEvenPrinter printer = new OddEvenPrinter();
            Thread t1 = printer.new OddThread();
            Thread t2 = printer.new EvenThread();

            t1.start();
            t2.start();
        }
    }


}
