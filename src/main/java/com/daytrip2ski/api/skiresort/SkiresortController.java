package com.daytrip2ski.api.skiresort;

import com.daytrip2ski.api.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/skiresort")
public class SkiresortController {
    private final SkiresortService skiresortService;

    @Autowired
    public SkiresortController(SkiresortService skiresortService) {
        this.skiresortService = skiresortService;
    }

    @GetMapping
    public List<Skiresort> getSkiresorts() {
        return skiresortService.getSkiresorts();
    }

    @GetMapping(path = "{id}")
    public Optional<Skiresort> findSkiresortById(@PathVariable("id") Long id) {
        return skiresortService.findSkiresortById(id);

    @GetMapping(path = "maxdistanceeasy")
    public List<Skiresort> findSkiresortByMaxDistanceEasy() {
        return skiresortService.findSkiresortsByMaxDistanceEasy();
    }

    @GetMapping(path = "mindistanceeasy")
    public List<Skiresort> findSkiresortByMinDistanceEasy() {
        return skiresortService.findSkiresortsByMinDistanceEasy();
    }

    @GetMapping(path = "maxdistanceintermediate")
    public List<Skiresort> findSkiresortByMaxDistanceIntermediate() {
        return skiresortService.findSkiresortsByMaxDistanceIntermediate();
    }

    @GetMapping(path = "mindistanceintermediate")
    public List<Skiresort> findSkiresortByMinDistanceIntermediate() {
        return skiresortService.findSkiresortsByMinDistanceIntermediate();
    }

    @GetMapping(path = "maxdistancedifficult")
    public List<Skiresort> findSkiresortByMaxDistanceDifficult() {
        return skiresortService.findSkiresortsByMaxDistanceDifficult();
    }

    @GetMapping(path = "mindistancedifficult")
    public List<Skiresort> findSkiresortByMinDistanceDifficult() {
        return skiresortService.findSkiresortsByMinDistanceDifficult();
    }
}
