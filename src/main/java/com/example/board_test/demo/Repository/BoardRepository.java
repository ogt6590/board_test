package com.example.board_test.demo.Repository;

import com.example.board_test.demo.Entity.BoardEntity;
import com.example.board_test.demo.Entity.QBoardEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;


public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    QBoardEntity qboardentity = new QBoardEntity("m"); // 직접 지정

    EntityManager em = emf.createEntityManager();

    JPAQueryFactory query = new JPAQueryFactory(em);
    List<BoardEntity> result =
            query.selectFrom(qboardentity)
                    .where(qboardentity.writer.eq("member1"))
                    .orderBy(qboardentity.writer.desc())
                    .fetch();



}
