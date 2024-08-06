package org.example.testassignment.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.testassignment.global.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Users extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userName;

  private String email;

  private String phone;

  @ToString.Exclude
  @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
  private List<Board> boardList = new ArrayList<>();

  public Users(String userName, String email, String phone) {
    this.userName = userName;
    this.email = email;
    this.phone = phone;
  }
}
