package com.CargoManger.Goods;

import com.CargoManger.Goods.Entity.Role;
import com.CargoManger.Goods.Entity.User;
import com.CargoManger.Goods.Repository.UserRepository;
import com.CargoManger.Goods.Service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GoodsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Test
	public void testRegiterUserSuccess(){
		User user= new User();
		user.setName("akshay");
		user.setEmail("test@example.com");
		user.setPassword("password");

		Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
		Mockito.when(userRepository.save(user)).thenReturn(user);

		User registerdUser =userService.registerUser(user);
		assertEquals("test@example.com", registerdUser.getEmail());
	}


	@Test
	public void testUpdatedUserRole(){
		User user1 = new User();
		user1.setId(1L);
		user1.setName("ashish");
		user1.setRole(Role.CUSTOMER);

		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
		Mockito.when(userRepository.save(user1)).thenReturn(user1);

		User updatedUser1=userService.updateUserRole(1L, Role.ADMIN);
		assertEquals(Role.ADMIN, updatedUser1.getRole());

	}
}


