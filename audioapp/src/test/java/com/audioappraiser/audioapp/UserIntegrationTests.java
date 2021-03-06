package com.audioappraiser.audioapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.audioappraiser.audioapp.model.secondary.User;
import com.audioappraiser.audioapp.modelrepos.secondary.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserIntegrationTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByUsername_thenReturnUser(){
        //given
        User user = new User();
        user.setUsername("user one");
        User user2 = new User();
        user2.setUsername("user two");
        entityManager.persist(user);
        entityManager.persist(user2);
        entityManager.flush();


        //when
        Optional<User> found = userRepository.findByUsername(user.getUsername());

        //then
        assertThat(found.get())
                .isEqualTo(user);
    }

    @Test
    public void whenExistsByUsername_thenReturnTrue(){
        //given
        User user = new User();
        user.setUsername("user one");
        entityManager.persist(user);
        entityManager.flush();


        //when
        Boolean bool = userRepository.existsByUsername(user.getUsername());

        //then
        assertThat(bool)
                .isEqualTo(Boolean.TRUE);
    }

    @Test
    public void whenExistsByUsername_thenReturnFalse(){
        //given
        User user = new User();
        user.setUsername("user one");
        entityManager.persist(user);
        entityManager.flush();


        //when
        Boolean bool = userRepository.existsByUsername("wrong");

        //then
        assertThat(bool)
                .isEqualTo(Boolean.FALSE);
    }

    @Test
    public void whenFindByUsernameAndPassword_thenReturnUser(){
        //given
        User user = new User();
        user.setUsername("user one");
        user.setPassword("1234");
        User user2 = new User();
        user2.setUsername("user two");
        user2.setPassword("password");
        entityManager.persist(user);
        entityManager.persist(user2);
        entityManager.flush();


        //when
        Optional<User> found = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        //then
        assertThat(found.get())
                .isEqualTo(user);
    }

    @Test
    public void whenFindByUsernameAndPassword_thenException() throws Exception{
        //given
        User user = new User();
        user.setUsername("user one");
        User user2 = new User();
        user2.setUsername("user two");
        user2.setPassword("password");
        entityManager.persist(user);
        entityManager.persist(user2);
        entityManager.flush();


        //when
        Optional<User> found = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        //then
        assertThat(found.get())
                .isEqualTo(user);
    }
}
