/**
 * 
 */
package shows;

import characters.CGI;
import characters.Real;
import episodes.Episode;
import exceptions.DuplicateCharacterException;
import exceptions.InvalidActorFeeException;

/**
 * @author tbmsilva
 *
 */
public interface Show {

	/**
	 * Returns the show name
	 * 
	 * @return the show name
	 */
	String getName();

	/**
	 * Returns the number of seasons of the show
	 * 
	 * @return the number of seasons of the show
	 */
	int getSeasonCount();

	/**
	 * Returns the number of episodes of the show
	 * 
	 * @return the number of seasons of the show
	 */
	int getEpisodeCount();

	/**
	 * Returns the number of episodes in a season
	 * 
	 * @param season - season to get episode count
	 * @return number of episodes in given season
	 */
	int getSeasonEpisodeCount(int season);

	/**
	 * Adds a new season to the show. The new season is added with a new serial
	 * number (the successor of the last season).
	 */
	void addSeason();

	/**
	 * Adds an episode to a season
	 * 
	 * @param e      - episode to be added
	 * @param season - season to add the episode to
	 */
	void addEpisode(Episode e, int season);

	/**
	 * @param characterName
	 * @param actorName
	 * @param cost
	 * @throws DuplicateCharacterException
	 * @throws InvalidActorFeeException
	 */
	Real addRealCharacter(String characterName, String actorName, int cost)
			throws DuplicateCharacterException, InvalidActorFeeException;

	/**
	 * @param characterName
	 * @param companyName
	 * @param cost
	 * @throws DuplicateCharacterException
	 */
	CGI addCGICharacter(String characterName, String companyName, int cost) throws DuplicateCharacterException;
}
