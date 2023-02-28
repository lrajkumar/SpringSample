package com.sample.repository;

import com.sample.entity.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByRole() {

        List<User> users = userRepository.findByRole();

        MatcherAssert.assertThat("user count", users.size(), Matchers.is(1));
    }
    @Test
    void findByRoleUsingCriteriaQuery() {
        List<User> users = userRepository.findByRoleUsingCriteriaQuery("Admin");

        MatcherAssert.assertThat("user count", users.size(), Matchers.is(1));
    }
}
