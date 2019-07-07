package ru.nikita.chat.springChat.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nikita.chat.springChat.entitys.User;

/*
 *    Nikita make this 07.07.2019
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
