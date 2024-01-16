package com.ssafy.backend.board.service;

import com.ssafy.backend.board.domain.Board;
import com.ssafy.backend.board.domain.Tag;
import com.ssafy.backend.board.dto.BoardCreateRequestDto;
import com.ssafy.backend.board.dto.BoardDeleteRequestDto;
import com.ssafy.backend.board.dto.BoardModifyRequestDto;
import com.ssafy.backend.board.repository.BoardRepository;
import com.ssafy.backend.board.repository.TagRepository;
import com.ssafy.backend.common.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    private final TagRepository tagRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, TagRepository tagRepository) {
        this.boardRepository = boardRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public void boardCreate(BoardCreateRequestDto dto,String userId){
        Tag tag = tagRepository.findByTagId(dto.getTagId())
                .orElseThrow(() -> new MyException("없는 태그입니다.", HttpStatus.BAD_REQUEST));
        boardRepository.save(dto.toEntity(tag,userId));
    }

    @Override
    public void delete(BoardDeleteRequestDto dto, String userId) {
        Board board = boardRepository.findByBoardIdAndUserId(dto.getBoardId(),userId)
                .orElseThrow(() ->new MyException("삭제할 글이 없습니다",HttpStatus.BAD_REQUEST));
        boardRepository.delete(board);
    }

    @Override
    public void update(BoardModifyRequestDto dto, String userId) {
        Board board = boardRepository.findByBoardIdAndUserId(dto.getBoardId(),userId)
                .orElseThrow(() ->new MyException("수정할 글이 없습니다.",HttpStatus.BAD_REQUEST));
        Tag tag = tagRepository.findByTagId(dto.getTagId())
                .orElseThrow(() -> new MyException("없는 태그입니다.", HttpStatus.BAD_REQUEST));

        board.updateBoard(tag,dto.getBoardTitle(),dto.getBoardContent());
        boardRepository.save(board);

    }
}