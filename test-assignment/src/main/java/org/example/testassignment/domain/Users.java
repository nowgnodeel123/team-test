package org.example.testassignment.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userName;

  private String email;

  private String phone;

  public Users(String userName, String email, String phone) {
    this.userName = userName;
    this.email = email;
    this.phone = phone;
  }
}
