package org.example.testassignment.common;

import lombok.*;
import org.example.testassignment.domain.Board;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
  String title;
  String content;
  String author;

  public BoardDto(Board board) {
    this.title = board.getTitle();
    this.content = board.getContent();
    this.author = board.getAuthor();
  }
}
