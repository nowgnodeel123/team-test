package org.example.testassignment.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.testassignment.common.BoardDto;
import org.example.testassignment.common.UsersDto;
import org.example.testassignment.domain.Board;
import org.example.testassignment.domain.Users;
import org.example.testassignment.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

  private final UsersService usersService;

  public UsersController (UsersService usersService) {
    this.usersService = usersService;
  }

  @GetMapping("/form")
  public String usersForm() {
    return "usersForm";
  }

  @PostMapping("/create")
  public ResponseEntity<String> createUsers(@RequestBody UsersDto dto) {
    return usersService.createUsers(dto);
  }

  @GetMapping("/read")
  public ResponseEntity<List<Users>> searchUsers() {
    return usersService.searchUsers();
  }

  @Transactional
  @PutMapping("/update/{id}")
  public ResponseEntity<String> updateUsers(@PathVariable Long id, @RequestBody UsersDto dto) {
    return usersService.updateUsers(id, dto);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteUsers(@PathVariable Long id) {
    return usersService.deleteUsers(id);
  }

  @GetMapping("/boardList/{id}")
  public ResponseEntity<List<Board>> searchUsersBoardList(@PathVariable Long id, Pageable pageable) {
    return new ResponseEntity<>(usersService.getUsersBoardList(id, pageable), HttpStatus.OK);
  }
}
