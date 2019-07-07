package ru.nikita.chat.springChat.controllers;

/*
 *    Nikita make this 07.07.2019
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nikita.chat.springChat.entitys.Messages;
import ru.nikita.chat.springChat.entitys.User;
import ru.nikita.chat.springChat.repositorys.MessagesRepos;

import java.util.List;
import java.util.Map;

@Controller
public class MainPageController {
    @Autowired
    private MessagesRepos messagesRepos;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/mainPage")
    public String mainPage(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Messages> messages = messagesRepos.findAll();

        if(filter != null && !filter.isEmpty())
            messages = messagesRepos.findByTag(filter);
        else
            messages = messagesRepos.findAll();

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "mainPage";
    }

    @PostMapping("/mainPage")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String text,
                      @RequestParam String tag, Map<String, Object> model)
    {

        Messages message = new Messages(text, tag, user);

        messagesRepos.save(message);

        Iterable<Messages> messages= messagesRepos.findAll();
        model.put("messages", messages);

        return "mainPage";
    }




}
