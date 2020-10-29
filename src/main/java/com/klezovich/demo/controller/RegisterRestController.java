package com.klezovich.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterRestController {

    private final RegisterUseCase registerUseCase;

    @Autowired
    public RegisterRestController(RegisterUseCase registerUseCase) {this.registerUseCase = registerUseCase;}

    @PostMapping("/forums/{forumId}/register")
    UserResource register(
        @PathVariable("forumId") Long forumId,
        @Valid @RequestBody UserResource userResource,
        @RequestParam("sendWelcomeEmail") boolean sendWelcomeEmail) {

        User user = new User(userResource.getName(), userResource.getEmail());
        Long userId = registerUseCase.registerUser(user, sendWelcomeEmail);

        return new UserResource(userId, user.getName(), user.getEmail() );
    }


}
