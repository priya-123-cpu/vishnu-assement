import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class mapcomparsiondemo {



        public static void main(String[] args) throws InterruptedException {
            // HashMap (not thread-safe)
            Map<Integer, String> hashMap = new HashMap<>();

            // ConcurrentHashMap (thread-safe)
            Map<Integer, String> concurrentHashMap = new Map<Integer, String>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean containsKey(Object key) {
                    return false;
                }

                @Override
                public boolean containsValue(Object value) {
                    return false;
                }

                @Override
                public String get(Object key) {
                    return "";
                }

                @Override
                public String put(Integer key, String value) {
                    return "";
                }

                @Override
                public String remove(Object key) {
                    return "";
                }

                @Override
                public void putAll(Map<? extends Integer, ? extends String> m) {

                }

                @Override
                public void clear() {

                }

                @Override
                public Set<Integer> keySet() {
                    return Set.of();
                }

                @Override
                public Collection<String> values() {
                    return List.of();
                }

                @Override
                public Set<Entry<Integer, String>> entrySet() {
                    return Set.of();
                }

                @Override
                public boolean equals(Object o) {
                    return false;
                }

                @Override
                public int hashCode() {
                    return 0;
                }
            };

            System.out.println("=== Demonstrating HashMap (NOT Thread-Safe) ===");
            runTest(hashMap);

            System.out.println("\n=== Demonstrating ConcurrentHashMap (Thread-Safe) ===");
            runTest(concurrentHashMap);
        }

        private static void runTest(Map<Integer, String> map) throws InterruptedException {
            // Create multiple threads that write to the map
            Thread writer1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    map.put(i, "A" + i);
                }
            });

            Thread writer2 = new Thread(() -> {
                for (int i = 1000; i < 2000; i++) {
                    map.put(i, "B" + i);
                }
            });

            Thread reader = new Thread(() -> {
                int nullCount = 0;
                for (int i = 0; i < 2000; i++) {
                    if (map.get(i) == null) nullCount++;
                }
                System.out.println(Thread.currentThread().getName() + " found " + nullCount + " null entries.");
            });

            // Start threads
            writer1.start();
            writer2.start();
            reader.start();

            // Wait for threads to finish
            writer1.join();
            writer2.join();
            reader.join();

            // Print final map size
            System.out.println("Final Map size: " + map.size());
        }
    }


