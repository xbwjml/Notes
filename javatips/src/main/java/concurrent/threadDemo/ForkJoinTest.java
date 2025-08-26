package concurrent.threadDemo;

import utils.LogUtils;

import java.util.concurrent.*;

public class ForkJoinTest extends RecursiveTask<Integer> {
    final int ThRESHOLD = 2;
    int start;
    int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= ThRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++)
                sum += i;
        }
        else {
            int middle = (start + end) / 2;
            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle + 1, end);

            leftTask.fork();
            rightTask.fork();

            Integer leftRes = leftTask.join();
            Integer rightRes = rightTask.join();
            sum = leftRes + rightRes;
        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTest task = new ForkJoinTest(1, 400);
        Future<Integer> result = pool.submit(task);

        task.isCompletedAbnormally();
        task.getException();

        try {
            LogUtils.log(result.get());
        } catch (InterruptedException | ExecutionException e) {

        }
    }
}
