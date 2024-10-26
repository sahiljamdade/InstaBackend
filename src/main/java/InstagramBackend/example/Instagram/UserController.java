package InstagramBackend.example.Instagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String message = userService.registerUser(user);
        return ResponseEntity.ok(message);
    }
    
   
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        String message = userService.loginUser(email, password);
        return ResponseEntity.ok(message); 
    }

   
    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestParam String email, @RequestParam String newPassword) {
        String message = userService.updatePassword(email, newPassword);
        return ResponseEntity.ok(message);
    }

   
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam String email) {
        String message = userService.deleteUser(email);
        return ResponseEntity.ok(message);
    }
}
