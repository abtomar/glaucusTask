package com.example.countsincrement.controller;

import com.example.countsincrement.model.Counts;
import com.example.countsincrement.repo.CountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class CountsController {
    static long count = 0;

    @Autowired
    private CountsRepo countsRepo;

    @GetMapping("count")
    public synchronized long getCount(Counts counts) {
      Optional<Counts> c = countsRepo.findById(0);
        count= c.get().getCount() +1;
        counts.setCount(count);
        if(count<=1)
            countsRepo.save(counts);
        else
            countsRepo.updateCount(0,count);
        return count;
    }

}
