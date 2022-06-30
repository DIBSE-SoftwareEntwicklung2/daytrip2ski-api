package com.daytrip2ski.api.skiresort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkiresortRepository extends JpaRepository<Skiresort, Long> {
    @Query("SELECT s FROM Skiresort s WHERE s.distanceEasy = (SELECT max(s2.distanceEasy) FROM Skiresort s2)")
    List<Skiresort> findSkiresortByMaxDistanceEasy();
    @Query("SELECT s FROM Skiresort s WHERE s.distanceEasy = (SELECT min(s2.distanceEasy) FROM Skiresort s2)")
    List<Skiresort> findSkiresortByMinDistanceEasy();
    @Query("SELECT s FROM Skiresort s WHERE s.distanceIntermediate = (SELECT max(s2.distanceIntermediate) FROM Skiresort s2)")
    List<Skiresort> findSkiresortByMaxDistanceIntermediate();
    @Query("SELECT s FROM Skiresort s WHERE s.distanceIntermediate = (SELECT min(s2.distanceIntermediate) FROM Skiresort s2)")
    List<Skiresort> findSkiresortByMinDistanceIntermediate();
    @Query("SELECT s FROM Skiresort s WHERE s.distanceDifficult = (SELECT max(s2.distanceDifficult) FROM Skiresort s2)")
    List<Skiresort> findSkiresortByMaxDistanceDifficult();
    @Query("SELECT s FROM Skiresort s WHERE s.distanceIntermediate = (SELECT min(s2.distanceIntermediate) FROM Skiresort s2)")
    List<Skiresort> findSkiresortByMinDistanceDifficult();
}
