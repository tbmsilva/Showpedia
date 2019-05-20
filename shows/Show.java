/**
 * 
 */
package shows;

import java.util.List;

import characters.*;
import episodes.Episode;
import exceptions.*;

/**
 * @author tbmsilva & m.lami
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

	/**
	 * @param parentName
	 * @param kidName
	 * @return
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	int addParent(String parentName, String kidName)
			throws UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * @param kidName
	 * @param parentName
	 * @return
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	int addKid(String kidName, String parentName)
			throws UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException;

	void addRomance(String character1, String character2)
			throws UnknownCharacterException, SameCharacterRomanceException, RepeatedRelationshipException;

	void addEvent(String description, int season, int episode, int totalCharacters, List<String> characters)
			throws UnknownCharacterException, DuplicateCharacterException;
}
