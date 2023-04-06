package tdtu.edu.vn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import tdtu.edu.vn.entity.User;
import tdtu.edu.vn.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setPassword("123456789");
		user.setFirstName("admin");
		user.setLastName("a");
		
		User saveUser = userRepository.save(user);
		User existUser = entityManager.find(User.class, saveUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
}
