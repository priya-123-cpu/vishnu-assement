import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;





    // Producer class
    class Producer implements Runnable {
        private BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                int value = 0;
                while (true) {
                    System.out.println("Producer produced: " + value);
                    queue.put(value);  // Puts an item, waits if queue is full
                    value++;
                    Thread.sleep(500);  // Simulate time taken to produce
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Consumer class
    class Consumer implements Runnable {
        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Integer value = queue.take();  // Takes an item, waits if queue is empty
                    System.out.println("Consumer consumed: " + value);
                    Thread.sleep(1000);  // Simulate time taken to consume
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main class
    public class ProducerConsumerExample {
        public static void main(String[] args) {
            // Shared queue with capacity 5
            BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

            // Create producer and consumer threads
            Thread producerThread = new Thread(new Producer(queue));
            Thread consumerThread = new Thread(new Consumer(queue));

            // Start both threads
            producerThread.start();
            consumerThread.start();
        }
    }


