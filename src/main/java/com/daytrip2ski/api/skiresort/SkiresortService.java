package com.daytrip2ski.api.skiresort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkiresortService {
    private final SkiresortRepository skiresortRepository;

    @Autowired
    public SkiresortService(SkiresortRepository skiresortRepository) {
        this.skiresortRepository = skiresortRepository;
    }

    public List<Skiresort> getSkiresorts() {
        return skiresortRepository.findAll();
    }

    public Optional<Skiresort> findSkiresortById(Long id) {
        Optional<Skiresort> skiresortOptional = skiresortRepository.findById(id);
        if (skiresortOptional.isEmpty()) {
            throw new IllegalStateException("Skiresort not there");
        }
        return skiresortOptional;
    }

    public List<Skiresort> findSkiresortsByMaxDistanceEasy() {
        return skiresortRepository.findSkiresortByMaxDistanceEasy();
    }

    public List<Skiresort> findSkiresortsByMinDistanceEasy() {
        return skiresortRepository.findSkiresortByMinDistanceEasy();
    }

    public List<Skiresort> findSkiresortsByMaxDistanceIntermediate() {
        return skiresortRepository.findSkiresortByMaxDistanceIntermediate();
    }

    public List<Skiresort> findSkiresortsByMinDistanceIntermediate() {
        return skiresortRepository.findSkiresortByMinDistanceIntermediate();
    }

    public List<Skiresort> findSkiresortsByMaxDistanceDifficult() {
        return skiresortRepository.findSkiresortByMaxDistanceDifficult();
    }

    public List<Skiresort> findSkiresortsByMinDistanceDifficult() {
        return skiresortRepository.findSkiresortByMinDistanceDifficult();
    }

    public Long findMaxNumbersOfClimbingAids() {
        return skiresortRepository.findMaxNumbersOfClimbingAids();
    }

    public Long findMinNumbersOfClimbingAids() {
        return skiresortRepository.findMinNumbersOfClimbingAids();
    }
}
