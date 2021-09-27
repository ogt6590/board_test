package com.example.board_test.demo.Entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Configuration
@Entity(name="board_test")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date created_date;
    private String content;
    private String title;
    private String writer;

    @Builder
    public BoardEntity(Date created_date
            ,String content,String title,String writer){
        this.created_date=created_date;
        this.content=content;
        this.title=title;
        this.writer=writer;
    }

}
