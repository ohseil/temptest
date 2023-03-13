package project.CItestProject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/func")
@RestController
public class TestController {

    //@Value("${kakao.api.key}")
    //private String a;
    @Value("${github.api.client-id}")
    private String githubClientId;
    @Value("${github.api.client-secrets}")
    private String githubClientSecrets;
    @Value("${jwt.access-token.secret-key}")
    private String accessTokenKey;
    @Value("${jwt.refresh-token.secret-key}")
    private String refreshTokenKey;
    @Value("${jwt.access-token.valid-time}")
    private Long accessTokenValidTime;
    @Value("${jwt.refresh-token.valid-time}")
    private Long refreshTokenValidTime;

    @GetMapping
    public ResponseEntity<String> getFunc() {
        String c = githubClientId;
        String d = githubClientSecrets;
        String e = accessTokenKey;
        Long f = accessTokenValidTime;
        String g = refreshTokenKey;
        Long h = refreshTokenValidTime;
        return ResponseEntity.ok("hello");
    }

}
