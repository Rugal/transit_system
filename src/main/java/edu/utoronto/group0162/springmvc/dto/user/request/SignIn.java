package edu.utoronto.group0162.springmvc.dto.user.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 *
 * @author Rugal Bernstein
 */
@Data
public class SignIn {

  @NotNull
  private String email;

  @NotNull
  private String password;
}
