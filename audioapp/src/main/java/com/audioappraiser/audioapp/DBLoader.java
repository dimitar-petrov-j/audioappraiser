package com.audioappraiser.audioapp;

import com.audioappraiser.audioapp.model.User;
import com.audioappraiser.audioapp.modelrepos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
abstract class DBLoader implements CommandLineRunner {

    private final UserRepository repository;

    @Autowired
    public DBLoader(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new User("jimmy", "Dimitar Petrov", false));
    }
}
