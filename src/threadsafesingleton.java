public class threadsafesingleton {
    // ThreadSafeSingleton.java
    public static class ThreadSafeSingleton {

        // Step 1: Declare a private static volatile instance
        private static volatile ThreadSafeSingleton instance;

        // Step 2: Private constructor to prevent instantiation
        private ThreadSafeSingleton() {
            System.out.println("Singleton instance created!");
        }

        // Step 3: Public method to return the singleton instance
        public static ThreadSafeSingleton getInstance() {
            if (instance == null) { // First check (no locking)
                synchronized (ThreadSafeSingleton.class) {
                    if (instance == null) { // Second check (with locking)
                        instance = new ThreadSafeSingleton();
                    }
                }
            }
            return instance;
        }

        // Example method
        public void showMessage() {
            System.out.println("Hello from Singleton instance: " + this.hashCode());
        }

        // Main method to test Singleton in multithreaded environment
        public static void main(String[] args) {

            // Creating multiple threads that try to get the instance
            Runnable task = () -> {
                ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
                singleton.showMessage();
            };

            // Create and start multiple threads
            Thread t1 = new Thread(task);
            Thread t2 = new Thread(task);
            Thread t3 = new Thread(task);

            t1.start();
            t2.start();
            t3.start();
        }
    }

}
