package ru.stc20.molostvov.lesson15;

import ru.stc20.molostvov.lesson15.dao.CreateTableDao;
import ru.stc20.molostvov.lesson15.daoImpl.CreateTableDaoImpl;
import ru.stc20.molostvov.lesson15.daoImpl.UserDaoImpl;
import ru.stc20.molostvov.lesson15.entity.User;

public class Main {
    public static void main(String[] args) {
        CreateTableDao createTableDao = new CreateTableDaoImpl();
        createTableDao.createTable();
        User user = new User("Вася", "20.06.1866", "Москва",
                "Vasya@mail.ru", "Василий");
        User user2 = new User("Григорий", "20.06.2866", "Москва",
                "Grisha@mail.ru", "");
        User user3 = new User("Настя", "20.06.1966", "Москва",
                "Nastya@mail.ru", "");
        User user4 = new User("Вася", "20.06.1966", "Москва",
                "VasyaDrugoy@mail.ru", "Тоже Вася");
        User[] users = new User[3];
        users[0] = user2;
        users[1] = user3;
        users[2] = user4;
        UserDaoImpl userDaoImpl = new UserDaoImpl();

        userDaoImpl.addUsers(users);
        //userDaoImpl.addNewUser(user);
        User user5 = userDaoImpl.getUser(9,"Вася");
        System.out.println(user5);



    }
}
