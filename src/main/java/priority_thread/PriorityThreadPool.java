package priority_thread;

import java.lang.reflect.Executable;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 1;
    private static final long KEEP_ALIVE_TIME = 30L;
    private final ThreadPoolExecutor executor;

    public PriorityThreadPool() {
        executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new PriorityBlockingQueue<>(11, new TaskComparator()));
    }

    private static class TaskComparator implements Comparator<Runnable> {
        @Override
        public int compare(Runnable r1, Runnable r2) {
            return ((PrioritizedTask) r1).compareTo((PrioritizedTask) r2);
        }
    }

    public void execute(int priority, Runnable task) {
        executor.execute(new PrioritizedTask(priority, task));
    }

    public void shutdown() {
        executor.shutdown();
    }
}