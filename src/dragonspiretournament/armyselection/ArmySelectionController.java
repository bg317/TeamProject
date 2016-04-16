package dragonspiretournament.armyselection;

import java.util.ArrayList;
import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;

/**
 * The Class ArmySelectionController.
 */
public class ArmySelectionController {

	/**
	 * Inits the current and prev.
	 *
	 * @param selectModel the select model
	 */
	public static void initCurrentAndPrev( ArmySelectionModel selectModel ) {
		ArrayList<Dragon> allDragons = selectModel.getAllLibraryDragons();
		if ( selectModel.getCurrent() == null ) {
			selectModel.setCurrent( allDragons.get(1) );
			selectModel.setPrev( allDragons.get(0) );
			selectModel.setNext( allDragons.get(2) );
		}
	}
	
	/**
	 * Removes the from army.
	 *
	 * @param selection the selection
	 * @param dragon the dragon
	 */
	public static void removeFromArmy( Army selection, Dragon dragon ) {
		ArrayList<Dragon> armyList = selection.getArmy();
		armyList.remove( dragon );
	}
	
	/**
	 * Adds the to army.
	 *
	 * @param selectModel the select model
	 * @param dragon the dragon
	 */
	public static void addToArmy( ArmySelectionModel selectModel, Dragon dragon ) {
		selectModel.getCurrentPlayerArmy().add(dragon);
	}
	
	/**
	 * Shift preview left.
	 *
	 * @param selectModel the select model
	 */
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
	
	/**
	 * Shift preview right.
	 *
	 * @param selectModel the select model
	 */
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

	/**
	 * Confirm players army.
	 *
	 * @param selectModel the select model
	 */
	public static void confirmPlayersArmy( ArmySelectionModel selectModel ) {
		Player player = selectModel.getPlayer();
		player.setArmy( selectModel.getCurrentPlayerArmy() );
	}
}
