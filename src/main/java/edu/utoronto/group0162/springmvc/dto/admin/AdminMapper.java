package edu.utoronto.group0162.springmvc.dto.admin;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

  AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);
}
