package org.example.testassignment.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.testassignment.common.BoardDto;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private String author;

  public Board(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
}
