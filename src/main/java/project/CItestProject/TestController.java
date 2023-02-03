package project.CItestProject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/func")
@RestController
public class TestController {

    @GetMapping
    public ResponseEntity getFunc() {
        return ResponseEntity.ok("hello");
    }

}
