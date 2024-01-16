package com.ssafy.backend.board.service;

import com.ssafy.backend.board.dto.BoardDto;
import lombok.Builder;

import java.util.List;

public class BoardListResponseDto {
    private List<BoardDto> boards;
    private int totalPages;

    @Builder
    public BoardListResponseDto(List<BoardDto> boards, int totalPages) {
        this.boards = boards;
        this.totalPages = totalPages;
    }

    public List<BoardDto> getBoards() { return boards; }
    public int getTotalPages() { return totalPages; }
}
