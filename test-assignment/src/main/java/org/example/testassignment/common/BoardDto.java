package org.example.testassignment.common;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
public class BoardDto implements Serializable {
  String title;
  String content;
  String author;
  LocalDateTime createTime;
}
