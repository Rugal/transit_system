package edu.utoronto.group0162.springmvc.dto.user;

import edu.utoronto.group0162.core.entity.User;
import edu.utoronto.group0162.springmvc.dto.user.request.SignIn;
import edu.utoronto.group0162.springmvc.dto.user.request.SignUp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User fromSignIn(SignIn signIn);

  User fromSignUp(SignUp signUp);
}
