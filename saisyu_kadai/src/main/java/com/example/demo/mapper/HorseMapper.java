package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Horse;

@Mapper
public interface HorseMapper {

    List<Horse> findAll();

    Horse findById(Integer id);
}
