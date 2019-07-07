package ru.nikita.chat.springChat.service;

/*
 *    Nikita make this 07.07.2019
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.nikita.chat.springChat.repositorys.UserRepo;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private  UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
}
