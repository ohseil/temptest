package project.CItestProject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/func")
@RestController
public class TestController {

    @Value("${kakao.api.key}")
    private String a;

    @GetMapping
    public ResponseEntity<String> getFunc() {
        String b = "Asdf";
        return ResponseEntity.ok(a);
    }

}
