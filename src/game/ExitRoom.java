package game;

public class ExitRoom extends Room {

	public ExitRoom(String description) {
		super(description);
	}
	
	public boolean isExit() {
		return true;
	}
}
