package com.crud_springboot3_jpa.services;

import com.crud_springboot3_jpa.entity.User;
import com.crud_springboot3_jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private static final int THREAD_COUNT = 10;
    private static final String CSV_FILE_PATH = "C:\\MOCK_DATA.csv";

    public void readLeadsFromCSV() throws IOException {
        List<User> leads = new ArrayList<>();

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            List<String> lines = br.lines().collect(Collectors.toList());

            forkJoinPool.submit(() ->
                    lines.parallelStream().forEach(line -> {
                        User user = new User();
                        String[] values = line.split(",");
                        user.setName(values[1]);
                        user.setEmail(values[0]);
                        leads.add(user);
                        log.info("Processed by Thread: " + Thread.currentThread().getName());
                    })
            ).join();
        }
        uploadLeadsParallel(leads);
    }
    private void uploadLeadsParallel(List<User> leads) {
        int count = 0;
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (User lead : leads) {
            count++;
            executor.submit(() -> {
                userRepository.save(lead);
                log.info(Thread.currentThread().getName());
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
