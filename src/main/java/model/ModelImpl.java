package model;

public class ModelImpl implements Model {
	
	private UserPlayer player;

	@Override
	public void setUserPlayer(UserPlayer player) {
		this.player = player;
		System.out.println("ciao sono il model e ho l'utente "+this.player.getUsername()+" E SARA è CONTENTA :))");
	}

}
