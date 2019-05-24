/**
 * 
 */
package shows;

import java.util.*;

import characters.*;
import episodes.*;
import event.Event;
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
	 * Returns a list of episodes belonging to the given season.
	 * 
	 * @param season
	 * @return
	 */
	List<Episode> getSeason(int season);

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

	Episode getEpisode(int season, int episode);
	
	/**
	 * @param character
	 * @throws DuplicateCharacterException
	 * @throws InvalidActorFeeException
	 */
	void addRealCharacter(Real character) throws DuplicateCharacterException, InvalidActorFeeException;

	/**
	 * @param character
	 * @throws DuplicateCharacterException
	 */
	void addCGICharacter(CGI character) throws DuplicateCharacterException;
	
	/**
	 * @param name
	 * @return
	 */
	ShowCharacter getCharacter(String name);

	/**
	 * @param parentName
	 * @param kidName
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	void addParent(String parentName, String kidName)
			throws UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * @param kidName
	 * @return
	 * @pre <code>getCharacter(parentName) != null</code>
	 */
	int getParentCount(String kidName);

	/**
	 * @param kidName
	 * @param parentName
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	void addKid(String kidName, String parentName)
			throws UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * @param parentName
	 * @return
	 */
	int getKidCount(String parentName);

	/**
	 * @param character1
	 * @param character2
	 * @throws UnknownCharacterException
	 * @throws SameCharacterRomanceException
	 * @throws RepeatedRelationshipException
	 */
	void addRomance(String character1, String character2)
			throws UnknownCharacterException, SameCharacterRomanceException, RepeatedRelationshipException;

	/**
	 * 
	 * @param description
	 * @param season
	 * @param episode
	 * @param totalCharacters
	 * @param eventCharacters
	 * @throws UnknownCharacterException
	 */
	void addEvent(String description, int season, int episode, int totalCharacters, List<String> eventCharacters)
			throws UnknownCharacterException;

	/**
	 * 
	 * @param season
	 * @param episode
	 * @param character
	 * @param quote
	 * @throws UnknownCharacterException
	 */
	void addQuote(int season, int episode, String character, String quote) throws UnknownCharacterException;

	/**
	 * 
	 * @param characterName
	 * @return
	 * @throws UnknownCharacterException
	 */
	Iterator<ShowCharacter> getParents(String characterName) throws UnknownCharacterException;

	/**
	 * 
	 * @param characterName
	 * @return
	 * @throws UnknownCharacterException
	 */
	Iterator<ShowCharacter> getKids(String characterName) throws UnknownCharacterException;

	/**
	 * 
	 * @param characterName
	 * @return
	 * @throws UnknownCharacterException
	 */
	Iterator<ShowCharacter> getPartners(String characterName) throws UnknownCharacterException;

	/**
	 * @param characterName
	 * @return
	 * @throws UnknownCharacterException
	 */
	Iterator<ShowCharacter> getSiblings(String characterName) throws UnknownCharacterException;

	/**
	 * 
	 * @param characterName
	 * @return
	 * @throws UnknownCharacterException
	 */
	Iterator<Event> getEvents(String characterName) throws UnknownCharacterException;
	
	/**
	 * @param quote
	 * @return
	 * @throws UnknownQuoteException
	 */
	Iterator<ShowCharacter> getCharactersOfQuote(String quote) throws UnknownQuoteException;

	/**
	 * @param actorName
	 * @return
	 */
	boolean actorHasRomance(String actorName);

	/**
	 * @return
	 */
	boolean isThereRomance();

}
