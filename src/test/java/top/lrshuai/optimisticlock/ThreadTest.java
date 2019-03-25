package top.lrshuai.optimisticlock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lrshuai.optimisticlock.usr.dto.TransferDTO;
import top.lrshuai.optimisticlock.usr.service.IUserAccountService;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {

    @Autowired
    private IUserAccountService userAccountService;

    /**
     * 并发测试重试机制
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        TransferDTO dto = new TransferDTO();
        dto.setFromUserId(1001l);
        dto.setToUserId(1002l);
        dto.setAmount(BigDecimal.ONE);

        int clientTotal = 100;
        // 同时并发执行的线程数
        int threadTotal = 20;
        int count = 0;
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //闭锁，可实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    //执行此方法用于获取执行许可，当总计未释放的许可数不超过200时，
                    //允许通行，否则线程阻塞等待，直到获取到许可。
                    semaphore.acquire();
                    userAccountService.transfter(dto);
                    //释放许可
                    semaphore.release();
                } catch (Exception e) {
                    //log.error("exception", e);
                    e.printStackTrace();

                }
                //闭锁减一
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();//线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        executorService.shutdown();
    }
}
