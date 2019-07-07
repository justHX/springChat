package ru.nikita.chat.springChat.entitys;

import org.springframework.security.core.GrantedAuthority;

/*
 *    Nikita make this 07.07.2019
 */
public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
