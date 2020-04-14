package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class LoginModel {
	
	private static final String PATH = System.getProperty("user.home") + File.separator + ".provaprogetto";
	private static final File brainTrainer = new File(PATH);
	private File userFile;
	
	
	private boolean checkIfUserExist(UserPlayer player, String userFileName) {		
		 for(File file : brainTrainer.listFiles()) {
			 if(userFileName.equals(file.getName())) {
				 this.userFile = file;
				 return true;
			 }
			 System.out.println(file);
		 }
		 return false;
	}
	
	private boolean checkPassword (UserPlayer player) {
		
		ObjectMapper mapper = new ObjectMapper();
		 
		try {
			if(mapper.readValue(userFile,UserPlayer.class ).getPassword().equals(player.getPassword())) {
				 return true;
			 }
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	private void initializeDirectory() {
        if (!brainTrainer.exists()) {
            try {
                brainTrainer.mkdir();
            } catch (SecurityException se) {
                System.out.println("Error. While create directory");
            }
        }
	}
	
	/**
	 * Find the User
	 * @param player
	 * @return 
	 * 			false if the user isn't already register true otherwise
	 */
	public boolean logInUser(UserPlayer player) {
		 String userFileName = player.getUsername()+ ".txt";
		 
		 if(this.checkIfUserExist(player, userFileName)) {
			 return this.checkPassword(player);
		 }
		 return false;
	}
	
	
	/**
	 * Register the newUser
	 * @param player
	 */
	public boolean registerPlayer(UserPlayer player) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		this.initializeDirectory();
		
        String userFileName = player.getUsername()+ ".txt";
		
        if(this.checkIfUserExist(player, userFileName)) {
        	return false;
        }else {
        	this.userFile = new File(PATH + File.separator + userFileName);
        	try {
				mapper.writeValue(userFile, player);
			} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
        	return true;
        }		
	}

}
