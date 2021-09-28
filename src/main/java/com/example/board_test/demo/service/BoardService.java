package com.example.board_test.demo.service;

import com.example.board_test.demo.Entity.BoardEntity;
import com.example.board_test.demo.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardEntity> AllList() {
        return boardRepository.findAll();
    }

    public void save(BoardEntity data) {
        boardRepository.save(data);
    }

    public BoardEntity getOne(int key) {
       return boardRepository.getOne(key);
    }

    public void deleteId(int key){
        boardRepository.deleteById(key);
    }

    public void checkDelete(String[] values){
        int[] ids = Arrays.asList(values).stream().mapToInt(Integer::parseInt).toArray();
        boardRepository.deleteAllByIdInQuery(ids);
    }
}
