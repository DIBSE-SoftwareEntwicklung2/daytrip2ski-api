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

    /**
     * Getting all Skiresorts
     *
     * @return List<Skiresort>
     */
    public List<Skiresort> getSkiresorts() {
        return skiresortRepository.findAll();
    }

    /**
     * Search a skiresort with that id
     *
     * @param id
     * @throws IllegalStateException
     * @return Skiresort
     */
    public Optional<Skiresort> findSkiresortById(Long id) {
        Optional<Skiresort> skiresortOptional = skiresortRepository.findById(id);
        if (skiresortOptional.isEmpty()) {
            throw new IllegalStateException("Skiresort not there");
        }
        return skiresortOptional;
    }

    /**
     * Find skiresorts with maximum distance for
     * category easy
     *
     * @return List<Skiresort>
     */
    public List<Skiresort> findSkiresortsByMaxDistanceEasy() {
        return skiresortRepository.findSkiresortByMaxDistanceEasy();
    }

    /**
     * Find skiresorts with minimum distance for
     * category easy
     *
     * @return List<Skiresort>
     */
    public List<Skiresort> findSkiresortsByMinDistanceEasy() {
        return skiresortRepository.findSkiresortByMinDistanceEasy();
    }

    /**
     * Find skiresorts with maximum distance for
     * category intermediate
     *
     * @return List<Skiresort>
     */
    public List<Skiresort> findSkiresortsByMaxDistanceIntermediate() {
        return skiresortRepository.findSkiresortByMaxDistanceIntermediate();
    }

    /**
     * Find skiresorts with minimum distance for
     * category intermediate
     *
     * @return List<Skiresort>
     */
    public List<Skiresort> findSkiresortsByMinDistanceIntermediate() {
        return skiresortRepository.findSkiresortByMinDistanceIntermediate();
    }

    /**
     * Find skiresorts with maximum distance for
     * category difficult
     *
     * @return List<Skiresort>
     */
    public List<Skiresort> findSkiresortsByMaxDistanceDifficult() {
        return skiresortRepository.findSkiresortByMaxDistanceDifficult();
    }

    /**
     * Find skiresorts with minimum distance for
     * category difficult
     *
     * @return List<Skiresort>
     */
    public List<Skiresort> findSkiresortsByMinDistanceDifficult() {
        return skiresortRepository.findSkiresortByMinDistanceDifficult();
    }

    /**
     * The maximum numbers of climbing aids
     * of all skiresorts
     *
     * @return Long
     */
    public Long findMaxNumbersOfClimbingAids() {
        return skiresortRepository.findMaxNumbersOfClimbingAids();
    }

    /**
     * The minimum numbers of climbing aids
     * of all skiresorts
     *
     * @return Long
     */
    public Long findMinNumbersOfClimbingAids() {
        return skiresortRepository.findMinNumbersOfClimbingAids();
    }
}
