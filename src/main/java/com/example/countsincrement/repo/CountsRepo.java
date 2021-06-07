package com.example.countsincrement.repo;

import com.example.countsincrement.model.Counts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

public interface CountsRepo extends JpaRepository<Counts, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Counts U SET U.count=?2 WHERE U.id=?1", nativeQuery = true)
    void updateCount(int id, long count);
}
