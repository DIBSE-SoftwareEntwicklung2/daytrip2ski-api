package com.daytrip2ski.api.skiresort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkiresortRepository extends JpaRepository<Skiresort, Long> {
}
