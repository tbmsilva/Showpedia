package company;

import characters.CGI;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface CGICompany {	

	/**
	 * Returns the name of the company
	 * @return the name of the company
	 */
	String getName();

	/**
	 * @param character
	 */
	void addCharacter(CGI character);
}
