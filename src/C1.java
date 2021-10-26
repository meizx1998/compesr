import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class C1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                8,
                2,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<Runnable>(),
                Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.execute(() -> {

        });
    }
}
