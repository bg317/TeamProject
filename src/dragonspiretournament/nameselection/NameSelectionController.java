package dragonspiretournament.nameselection;

public class NameSelectionController {
	
	static NameSelectionModel nameSelector = new NameSelectionModel();
	
	public static String getPlayer()
	{
		return nameSelector.getPlayer();
	}
	
	public static void setName(String name)
	{
		nameSelector.setPlayerName(name);
	}
	
	public static boolean goToNextFrame()
	{
		return nameSelector.getNext();
	}

}

