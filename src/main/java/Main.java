import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> myCallable1 = new MyCallable("1");
        Callable<Integer> myCallable2 = new MyCallable("2");
        Callable<Integer> myCallable3 = new MyCallable("3");
        Callable<Integer> myCallable4 = new MyCallable("4");

        final ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Callable <Integer>> tasks = new ArrayList<>();
        tasks.add(myCallable1);
        tasks.add(myCallable2);
        tasks.add(myCallable3);
        tasks.add(myCallable4);

        int resultOfAll = 0;
        for(Future<Integer> task : threadPool.invokeAll(tasks)){
            resultOfAll += task.get();
        }
        System.out.println(resultOfAll);
        threadPool.shutdown();

//        System.out.println(threadPool.invokeAny(tasks));
//        threadPool.shutdown();
    }
}
