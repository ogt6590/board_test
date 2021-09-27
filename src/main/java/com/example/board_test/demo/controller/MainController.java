package com.example.board_test.demo.controller;

import com.example.board_test.demo.Entity.BoardEntity;
import com.example.board_test.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    BoardService boardService;
    //게시판 전체 리스트 가져오기
    @RequestMapping("/")
    public ModelAndView  mainView(Model model){
        List<BoardEntity> board=boardService.AllList();
        ModelAndView mv = new ModelAndView("board/list");
        mv.addObject("list",board);
        return mv;
    }
    //게시글 작성화면이동
    @RequestMapping("/write")
    public String writeView(Model model){
        return "board/write";
    }
    //게시글 등록
    @RequestMapping("/boardWrite")
    public String boardWrite(HttpServletRequest request){
        String writer=request.getParameter("writer");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        BoardEntity boardEntity=new BoardEntity();
        //현재 날짜가져오기
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
        Date time = new Date();
        boardEntity.setCreated_date(time);
        boardEntity.setWriter(writer);
        boardEntity.setTitle(title);
        boardEntity.setContent(content);
        boardService.save(boardEntity);
        return "redirect:/";
    }
    @RequestMapping("/detail")
    public ModelAndView  detailView(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("board/detail");
        String key=request.getParameter("id");
        int id=Integer.parseInt(key);
        mv.addObject("value", boardService.getOne(id));
        return mv;
    }
}
