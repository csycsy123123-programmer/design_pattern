package consume_produce_solution;

import java.util.*;

public class ConsumeAndProduceWithSynchronized {
    private final Queue<Integer> cache;
    private final Object monitor;
    private final int size;

    public ConsumeAndProduceWithSynchronized(int size) {
        cache = new LinkedList<>();
        monitor = new Object();
        this.size = size;
    }

    public void produce() {
        Random random = new Random();
        int data = 0;
        while (true) {
            try {
                Thread.sleep(random.nextInt(101));
                data++;
                //produce completed
                synchronized (monitor) {
                    while (cache.size() == size) {
                        monitor.wait();
                    }
                    cache.add(data);
                    monitor.notifyAll();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void consume() {
        while (true) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(50));
                synchronized (monitor) {
                    while (cache.isEmpty()) {
                        monitor.wait();
                    }
                    int a = cache.poll();
                    System.out.println(a);
                    monitor.notifyAll();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void run() {
        new Thread(this::consume).start();
        new Thread(this::produce).start();
    }
}
