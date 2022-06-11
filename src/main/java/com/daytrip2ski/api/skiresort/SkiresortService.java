package com.daytrip2ski.api.skiresort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
