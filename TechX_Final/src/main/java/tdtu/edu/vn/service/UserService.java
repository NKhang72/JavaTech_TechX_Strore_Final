package tdtu.edu.vn.service;



import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import tdtu.edu.vn.entity.User;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
	
	List<User> getAllUsers();
	
	User getUserById(Long id);
	
	void deleteUser(Long id);
}
