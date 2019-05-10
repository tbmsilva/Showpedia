/**
 * 
 */
package wiki;

import exceptions.NoShowSelectedException;

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
}
