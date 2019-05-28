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

	/**
	 * Returns the episode with the given number, in the given season number.
	 * 
	 * @param season  - number of season
	 * @param episode - number of episode
	 * @return the episode with the given number, in the given season number.
	 * @pre <code> season <= getSeasonCount() && episode <= getSeasonEpisodeCount(season) </code>
	 */
	Episode getEpisode(int season, int episode);

	/**
	 * Adds a Real character to the list of characters of the show.
	 * 
	 * @param character - character to be added
	 * @throws DuplicateCharacterException
	 * @throws InvalidActorFeeException
	 */
	void addRealCharacter(Real character) throws DuplicateCharacterException, InvalidActorFeeException;

	/**
	 * Adds a CGI character to the list of character of the show.
	 * 
	 * @param character - character to be added
	 * @throws DuplicateCharacterException
	 */
	void addCGICharacter(CGI character) throws DuplicateCharacterException;

	/**
	 * Returns the character with the given name. Returns null if there isn't a
	 * character witht the given name.
	 * 
	 * @param name - name of character
	 * @return Returns the character with the given name. Returns null if there
	 *         isn't a character witht the given name.
	 */
	ShowCharacter getCharacter(String name);

	/**
	 * Adds a parent to the list of parents of the kid.
	 * 
	 * @param parentName - name of the parent.
	 * @param kidName    - name of the kid.
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	void addParent(String parentName, String kidName)
			throws UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * Returns the number of parents a kid has.
	 * 
	 * @param kidName - name of kid.
	 * @return the number of parents of a kid.
	 * @pre <code>getCharacter(parentName) != null</code>
	 */
	int getParentCount(String kidName);

	/**
	 * Adds a kid to the list of kids of the parent.
	 * 
	 * @param kidName    - name of the kid.
	 * @param parentName - name of the parent.
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	void addKid(String kidName, String parentName)
			throws UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * Returns the amount of parents a kid has.
	 * 
	 * @param parentName - name of the parent.
	 * @return the amount of parents a kid has.
	 */
	int getKidCount(String parentName);

	/**
	 * Adds each character to the list of partners of the other character.
	 * 
	 * @param character1
	 * @param character2
	 * @throws UnknownCharacterException
	 * @throws SameCharacterRomanceException
	 * @throws RepeatedRelationshipException
	 */
	void addRomance(String character1, String character2)
			throws UnknownCharacterException, SameCharacterRomanceException, RepeatedRelationshipException;

	/**
	 * Creates and adds an event to the show.
	 * 
	 * @param description     - description of the event.
	 * @param season          - season of the event.
	 * @param episode         - episode of the event.
	 * @param totalCharacters - number of characters involved in the event.
	 * @param eventCharacters - names of the characters involved in the event.
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

	int numberOfSeasonsOfACharacter(String characterName);

	/**
	 * @param actorName
	 * @return
	 */
	boolean actorHasRomance(String actorName);

	/**
	 * @return
	 */
	boolean isThereRomance();

	/**
	 * @param characterName1
	 * @param characterName2
	 * @return
	 * @throws UnknownCharacterException
	 * @throws NoRelationshipException
	 */
	Iterator<ShowCharacter> HAT2R(String characterName1, String characterName2)
			throws UnknownCharacterException, NoRelationshipException;

}
