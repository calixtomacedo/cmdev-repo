package br.com.cmdev.user.mapper;

import br.com.cmdev.user.domain.User;
import br.com.cmdev.user.domain.dto.UserRequest;
import br.com.cmdev.user.domain.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    public final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

    @Mapping(target = "idUser", ignore = true)
    @Mapping(target = "isActive", expression = "java(Boolean.TRUE)")
    @Mapping(target = "creationDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "changeDate", ignore = true)
    User userRequestToUserMap(UserRequest request);

    @Mapping(target = "creationDate", source = "creationDate", dateFormat = DATE_FORMAT)
    @Mapping(target = "changeDate", source = "changeDate", dateFormat = DATE_FORMAT)
    UserResponse userToUserResponseMap(User user);

    @Mapping(target = "creationDate", source = "creationDate", dateFormat = DATE_FORMAT)
    @Mapping(target = "changeDate", source = "changeDate", dateFormat = DATE_FORMAT)
    List<UserResponse> userListToUserResponseListMap(List<User> users);
}
