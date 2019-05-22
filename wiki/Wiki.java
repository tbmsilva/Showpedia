/**
 * 
 */
package wiki;

import java.util.*;

import characters.ShowCharacter;
import episodes.Episode;
import exceptions.*;
import shows.Show;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface Wiki {

	/**
	 * Returns the current selected show, unless no show is selected
	 * 
	 * @return the current selected show
	 * @throws NoShowSelectedException
	 */
	public Show getCurrentShow() throws NoShowSelectedException;

	/**
	 * Creates and adds a show
	 * 
	 * @param name - show's name
	 * @throws ShowAlreadyExistsException
	 */
	void addShow(String name) throws ShowAlreadyExistsException;

	/**
	 * Sets show with given name as current show
	 * 
	 * @param name - show's name
	 * @throws UnknownShowException
	 */
	void switchToShow(String name) throws UnknownShowException;

	/**
	 * Adds a season to the current show
	 * 
	 * @throws NoShowSelectedException
	 */
	void addSeason() throws NoShowSelectedException;

	/**
	 * Adds an episode to a particular season of the show. The new episode is added
	 * to the corresponding season, in first available serial number.
	 * 
	 * @param season - season number
	 * @param name   - name of the episode
	 * @throws NoShowSelectedException
	 * @throws UnknownSeasonException
	 */
	void addEpisode(int season, String name) throws NoShowSelectedException, UnknownSeasonException;

	/**
	 * Creates a real or virtual character and adds it to the respective actor or
	 * company's list.
	 * 
	 * @param category           - real or virtual.
	 * @param characterName      - name of the character.
	 * @param actorOrCompanyName - name of the actor playing the character, or the
	 *                           CGI company who made the character.
	 * @param cost               - cost per episode (real) or per season (virtual)
	 *                           of the character.
	 * @throws NoShowSelectedException
	 * @throws UnknownActorCategoryException
	 * @throws DuplicateCharacterException
	 * @throws InvalidActorFeeException
	 */
	void addCharacter(String category, String characterName, String actorOrCompanyName, int cost)
			throws NoShowSelectedException, UnknownActorCategoryException, DuplicateCharacterException,
			InvalidActorFeeException;

	/**
	 * Returns the number of role an actor has been in
	 * 
	 * @param actor - actor's name
	 * @return actor's number of roles
	 */
	int getActorRoleCount(String actor);

	/**
	 * Adds a relationship link between the two given characters.
	 * 
	 * @param parentName - name of the parent character.
	 * @param kidName    - name of the kid character.
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	void addRelationship(String parentName, String kidName) throws NoShowSelectedException, UnknownCharacterException,
			InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * Returns the number of kids a given parent has.
	 * 
	 * @param parentName - name of the parent.
	 * @return the number of kids the parent has.
	 * @pre <code>currentShow.getCharacter(parentName) != null</code>
	 */
	int getKidCount(String parentName);

	/**
	 * Returns the number of parents a given kid has.
	 * 
	 * @param kidName - name of the kid.
	 * @return the number of parents the kid has.
	 * @pre <code>currentShow.getCharacter(kidName) != null</code>
	 */
	int getParentCount(String kidName);

	/**
	 * Adds a romance link between two characters.
	 * 
	 * @param character1 - one of the characters to add the link to.
	 * @param character2 - other character to add the link to.
	 * @throws NoShowSelectedException
	 * @throws UnknownCharacterException
	 * @throws SameCharacterRomanceException
	 * @throws RepeatedRelationshipException
	 */
	void addRomance(String character1, String character2) throws NoShowSelectedException, UnknownCharacterException,
			SameCharacterRomanceException, RepeatedRelationshipException;

	/**
	 * Adds event in a given episode.
	 * 
	 * @param description     - description of the event.
	 * @param season          - season the event happened.
	 * @param episode         - episode the event happened.
	 * @param totalCharacters - number of chracters who were involved in the event.
	 * @param characters      - names of the characters involved in the event.
	 * @throws NoShowSelectedException
	 * @throws InvalidSeasonException
	 * @throws InvalidEpisodeException
	 * @throws UnknownCharacterException
	 * @pre <code>totalCharacters > 0</code>
	 */
	void addEvent(String description, int season, int episode, int totalCharacters, SortedSet<String> characters)
			throws NoShowSelectedException, InvalidSeasonException, InvalidEpisodeException, UnknownCharacterException;

	/**
	 * Returns an iterator for the interval of seasons given.
	 * 
	 * @param startingSeason - initial season of the interval.
	 * @param endingSeason   - ending season of the interval.
	 * @return an iterator for the seasons in the interval.
	 * @throws NoShowSelectedException
	 * @throws InvalidSeasonIntervalException
	 */
	Iterator<List<Episode>> getSeasonsInterval(int startingSeason, int endingSeason)
			throws NoShowSelectedException, InvalidSeasonIntervalException;

	/**
	 * Adds a quote in the specified episode, associated to the character who said
	 * said quote.
	 * 
	 * @param season    - season of the quote.
	 * @param episode   - episode of the quote.
	 * @param character - name of the character who said the quote.
	 * @param quote     - the quote.
	 * @throws NoShowSelectedException
	 * @throws InvalidSeasonException
	 * @throws InvalidEpisodeException
	 * @throws UnknownCharacterException
	 */
	void addQuote(int season, int episode, String character, String quote)
			throws NoShowSelectedException, InvalidSeasonException, InvalidEpisodeException, UnknownCharacterException;

	/**
	 * Returns an iterator for the parents of a given character.
	 * 
	 * @param characterName - name of the character.
	 * @return an iterator for the parents of the character.
	 * @throws NoShowSelectedException
	 * @throws UnknownCharacterException
	 */
	Iterator<ShowCharacter> getParents(String characterName) throws NoShowSelectedException, UnknownCharacterException;

	/**
	 * Returns an iterator for the kids of the character.
	 * 
	 * @param characterName - name of the character.
	 * @return an iterator for the kids of the character.
	 * @throws NoShowSelectedException
	 * @throws UnknownCharacterException
	 */
	Iterator<ShowCharacter> getKids(String characterName) throws NoShowSelectedException, UnknownCharacterException;

	/**
	 * Returns an iterator for the partners of the character.
	 * 
	 * @param characterName - name of the character.
	 * @return an iterator for the partners of the character.
	 * @throws NoShowSelectedException
	 * @throws UnknownCharacterException
	 */
	Iterator<ShowCharacter> getPartners(String characterName) throws NoShowSelectedException, UnknownCharacterException;

	/**
	 * @param characterName
	 * @return
	 * @throws NoShowSelectedException
	 * @throws UnknownCharacterException
	 */
	public Iterator<ShowCharacter> getSiblings(String characterName)
			throws NoShowSelectedException, UnknownCharacterException;

	/**
	 * @param characterName
	 * @return
	 * @throws NoShowSelectedException
	 * @throws UnknownCharacterException
	 * @throws CharacterIsVirtualException
	 */
	public Iterator<Show> getShowsOfActor(String characterName)
			throws NoShowSelectedException, UnknownCharacterException, CharacterIsVirtualException;

}
