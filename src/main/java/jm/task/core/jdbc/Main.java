package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Поход", "Гераклов", (byte) 30);
        userService.saveUser("Назад", "Ненадов", (byte) 7);
        userService.saveUser("Отряд", "Ковбоев", (byte) 33);
        userService.saveUser("Запой", "Гусаров", (byte) 45);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}