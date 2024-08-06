package org.example.testassignment.common;

import lombok.Builder;
import lombok.Value;
import org.example.testassignment.domain.Board;

import java.io.Serializable;

@Value
//@Builder
public class BoardDto implements Serializable {
  String title;
  String content;
  String author;

  public BoardDto(Board board) {
    this.title = board.getTitle();
    this.content = board.getContent();
    this.author = board.getAuthor();
  }
}
