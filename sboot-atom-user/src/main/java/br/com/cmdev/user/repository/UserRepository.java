package br.com.cmdev.user.repository;

import br.com.cmdev.user.domain.User;
import br.com.cmdev.user.utils.UserSqlQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcClient jdbcClient;

    public void save(User user) {
        jdbcClient.sql(UserSqlQuerys.INSERT_INTO_TB_USERS)
                .param("name", user.getName())
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .param("role", user.getRole().name())
                .param("isActive", user.getIsActive())
                .param("creationDate", user.getCreationDate())
                .param("changeDate", user.getChangeDate())
                .update();
    }

    public List<User> getAllUsers() {
        return jdbcClient.sql(UserSqlQuerys.SELECT_ALL_USERS)
                .query(User.class)
                .list();
    }

}