package com.daytrip2ski.api.skiresort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
