/**
 * 
 */
package wiki;

import exceptions.NoShowSelectedException;
import exceptions.ShowAlreadyExistsException;

/**
 * @author tbmsilva
 *
 */
public interface Wiki {

	/**
	 * Returns the season and episode count of selected show
	 * 
	 * @return the season and episode count of selected show
	 * @throws NoShowSelectedException
	 */
	String currentShowInfo() throws NoShowSelectedException;
	
	/**
	 * Creates and adds a show
	 * @param name - show's name
	 * @throws ShowAlreadyExistsException
	 */
	void addShow(String name) throws ShowAlreadyExistsException;
}
