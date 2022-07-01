package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl dao = new UserDaoJDBCImpl();

        dao.dropUsersTable();
        dao.createUsersTable();

        dao.saveUser("1", "1", (byte) 1);
        dao.saveUser("2", "2", (byte) 2);
        dao.saveUser("3", "3", (byte) 3);
        dao.saveUser("4", "4", (byte) 4);

        dao.getAllUsers().forEach(System.out::println);
        dao.removeUserById(2);
        dao.getAllUsers().forEach(System.out::println);

        dao.cleanUsersTable();
        dao.dropUsersTable();

    }
}
