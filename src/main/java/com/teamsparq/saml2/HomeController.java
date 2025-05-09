package com.teamsparq.saml2;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "Public page";
  }

  @GetMapping("/secure")
  public String secure(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
    System.out.println("HOLA");
    return "Hello, " + principal.getName();
  }
}