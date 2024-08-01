package org.example.testassignment.controller;

import lombok.RequiredArgsConstructor;
import org.example.testassignment.common.BoardDto;
import org.example.testassignment.domain.Board;
import org.example.testassignment.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {

  private final BoardService boardService;

  // 생성
  @PostMapping("/create")
  private ResponseEntity<String> createPost(@RequestBody BoardDto dto) {
    return boardService.addPost(dto);
  }

  // 조회
  @GetMapping("/read")
  private ResponseEntity<List<Board>> getPosts() {
    return boardService.viewAllPosts();
  }

  // 수정
  @PutMapping("/update/{id}")
  private ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody BoardDto dto) {
    return boardService.modifyPost(id, dto);
  }

  // 삭제
  @DeleteMapping("/delete/{id}")
  private ResponseEntity<String> deletePost(@PathVariable Long id) {
    return boardService.deletePost(id);
  }
}
