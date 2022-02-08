package com.test.rediscache.board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    private final BoardService service;

    public BoardController (BoardService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Board> boards(String size){
        return service.getBoards(size);
    }

    @GetMapping("/count")
    public int count() {
        return BoardService.getDbCount();
    }
}
