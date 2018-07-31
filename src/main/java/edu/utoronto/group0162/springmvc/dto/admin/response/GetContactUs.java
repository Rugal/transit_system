package edu.utoronto.group0162.springmvc.dto.admin.response;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 *
 * @author Rugal Bernstein
 */
@Data
public class GetContactUs {

  @NotNull
  private Integer cuid;

  private String name;

  private String phone;

  @NotNull
  private String email;

  @NotNull
  private String message;
}
