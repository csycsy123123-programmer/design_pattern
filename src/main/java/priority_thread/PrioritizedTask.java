package priority_thread;

public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private final int priority; // 优先级数值（越大优先级越高）
    private final Runnable task;

    public PrioritizedTask(int priority, Runnable task) {
        this.priority = priority;
        this.task = task;
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return Integer.compare(o.priority, priority);
    }

    @Override
    public void run() {
        task.run();
    }
}
