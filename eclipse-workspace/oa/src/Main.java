
public class Main{
	public static void main(String[] args) {
		GameWindow j = new GameWindow(); 
		FifteenGame game= new FifteenGame();
		j.getPanel().addPropertyChangeListener(new a());
		for(Cell c : game.getCells()) {
			j.add(c);
		}
		
	}
}
