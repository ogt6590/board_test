package com.example.board_test.demo.Repository;


import com.example.board_test.demo.Entity.BoardEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    
    @Override
    <S extends BoardEntity> S save(S entity);

    @Override
    BoardEntity getOne(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Transactional
    @Modifying
    @Query("delete from board_test b where b.id in :ids")
    void deleteAllByIdInQuery(int[] ids);

    @Override
    Page<BoardEntity> findAll(Pageable pageable);
}
