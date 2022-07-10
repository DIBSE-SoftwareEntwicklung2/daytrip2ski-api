package com.daytrip2ski.api.skiresort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Controller layer of skiresort
 * <a href="http://daytrip2ski-api.herokuapp.com/swagger-ui.html#/skiresort-controller">API docukentation</a>
 */
@RestController
@RequestMapping(path = "api/v1/skiresort")
public class SkiresortController {
    private final SkiresortService skiresortService;

    /**
     * Constructor
     * @param skiresortService service of skiresort
     */
    @Autowired
    public SkiresortController(SkiresortService skiresortService) {
        this.skiresortService = skiresortService;
    }

    /**
     * Get all skiresorts
     * @return list of skiresorts
     */
    @GetMapping
    public List<Skiresort> getSkiresorts() {
        return skiresortService.getSkiresorts();
    }

    /**
     * Find skiresort by id
     * @param id id
     * @return skiresort
     */
    @GetMapping(path = "{id}")
    public Optional<Skiresort> findSkiresortById(@PathVariable("id") Long id) {
        return skiresortService.findSkiresortById(id);
    }

    /**
     * Find max distance of easy tracks
     * @return list of skiresorts with max easy distance
     */
    @GetMapping(path = "maxdistanceeasy")
    public List<Skiresort> findSkiresortByMaxDistanceEasy() {
        return skiresortService.findSkiresortsByMaxDistanceEasy();
    }

    /**
     * Find min distance of easy tracks
     * @return list of skiresorts with min easy distance
     */
    @GetMapping(path = "mindistanceeasy")
    public List<Skiresort> findSkiresortByMinDistanceEasy() {
        return skiresortService.findSkiresortsByMinDistanceEasy();
    }

    /**
     * Find max distance of intermediate tracks
     * @return list of skiresorts with max intermediate distance
     */
    @GetMapping(path = "maxdistanceintermediate")
    public List<Skiresort> findSkiresortByMaxDistanceIntermediate() {
        return skiresortService.findSkiresortsByMaxDistanceIntermediate();
    }

    /**
     * Find min distance of intermediate tracks
     * @return list of skiresorts with min intermediate distance
     */
    @GetMapping(path = "mindistanceintermediate")
    public List<Skiresort> findSkiresortByMinDistanceIntermediate() {
        return skiresortService.findSkiresortsByMinDistanceIntermediate();
    }

    /**
     * Find max distance of difficult tracks
     * @return list of skiresorts with max difficult distance
     */
    @GetMapping(path = "maxdistancedifficult")
    public List<Skiresort> findSkiresortByMaxDistanceDifficult() {
        return skiresortService.findSkiresortsByMaxDistanceDifficult();
    }

    /**
     * Find min distance of difficult tracks
     * @return list of skiresorts with min difficult distance
     */
    @GetMapping(path = "mindistancedifficult")
    public List<Skiresort> findSkiresortByMinDistanceDifficult() {
        return skiresortService.findSkiresortsByMinDistanceDifficult();
    }

    /**
     * Find max number of climbing aids
     * @return max number of climbing aids
     */
    @GetMapping(path = "maxnumbersofclimbingaids")
    public Long findMaxNumbersOfClimbingAids() {
        return skiresortService.findMaxNumbersOfClimbingAids();
    }

    /**
     * Find min number of climbing aids
     * @return min number of climbing aids
     */
    @GetMapping(path = "minnumbersofclimbingaids")
    public Long findMinNumbersOfClimbingAids() {
        return skiresortService.findMinNumbersOfClimbingAids();
    }
}
