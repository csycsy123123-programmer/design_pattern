package fork_join;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MergeSortWithForkJoin {
    public void run() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int[] nums = new int[]{-1, 1321321, 12312312, 111, 111, 4556, 111, 3131, 313113, 133131, 133131};
        MergeSortTask mergeSortTask = new MergeSortTask(nums, 0, nums.length - 1);
        forkJoinPool.invoke(mergeSortTask);
    }

    private static class MergeSortTask extends RecursiveAction {
        private final int[] nums;
        private final int start;
        private final int end;

        public MergeSortTask(int[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            int mid = start + (end - start) / 2;
            MergeSortTask leftMergeSortTask = new MergeSortTask(nums, start, mid);
            MergeSortTask rightMergeSortTask = new MergeSortTask(nums, mid + 1, end);
            invokeAll(leftMergeSortTask, rightMergeSortTask);
            merge(nums, start, mid, end);
        }

        private void merge(int[] nums, int left, int mid, int right) {
            int[] temp = Arrays.copyOfRange(nums, left, mid);
            int l1 = 0;
            int l2 = mid + 1;
            int cur = left;
            while (l1 < temp.length && l2 <= right) {
                if (temp[l1] <= nums[l2]) {
                    nums[cur++] = temp[l1++];
                } else {
                    nums[cur++] = temp[l2++];
                }
            }
            while (l1 < temp.length) {
                nums[cur++] = temp[l1++];
            }
            while (l2 <= right) {
                nums[cur++] = temp[l2++];
            }
        }
    }
}

