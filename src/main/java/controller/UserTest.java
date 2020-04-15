package controller;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;

import model.User;
import model.UserPlayerImpl;

public class UserTest {
	
	private User player;
	
//	@Test
	public void testUser() {
		this.player = new UserPlayerImpl();
		this.player.setUsername("user");
		this.player.setPassword("pass");
//		assertEquals("user", this.player.getUsername());
//		assertEquals("pass", this.player.getPassword());
	}
}
