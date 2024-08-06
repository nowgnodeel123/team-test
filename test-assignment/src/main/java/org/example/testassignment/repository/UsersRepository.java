package org.example.testassignment.repository;

import org.example.testassignment.domain.Board;
import org.example.testassignment.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
  Optional<Users> findUsersById(Long id);
}