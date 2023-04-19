package tdtu.edu.vn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import tdtu.edu.vn.entity.User;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.service.impl.UserServiceImpl;

@Controller
public class UserLoginController {

	@Autowired
	public UserRepository userRepository;

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("firstName");
        return "redirect:/login";
    }
}
