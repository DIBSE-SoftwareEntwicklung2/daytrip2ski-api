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
    }
}
