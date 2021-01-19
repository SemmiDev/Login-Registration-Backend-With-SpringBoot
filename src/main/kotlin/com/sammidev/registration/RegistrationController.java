package com.sammidev.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("api/v1/registration")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping("api/v1/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping("failed")
    public String redirect() {
        return "FAILED";
    }

    @GetMapping("home")
    public Map<String, String> hello() {
        var sam = new HashMap<String,String>();
        sam.put("firstName","Sammi");
        sam.put("lastName","Dev");
        sam.put("email","sammidev@gmail.com");
        sam.put("phone","082387325971");
        return sam;
    }
}