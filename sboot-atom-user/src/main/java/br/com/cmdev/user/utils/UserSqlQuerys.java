package br.com.cmdev.user.utils;

public class UserSqlQuerys {

    public static final String INSERT_INTO_TB_USERS = "INSERT INTO tb_users(name, email, password, role, is_active, creation_date, change_date) VALUES(:name, :email, :password, :role, :isActive, :creationDate, :changeDate)";
    public static final String SELECT_ALL_USERS = "SELECT * FROM tb_users";

}
