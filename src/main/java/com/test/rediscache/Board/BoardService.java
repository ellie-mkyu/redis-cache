package com.test.rediscache.Board;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {

    private final BoardRepository repository;

    public BoardService (BoardRepository repository) {
        this.repository = repository;
    }

    @Cacheable(key="#size", value = "getBoards")
    public List<Board> getBoards(String size){
        return repository.createBySize(size);
    }

    public static int getDbCount() {
        return BoardRepository.getDbCount();
    }
}
