package br.com.example.springoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OauthGoogleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthGoogleApplication.class, args);
    }

}

@RestController
class ResourceController {
    @GetMapping("/public")
    String publicRoute() {
        return "<h1>Public route! Feel free to look around! 😊</h1>";
    }

    @GetMapping("/cookie")
    String privateRouteCookie(@AuthenticationPrincipal OidcUser principal) {
        return """
                 <h1>Private 🍪 route! Only authoried access! 🏬</h1>
                 <h3>Principal: %s</h3>
                 <h3>E-mail: %s</h3>
                 <h3>Authorities: %s</h3>
                 <h3>JWT: %s</h3>
                """
                .formatted(principal,
                        principal.getAttribute("email"),
                        principal.getAttributes(),
                        principal.getIdToken().getTokenValue()
                );
    }

    @GetMapping("/jwt")
    String privateRouteJwt(@AuthenticationPrincipal Jwt principal) {
        return """
                <h1>JWT</h1>
                <h3>When we make our application to know if a JWT is valid or not,
                    we transform our application in a Resource Server </h3>
                    <h3>Principal: %s</h3>
                    <h3>Email: %s </h3>
                    <h3> JWT: %s </h3>
                """.formatted(
                principal.getClaims(),
                principal.getClaim("email"),
                principal.getTokenValue()
        );
    }
}
