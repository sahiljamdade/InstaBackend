package InstagramBackend.example.Instagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        userRepository.save(user); 
        return "Thanks for Registeration";
    }
    
  

    public String loginUser(String email, String password) {
        User user = userRepository.findById(email).orElse(null);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return "Login to Instagram....";  
            } else {
                return "Invalid password...retry again"; 
            }
        }
        return "oops...User not found...";  
    }

    public String updatePassword(String email, String newPassword) {
        User user = userRepository.findById(email).orElse(null);
        if (user != null) {
            user.setPassword(newPassword);
            userRepository.save(user);  
            return "Password updated...Congrarulations"; 
        }
        return "Sorry Not found..."; 
    }

    public String deleteUser(String email) {
        if (userRepository.existsById(email)) {  
            userRepository.deleteById(email);   
            return "User account deleted permanently..."; 
        }
        return "account not found."; 
    }
}
