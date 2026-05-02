package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Horse;
import com.example.demo.mapper.HorseMapper;

@Service
public class HorseService {

    private final HorseMapper mapper;

    public HorseService(HorseMapper mapper) {
        this.mapper = mapper;
    }

    public List<Horse> findAll() {
        return mapper.findAll();
    }

    public Horse findById(Integer id) {
        Horse horse = mapper.findById(id);
        if (horse == null) {
            throw new RuntimeException("データなし");
        }
        return horse;
    }
}