package com.pouya.securityproject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping
public class Home {
    private final String HOME_PAGE_VIEW_COUNT = "HOME_PAGE_VIEW_COUNT";

    @GetMapping("/home")
    public String test(Principal principal, HttpSession session) {
        sessionSpeicherCounter(session, HOME_PAGE_VIEW_COUNT);
        return "welcome in my Application" + principal.getName() + HOME_PAGE_VIEW_COUNT + session.getAttribute(HOME_PAGE_VIEW_COUNT);
    }

    private void sessionSpeicherCounter(HttpSession session, String homePageViewCount) {
        var count = session.getAttribute(homePageViewCount) == null ? 0 : (Integer) session.getAttribute(homePageViewCount);
        count+=1 ;
        session.setAttribute(homePageViewCount, count);
    }

}
