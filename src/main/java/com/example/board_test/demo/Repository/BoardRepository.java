package com.example.board_test.demo.Repository;


import com.example.board_test.demo.Entity.BoardEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    public List<BoardEntity> findAll();
    @Override
    <S extends BoardEntity> S save(S entity);
    @Override
    BoardEntity getOne(Integer integer);
}
