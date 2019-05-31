/**
 * 
 */
package characters;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface CGI extends ShowCharacter {

	/**
	 * Returns the cost per season of the character.
	 * 
	 * @return the cost per season of the character.
	 */
	int getCostPerSeason();

	/**
	 * Adds a participation in the given season. Used for counting how many seasons
	 * this character has been active on.
	 * 
	 * @param season - season to add the participation to.
	 */
	void addParticipation(int season);

	/**
	 * Returns the number of seasons the character has actively participated on.
	 * 
	 * @return the number of seasons the character has actively participated on.
	 */
	int numberOfParticipatingSeasons();
}
