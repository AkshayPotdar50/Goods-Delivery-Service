package com.CargoManger.Goods;

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
}


