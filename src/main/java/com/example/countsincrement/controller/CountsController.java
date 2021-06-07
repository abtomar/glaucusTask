package com.example.countsincrement.controller;

import com.example.countsincrement.model.Counts;
import com.example.countsincrement.repo.CountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class CountsController {
    static long initCount = 0;

    @Autowired
    private CountsRepo countsRepo;

    @GetMapping("count")
    public synchronized long getCount(Counts counts) {
        try {
            Optional<Counts> c = countsRepo.findById(0);
            initCount= c.get().getCount() +1;
            counts.setCount(initCount);
            countsRepo.updateCount(0,initCount);
        }
        catch(Exception e){
            initCount=1;
            counts.setCount(initCount);
            countsRepo.save(counts);
        }
        return initCount;
    }

}
