package assign.Ca225project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class GreatController {
    @GetMapping
    public String Test(){
        return "Welcome to Home!";
    }
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok()
                .header("X-Custom-Header", "SuccessHeader")
                .body("Operation successful!");
    }
    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: Resource not found.");
    }
    @PostMapping("/create")
    public ResponseEntity<String> create() {
        URI location = URI.create("/resource/123");
        return ResponseEntity.created(location).body("Resource created!");
    }
}
