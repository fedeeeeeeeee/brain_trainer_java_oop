package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.User;
import model.UserPlayerImpl;

public class UserTest {

    @Test
    public void testUser() {
    	
    	final User player = new UserPlayerImpl();
    	player.setUsername("user");
        player.setPassword("pass");
        assertEquals("user", player.getUsername());
        assertEquals("pass", player.getPassword());
    }
}
