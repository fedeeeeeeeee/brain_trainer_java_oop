package model;

public class PlayerImpl implements Player {

	private final String playerName;
	private final String password;
	
	public PlayerImpl(String name, String password){
		this.playerName =name ;
		this.password=password;
	}
	
	@Override
	public String getPlayer() {
		return this.playerName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}
	
}
