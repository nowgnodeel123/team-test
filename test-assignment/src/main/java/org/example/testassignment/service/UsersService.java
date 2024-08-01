package org.example.testassignment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.testassignment.common.UsersDto;
import org.example.testassignment.domain.Users;
import org.example.testassignment.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

  private final UsersRepository usersRepository;

  // 생성
  @Transactional
  public ResponseEntity<String> createUsers(UsersDto dto) {
    Users users = new Users(dto.getUserName(), dto.getEmail(), dto.getPhone());

    if (dto.getEmail().contains("@")) {
      return new ResponseEntity<>("이메일 형식을 확인하세요.", HttpStatus.BAD_REQUEST);
    }
    usersRepository.save(users);

    return new ResponseEntity<>("완료", HttpStatus.OK);
  }

  // 조회
  @Transactional
  public ResponseEntity<List<Users>> searchUsers() {
    return new ResponseEntity<>(usersRepository.findAll(), HttpStatus.OK);
  }

  // 수정
  @Transactional
  public ResponseEntity<String> updateUsers(Long id, UsersDto dto) {
    Users users = usersRepository.findUsersById(id).get();

    users.setUserName(dto.getUserName());
    users.setEmail(dto.getEmail());
    users.setPhone(dto.getPhone());

    usersRepository.save(users);

    return new ResponseEntity<>("수정", HttpStatus.OK);
  }

  // 삭제
  @Transactional
  public ResponseEntity<String> deleteUsers(Long id) {
    usersRepository.deleteById(id);
    return new ResponseEntity<>("삭제", HttpStatus.OK);
  }
}
