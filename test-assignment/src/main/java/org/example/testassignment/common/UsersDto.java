package org.example.testassignment.common;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.testassignment.domain.Users}
 */
@Value
public class UsersDto implements Serializable {
  String userName;
  String email;
  String phone;
}