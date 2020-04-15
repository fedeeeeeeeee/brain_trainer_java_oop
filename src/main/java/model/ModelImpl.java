package model;

public class ModelImpl implements Model {
	
	private UserPlayer player;

	private String selectedArea;
	
	@Override
	public void setUserPlayer(UserPlayer player) {
		this.player = player;
		System.out.println("ciao sono il model e ho l'utente "+this.player.getUsername()+" E SARA è CONTENTA :))");
	}

	@Override
	public void setArea(String area) {
		this.selectedArea = area;
	}

	@Override
	public String getArea() {
		return this.selectedArea;
	}

	
}
