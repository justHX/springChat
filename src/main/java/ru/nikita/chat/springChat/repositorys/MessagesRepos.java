package ru.nikita.chat.springChat.repositorys;

import org.springframework.data.repository.CrudRepository;
import ru.nikita.chat.springChat.entitys.Messages;

import java.util.List;

/*
 *    Nikita make this 07.07.2019
 */
public interface MessagesRepos extends CrudRepository<Messages, Long> {

    List<Messages> findByTag(String tag);

}
