package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVo = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2023,05,24))
                .build();

        todoDAO.insert(todoVo);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo-> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L; // 반드시 존재하는 번호를 이용
        TodoVO vo = todoDAO.selectOne(tno);
        System.out.println(vo);
    }

    @Test
    public void testDeleteOne() throws Exception {
        Long tno = 1L; // 반드시 존재하는 번호를 이용
        todoDAO.deleteOne(tno);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("BIS Title...")
                .dueDate(LocalDate.of(2023,05,24))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}