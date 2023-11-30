package com.ryan9025.jpa.service;

import com.ryan9025.jpa.dto.BoardDto;
import com.ryan9025.jpa.entity.Board02;
import com.ryan9025.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto insertBoard(BoardDto boardDto) {
        Board02 dbInsertBoard = Board02.builder()
                .subject(boardDto.getSubject())
                .content(boardDto.getContent())
                .build();
        Board02 responseBoard = boardRepository.save(dbInsertBoard);
        BoardDto responseBoardDto = BoardDto.fromEntity(responseBoard);
        return responseBoardDto;
    }

    public List<BoardDto> getAllBoard() {
       List<Board02> board02List = boardRepository.findAll();
       List<BoardDto> boardList = new ArrayList<>();
       for(int i = 0; i < board02List.size(); i++) {
           boardList.add(BoardDto.fromEntity(board02List.get(i)));
       }
       return boardList;
    }
    // find메서드 사용시 Optional을 들고옴!
    public Board02 getBoard(int id) {
        Optional<Board02> board = boardRepository.findById(id);
        if(board.isPresent()) {
            return board.get();
        }
            return null;
            //throw new DataNotFoundException("찾는 id가 없음");
    }
}
