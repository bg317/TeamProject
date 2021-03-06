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
		
		updatedNextIndex = currIndex;
		
		if ( currIndex == 1 ) {
			updatedCurrIndex = 0;
			updatedPrevIndex = totalDragons - 1;
		} else if ( currIndex == 0 ) {
			updatedCurrIndex = totalDragons - 1;
			updatedPrevIndex = totalDragons - 2;
		} else { 
			updatedCurrIndex = currIndex - 1;
            updatedPrevIndex = currIndex - 2;
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

        updatedPrevIndex = currIndex;

		if ( currIndex == totalDragons - 2 ) {
			updatedCurrIndex = currIndex + 1;
			updatedNextIndex = 0;
		} else if ( currIndex == totalDragons - 1 ) {
			updatedCurrIndex = 0;
			updatedNextIndex = updatedCurrIndex + 1;
		} else {
			updatedCurrIndex = currIndex + 1;
			updatedNextIndex = currIndex + 2;
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
	
	/**
	 * Gets the path to the get next button.
	 * @return path to the get next button.
	 */
	public static String getNextButton() {
		return "Art/UIGraphics/NextButton.png";
	}
	
	/**
	 * Gets the path to the get previous button.
	 * @return path to the get previous button.
	 */
	public static String getPreviousButton() {
		return "Art/UIGraphics/PreviousButton.png";
	}
	
	/**
	 * Gets the path to the add dragon button.
	 * @return path to the add dragon button.
	 */
	public static String getAddDragonButton() {
		return "Art/UIGraphics/AddDragonButton.png";
	}
	
	/**
	 * Gets the path to the confirm selection button.
	 * @return path to the confirm selection button.
	 */
	public static String getConfirmSelectionButton() {
		return "Art/UIGraphics/ConfirmSelectionButton.png";
	}
}
