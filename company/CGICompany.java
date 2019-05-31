package company;

import java.util.Iterator;

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

	/**
	 * Returns all the CGI characters made by the company.
	 * 
	 * @return all the CGI characters made by the company.
	 */
	Iterator<CGI> getCharacters();

	/**
	 * Sets the company's profit to the given one.
	 * 
	 * @param profit - new profit.
	 */
	void setProfit(int profit);

	/**
	 * Returns the company's profit.
	 * 
	 * @return the company's profit.
	 */
	int profit();
}
