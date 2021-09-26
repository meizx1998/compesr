import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AutoMit {

  private static int n=0;

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                int i1 = n++;
                System.out.println("t1:"+i1);
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                int i1 = n++;
                System.out.println("t2:"+i1);
            }
        }).start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            System.out.printf("ss");
        });
    }
}
