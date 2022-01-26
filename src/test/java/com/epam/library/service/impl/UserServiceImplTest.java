package com.epam.library.service.impl;

import com.epam.library.entity.User;
import com.epam.library.entity.UserStatus;
import com.epam.library.service.ServiceException;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = ServiceFactory.getInstance().getUserService();
    }

    @Test
    void verification() {
        try {
            String email = "email";
            String password = "password";
            Optional<User> optionalUser = userService.verification(email, password);
            assertTrue(optionalUser.isPresent());
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void createRightTest() {
        try {
            String email = "email@gamil.com";
            String password = "Password1";
            String secondName = "secondName";
            String lastName = "lastName";

            boolean condition = userService.create(email, password, secondName, lastName);
            assertTrue(condition);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void createWrongEmailTest() {
        try {
            String email = "email@gamil";
            String password = "Password1";
            String secondName = "secondName";
            String lastName = "lastName";
            boolean condition = userService.create(email, password, secondName, lastName);
            assertFalse(condition);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void createWrongPasswordTest() {
        try {
            String email = "email@gamil.com";
            String password = "password";
            String secondName = "secondName";
            String lastName = "lastName";
            boolean condition = userService.create(email, password, secondName, lastName);
            assertFalse(condition);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }


    @Test
    void getUsers() {
        try {
            List<User> users = userService.getUsers();
            output(users);
            assertFalse(users.isEmpty());
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getCountUsers() {
        try {
            long count = userService.showCountByStatus(UserStatus.BLOCKED.name());
            System.out.println(count);
            assertTrue(count > 0);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void showUserByStatusRightTest() {
        try {
            String status = "active";
            List<User> users = userService.showUserByStatus(status);
            output(users);
            assertFalse(users.isEmpty());
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void showUserByStatusWrongTest() {
            ServiceException exception = assertThrows(ServiceException.class, () -> {
                String status = "active1";
                userService.showUserByStatus(status);
            });

            String expectedMessage = "Unknown user status.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void showUserByRole() {
        try {
            String role = "admin";
            List<User> users = userService.showUserByRole(role);
            output(users);
            assertFalse(users.isEmpty());
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void showUserByEmailRightTest() {
        try {
            String email = "admin@gmail.com";
            List<User> users = userService.showUserByEmail(email);
            output(users);
            assertFalse(users.isEmpty());
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void showUserByEmailWrongTest() {
            ServiceException exception = assertThrows(ServiceException.class, () -> {
                String email = "Beginning in the eighth century B.C., Ancient Rome grew from a small town on central " +
                        "Italy’s Tiber River into an empire that at its peak encompassed most of continental Europe, " +
                        "Britain, much of western Asia, northern Africa and the Mediterranean islands. Among the many " +
                        "legacies of Roman dominance are the widespread use of the Romance languages (Italian, French, " +
                        "Spanish, Portuguese and Romanian) derived from Latin, the modern Western alphabet and calendar " +
                        "and the emergence of Christianity as a major world religion. ";
                userService.showUserByEmail(email);
            });

            String expectedMessage = "Too long value.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void showUserById() {
        try {
            String userId = "1";
            Optional<User> optionalUser = userService.showUserById(userId);
            assertTrue(optionalUser.isPresent());
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateRightTest() {
        try {
            String userId = "1";
            String email = "update@gmail.com";
            String secondName = "";
            String lastName = "update";

            boolean condition =  userService.update(email, secondName, lastName, userId);
            assertTrue(condition);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateWrongTest() {
        try {
            String userId = "1";
            String email = "update@gmail";
            String secondName = "";
            String lastName = "update";

            boolean condition =  userService.update(email, secondName, lastName, userId);
            assertFalse(condition);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }


    @Test
    void updateStatus() {
        try {
            String status = "delete";
            String userId = "1";
            boolean condition = userService.updateStatus(userId, status);
            assertTrue(condition);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateRole() {
        try {
            String role = "manager";
            String userId = "1";
            boolean condition = userService.updateRole(userId, role);
            assertTrue(condition);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updatePasswordRightTest() {
        try {
            String password = "test@gmail.com";
            String email = "1";
            String oldPassword = "1";
            boolean condition = userService.updatePassword(password, email, oldPassword);
            assertTrue(condition);
        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }



    private void output(List<User> list) {
        for (User user : list) {
            System.out.println(user);
        }
    }
}