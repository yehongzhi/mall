package io.github.yehongzhi.rabbitmqconsumer.start;

import io.github.yehongzhi.rabbitmqconsumer.service.IRbSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class MessageSenderCallBack implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(MessageSenderCallBack.class);
    @Resource
    private IRbSendService rbSendService;

    @Value("${thread.messageNum}")
    private Integer maxNum;

    @Value("${thread.number}")
    private Integer coreNum;
    @Value("${file.dir}")
    private String dir;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("初始化线程池,线程数{}", coreNum);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreNum, coreNum, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        logger.info("初始化线程池成功");
        logger.info("读取文件夹，{}", dir);
        File file = new File(dir);
        final LinkedBlockingQueue<String> fileNameQueue = new LinkedBlockingQueue<>();
        for (String name : file.list()) {
            String fileName = dir + "\\" + name;
            fileNameQueue.put(fileName);
            logger.info(fileName);
        }
        logger.info("每个线程读取{}个文件", maxNum);

        for (Integer i = 0; i < coreNum; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for (Integer fileCount = 0; fileCount < maxNum; fileCount++) {
                        StopWatch stopWatch = null;
                        String fileName;
                        try {
                            fileName = fileNameQueue.poll(0, TimeUnit.SECONDS);
                            stopWatch = new StopWatch(Thread.currentThread().getName() + ":文件-》" + fileName);
                        } catch (InterruptedException e) {
                            return;
                        }
                        if (fileName == null) {
                            logger.info(Thread.currentThread().getName() + ":文件已被读取完，结束执行");
                            return;
                        }
                        BufferedReader bufferedReader = null;
                        try {
                            bufferedReader = new BufferedReader(new FileReader(fileName));
                            String msg;
                            stopWatch.start("发送消息");
                            while (!StringUtils.isEmpty(msg = bufferedReader.readLine())) {
                                rbSendService.sendMsg(msg);
                            }
                            stopWatch.stop();
                        } catch (FileNotFoundException e) {
                            logger.error(e.getMessage());
                        } catch (IOException e) {
                            logger.error(e.getMessage());
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {}
                            }
                        }
                        logger.info("\n"+stopWatch.prettyPrint());
                    }
                }
            });
        }

    }
}
