package dragonspiretournament.armyselection;

import java.util.ArrayList;
import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.Dragons.Dragon;

public class ArmySelectionController {

	public static void initCurrentAndPrev( ArmySelectionModel selectModel ) {
		ArrayList<Dragon> allDragons = selectModel.getAllLibraryDragons();
		if ( selectModel.getCurrent() == null ) {
			selectModel.setCurrent( allDragons.get(1) );
			selectModel.setPrev( allDragons.get(0) );
			selectModel.setNext( allDragons.get(2) );
		}
	}
	
	public static void removeFromArmy( Army selection, Dragon dragon ) {
		ArrayList<Dragon> armyList = selection.getArmy();
		armyList.remove( dragon );
	}
	
	public static void addToArmy( ArmySelectionModel selectModel, Dragon dragon ) {
		selectModel.getCurrentPlayerArmy().add(dragon);
	}
	
	public static void shiftPreviewLeft( ArmySelectionModel selectModel ) {
		ArrayList<Dragon> allDragons = selectModel.getAllLibraryDragons();
		int totalDragons = allDragons.size();
		int currIndex = allDragons.indexOf( selectModel.getCurrent() );
		int updatedCurrIndex;
		int updatedNextIndex;
		int updatedPrevIndex;
		
		updatedPrevIndex = currIndex;
		
		if ( currIndex == totalDragons - 2 ) {
			updatedNextIndex = 0;
			updatedCurrIndex = currIndex + 1;
			updatedPrevIndex = currIndex;
		} else if ( currIndex == totalDragons - 1 ) {
			updatedCurrIndex = 0;
			updatedNextIndex = updatedCurrIndex + 1;
			updatedPrevIndex = currIndex;
		} else { 
			updatedPrevIndex = currIndex;
			updatedCurrIndex = currIndex + 1;
			updatedNextIndex = currIndex + 2;
		}
		
		
		
		selectModel.setCurrent( allDragons.get( updatedCurrIndex ));
		selectModel.setPrev( allDragons.get( updatedPrevIndex ));
		selectModel.setNext( allDragons.get( updatedNextIndex ));
	}
	
	public static void shiftPreviewRight( ArmySelectionModel selectModel ) {
		ArrayList<Dragon> allDragons = selectModel.getAllLibraryDragons();
		int totalDragons = allDragons.size();
		int currIndex = allDragons.indexOf( selectModel.getCurrent() );
		int updatedCurrIndex;
		int updatedNextIndex;
		int updatedPrevIndex;
		
		if ( currIndex == totalDragons - 2 ) {
			updatedCurrIndex = currIndex + 1;
			updatedNextIndex = 0;
			updatedPrevIndex = currIndex;
		} else if ( currIndex == totalDragons - 1 ) {
			updatedCurrIndex = 0;
			updatedNextIndex = updatedCurrIndex + 1;
			updatedPrevIndex = currIndex;
		} else {
			updatedCurrIndex = currIndex + 1;
			updatedNextIndex = currIndex + 2;
			updatedPrevIndex = currIndex;
		}
		
		selectModel.setCurrent( allDragons.get( updatedCurrIndex ));
		selectModel.setPrev( allDragons.get( updatedPrevIndex ));
		selectModel.setNext( allDragons.get( updatedNextIndex ));
		
	}
}
