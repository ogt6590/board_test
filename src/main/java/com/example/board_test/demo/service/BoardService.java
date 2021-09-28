package com.example.board_test.demo.service;

import com.example.board_test.demo.Entity.BoardEntity;
import com.example.board_test.demo.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardEntity> AllList() {
        return boardRepository.findAll();
    }

    public void write(HttpServletRequest request) {
        //현재 날짜가져오기
        Date time = new Date();
        BoardEntity boardEntity=new BoardEntity();
        boardEntity.setCreated_date(time);
        boardEntity.setWriter(request.getParameter("writer"));
        boardEntity.setTitle(request.getParameter("title"));
        boardEntity.setContent(request.getParameter("content"));
        boardRepository.save(boardEntity);
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
    public BoardEntity update(HttpServletRequest request) {
        String key=request.getParameter("id");
        int id=Integer.parseInt(key);
        BoardEntity board=boardRepository.getOne(id);
        //값이 존재하면 수정
        if(null!=board){
            board.setWriter(request.getParameter("writer"));
            board.setContent(request.getParameter("content"));
            board.setTitle(request.getParameter("title"));
        }
        boardRepository.save(board);
        //수정후 상세페이지 이동
        return boardRepository.getOne(id);
    }
}
