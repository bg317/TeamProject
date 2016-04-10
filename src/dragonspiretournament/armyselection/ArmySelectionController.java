package dragonspiretournament.armyselection;

import java.util.ArrayList;

import dragonspiretournament.GameObjects.Dragons.Dragon;

public class ArmySelectionController {

	public static void initCurrentAndPrev( ArmySelectionModel selectModel ) {
		ArrayList<Dragon> allDragons = selectModel.getAllLibraryDragons();
		if ( selectModel.getCurrent() == null ) {
			selectModel.setCurrent( allDragons.get(1) );
			selectModel.setCurrent( allDragons.get(0) );
			selectModel.setCurrent( allDragons.get(2) );
		}
	}
	
	public static void removeFromArmy( Army selection, Dragon dragon ) {
		//ArrayList<Dragon> armyList = selection.getArmyList();
		//armyList.remove( dragon );
	}
}
