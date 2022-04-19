package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Title;

public interface TitleRepository extends JpaRepository <Title, Long> {

}
