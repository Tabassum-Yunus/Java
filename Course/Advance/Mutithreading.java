package Week11;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;    //Interface, to allow exexute tasks on threads asynchronously
import java.util.concurrent.Executors;          // Class, providses Utility methods for ExecutorService
import java.util.concurrent.Future;             // Interface, Represent the result of an async computation
import java.util.concurrent.TimeUnit;


interface ProcessorTask<T> {            // Functional interface
    void process(T element);
}

class ThreadedProcessor<T> {

    private List<T> elements;

    public ThreadedProcessor(List<T> elements) {            //  initializes the ThreadedProcessor with a list of elements of type T
        this.elements = elements;
    }

    public void process(ProcessorTask<T> task) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
      
        for (T element : elements) {
                    executor.submit(() -> task.process(element)         // return the task's result upon successful completion(Future object).
            );
        }
        
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);     // Exception
    }
}

public class Mutithreading {

    public static void main(String[] args) throws ExecutionException {

        // Example with Integer elements
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        ThreadedProcessor<Integer> intProcessor = new ThreadedProcessor<>(integers);

//        try {
//            intProcessor.process(element -> {
//                System.out.println("Thread: " + Thread.currentThread().getName() + ", Element: " + element);
//            });
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        
        try {
            intProcessor.process(new ProcessorTask<Integer>() {
                @Override
                public void process(Integer element) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + ", Element: " + element);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        // Example with String elements
        System.out.println("");
        List<String> strings = List.of("Multi", "Threading", "in", "java", "programming");
        ThreadedProcessor<String> stringProcessor = new ThreadedProcessor<>(strings);

        try {
            stringProcessor.process(element -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + ", Element: " + element.toUpperCase());
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/*
ExecutorService: An ExecutorService is created with a fixed thread pool size of three. 
This means up to three threads will be managed by this executor, and they can run concurrently. 
The choice of three threads is arbitrary and could be adjusted based on system capabilities and workload requirements.
*/

/*
Concurrency: Each call to process(element) is submitted as a separate task to an ExecutorService,specifically a fixed thread pool with three threads. 
This means the processing of each element is potentially executed concurrently,depending on the availability of threads in the pool. 
This approach can significantly speed up the processing of large lists by utilizing multiple processors or cores.
*/

/*
When executor.submit(() -> task.process(element)) is executed, 
it submits a Runnable task that calls process(element) to the executor.
*/















//class ThreadedProcessor<T> {
//
//    private List<T> elements;
//
//    public ThreadedProcessor(List<T> elements) {
//        this.elements = elements;
//    }
//
//    public void process(ProcessorTask<T> task) throws InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        List<Future> futures = new ArrayList<>();
//       
//        for (T element : elements) {
//            //futures.add(
//                    executor.submit(() -> task.process(element)     // return the task's result upon successful completion.
//            );
//            //));
//        }
//        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.MINUTES);     // Exception
//    
////        for (Future future : futures) {
////            try {
////                future.get(); // Ensure all tasks are completed, Waits if necessary for the computation to complete, and then retrieves its result.
////                //System.out.println(future.get());
////            } catch (ExecutionException e) {
////                e.printStackTrace();
////            }
////        }
//    }
//}


