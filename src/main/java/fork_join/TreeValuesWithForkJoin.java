package fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TreeValuesWithForkJoin {
    public static class TreeNode {
        private final TreeNode leftChild;
        private final TreeNode rightChild;
        private final int value;

        TreeNode(TreeNode leftChild, TreeNode rightChild, int value) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.value = value;
        }
    }

    private static class TreeValueTask extends RecursiveTask<Integer> {
        private final TreeNode node;

        public TreeValueTask(TreeNode node) {
            this.node = node;
        }

        @Override
        protected Integer compute() {
            if (node == null) {
                return 0;
            }
            TreeValueTask left = new TreeValueTask(node.leftChild);
            TreeValueTask right = new TreeValueTask(node.rightChild);
            left.fork();
            right.fork();
            return 2 * (node.value + left.join() + right.join());
        }
    }

    public static int run(TreeNode node) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        TreeValueTask treeValueTask = new TreeValueTask(node);
        return forkJoinPool.invoke(treeValueTask);
    }
}
