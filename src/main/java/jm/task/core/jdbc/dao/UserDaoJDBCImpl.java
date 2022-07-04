package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("CREATE TABLE `mydbtest`.`users` (`id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(45) NULL, `lastName` VARCHAR(45) NULL, `age` INT NULL, PRIMARY KEY (`id`));")) {
            preparedStatement.executeUpdate();

        } catch (SQLSyntaxErrorException ignored) {
        } catch (SQLException e) {
            System.out.println("проблема с созданием таблицы");
        }

    }

    public void dropUsersTable() {
        try (PreparedStatement preparedStatement = Util.getConnection()
                .prepareStatement("drop table users")) {

            preparedStatement.executeUpdate();

        } catch (SQLSyntaxErrorException ignored) {
        } catch (SQLException e) {
            System.out.println("проблема с удалением таблици");
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement
                ("INSERT INTO mydbtest.users (name, lastName, age)VALUES ( ?, ?, ?)")){

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();

            System.out.println("User - " + name + " добавлен");

        } catch (SQLException e) {
            System.out.println("проблемя с добавлением пользователя");
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("delete from users where id = ?")) {
            preparedStatement.setInt(1, (int) id);
            preparedStatement.executeUpdate();
        } catch (SQLSyntaxErrorException ignore){
        } catch (SQLException e) {
            System.out.println("проблема с удалением пользователя");
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try (Statement statement = Util.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                User user = new User();
                user.setId((long) resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                list.add(user);
            }

        } catch (SQLSyntaxErrorException ignore){
        } catch (SQLException e) {
            System.out.println("проблемя с показом всех пользователей");
        }
        return list;
    }

    public void cleanUsersTable() {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("TRUNCATE TABLE users;")) {

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("проблемя с отчисткой");
        }
    }
}
