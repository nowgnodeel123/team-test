package org.example.testassignment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.testassignment.common.BoardDto;
import org.example.testassignment.domain.Board;
import org.example.testassignment.repository.BoardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

  BoardRepository boardRepository;

  // 생성
  @Transactional
  public ResponseEntity<String> addPost(BoardDto dto) {
    Board board = new Board(dto.getTitle(), dto.getContent(), dto.getAuthor(), dto.getCreateTime());
    boardRepository.save(board);
    return new ResponseEntity<>("추가", HttpStatus.OK);
  }

  // 조회
  @Transactional
  public ResponseEntity<List<Board>> viewAllPosts() {
    return new ResponseEntity<>(boardRepository.findAll(), HttpStatus.OK);
  }

  // 수정
  @Transactional
  public ResponseEntity<String> modifyPost(Long id, BoardDto dto) {
    Board board = boardRepository.findBoardById(id).get();

    board.setTitle(dto.getTitle());
    board.setContent(dto.getContent());
    board.setAuthor(dto.getAuthor());

    boardRepository.save(board);

    return new ResponseEntity<>("수정", HttpStatus.OK);
  }

  // 삭제
  @Transactional
  public ResponseEntity<String> deletePost(Long id) {
    boardRepository.deleteById(id);
    return new ResponseEntity<>("삭제", HttpStatus.OK);
  }
}
