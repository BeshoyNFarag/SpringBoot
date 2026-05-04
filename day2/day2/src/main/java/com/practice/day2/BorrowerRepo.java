package com.practice.day2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepo extends JpaRepository<BorrowerEntity, Integer> {
}
