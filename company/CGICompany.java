package company;

import characters.CGI;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface CGICompany {

	/**
	 * Returns the name of the company
	 * 
	 * @return the name of the company
	 */
	String getName();

	/**
	 * Adds a CGI character to the list of the character made by the company.
	 * 
	 * @param character - character to be added to the company.
	 * @pre <code>character != null </code>
	 */
	void addCharacter(CGI character);
}
