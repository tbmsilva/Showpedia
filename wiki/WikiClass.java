/**
 * 
 */
package wiki;

import java.util.*;

import actors.*;
import characters.*;
import company.*;
import episodes.*;
import event.Event;
import exceptions.*;
import shows.*;

/**
 * @author tbmsilva & m.lami
 *
 */
/**
 * @author tbmsilva
 *
 */
public class WikiClass implements Wiki {

	private static final String CATEGORY_REAL = "REAL";
	private static final String CATEGORY_VIRTUAL = "VIRTUAL";

	private Show currentShow;
	private List<Show> shows;
	private List<CGICompany> cgiCompanies;
	private List<Actor> actors;

	public WikiClass() {
		currentShow = null;
		shows = new ArrayList<>();
		cgiCompanies = new ArrayList<>();
		actors = new ArrayList<>();
	}

	public Show getCurrentShow() throws NoShowSelectedException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		return currentShow;
	}

	public void addShow(String name) throws ShowAlreadyExistsException {
		if (getShow(name) != null)
			throw new ShowAlreadyExistsException();
		else {
			Show s = new ShowClass(name);
			shows.add(s);
			currentShow = s;
		}
	}

	public void switchToShow(String name) throws UnknownShowException {
		Show s = getShow(name);
		if (s == null)
			throw new UnknownShowException();
		else {
			currentShow = s;
		}
	}

	public void addSeason() throws NoShowSelectedException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else
			currentShow.addSeason();
	}

	public void addEpisode(int season, String name) throws NoShowSelectedException, UnknownSeasonException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else if (season > currentShow.getSeasonCount() || season <= 0)
			throw new UnknownSeasonException();
		else {
			Episode e = new EpisodeClass(name);
			currentShow.addEpisode(e, season);
		}
	}

	public void addCharacter(String category, String characterName, String actorOrCompanyName, int cost)
			throws NoShowSelectedException, UnknownActorCategoryException, DuplicateCharacterException,
			InvalidActorFeeException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else if (!category.equals(CATEGORY_REAL) && !category.equals(CATEGORY_VIRTUAL))
			throw new UnknownActorCategoryException();
		else if (category.equalsIgnoreCase(CATEGORY_REAL))
			addRealCharacter(characterName, actorOrCompanyName, cost);
		else
			addCGICharacter(characterName, actorOrCompanyName, cost);
	}

	public int getActorRoleCount(String actor) {
		Actor a = getActor(actor);
		return a.getRoleCount();
	}

	public void addRelationship(String parentName, String kidName) throws NoShowSelectedException,
			UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else {
			currentShow.addParent(parentName, kidName);
			currentShow.addKid(kidName, parentName);
		}
	}

	public int getParentCount(String kidName) {
		return currentShow.getParentCount(kidName);
	}

	public int getKidCount(String parentName) {
		return currentShow.getKidCount(parentName);
	}

	public void addRomance(String character1, String character2) throws NoShowSelectedException,
			UnknownCharacterException, SameCharacterRomanceException, RepeatedRelationshipException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else
			currentShow.addRomance(character1, character2);
	}

	public void addEvent(String description, int season, int episode, int totalCharacters, List<String> eventCharacters)
			throws NoShowSelectedException, InvalidSeasonException, InvalidEpisodeException, UnknownCharacterException,
			DuplicateCharacterException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else if (season > currentShow.getSeasonCount() || season <= 0)
			throw new InvalidSeasonException(currentShow.getName(), season);
		else if (episode > currentShow.getSeasonEpisodeCount(season) || episode <= 0)
			throw new InvalidEpisodeException(currentShow.getName(), season, episode);
		else if (duplicated(eventCharacters))
			throw new DuplicateCharacterException();
		else
			currentShow.addEvent(description, season, episode, totalCharacters, eventCharacters);
	}

	public void addQuote(int season, int episode, String character, String quote)
			throws NoShowSelectedException, InvalidSeasonException, InvalidEpisodeException, UnknownCharacterException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else if (season > currentShow.getSeasonCount() || season <= 0)
			throw new InvalidSeasonException(currentShow.getName(), season);
		else if (episode > currentShow.getSeasonEpisodeCount(season) || episode <= 0)
			throw new InvalidEpisodeException(currentShow.getName(), season, episode);
		else
			currentShow.addQuote(season, episode, character, quote);
	}

	public Iterator<List<Episode>> getSeasonsInterval(int startingSeason, int endingSeason)
			throws NoShowSelectedException, InvalidSeasonIntervalException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else if (startingSeason < 0 || endingSeason < 0 || startingSeason > endingSeason
				|| startingSeason > currentShow.getSeasonCount() || endingSeason > currentShow.getSeasonCount())
			throw new InvalidSeasonIntervalException();
		else {
			List<List<Episode>> l = new ArrayList<>();
			for (int i = startingSeason; i <= endingSeason; i++) {
				l.add(currentShow.getSeason(i));
			}
			return l.iterator();
		}
	}

	public Iterator<ShowCharacter> getParents(String characterName)
			throws NoShowSelectedException, UnknownCharacterException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else
			return currentShow.getParents(characterName);
	}

	public Iterator<ShowCharacter> getKids(String characterName)
			throws NoShowSelectedException, UnknownCharacterException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else
			return currentShow.getKids(characterName);
	}

	public Iterator<ShowCharacter> getPartners(String characterName)
			throws NoShowSelectedException, UnknownCharacterException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else
			return currentShow.getPartners(characterName);
	}

	public Iterator<ShowCharacter> getSiblings(String characterName)
			throws NoShowSelectedException, UnknownCharacterException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else
			return currentShow.getSiblings(characterName);
	}

	public Iterator<Event> getEvents(String characterName) throws NoShowSelectedException, UnknownCharacterException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else
			return currentShow.getEvents(characterName);
	}

	public Iterator<Show> getShowsOfActor(String characterName)
			throws NoShowSelectedException, UnknownCharacterException, CharacterIsVirtualException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else if (currentShow.getCharacter(characterName) == null)
			throw new UnknownCharacterException(characterName);
		else if (currentShow.getCharacter(characterName) instanceof CGI)
			throw new CharacterIsVirtualException(characterName);
		else {
			Actor a = ((Real) currentShow.getCharacter(characterName)).getActor();
			return a.getShowIterator();
		}
	}
	
	public Iterator<ShowCharacter> getCharactersOfQuote(String quote) throws NoShowSelectedException, UnknownQuoteException {
		if(currentShow == null)
			throw new NoShowSelectedException();
		else 
			return currentShow.getCharactersOfQuote(quote);
	}

	/**
	 * 
	 * @param characterName
	 * @param actorName
	 * @param cost
	 * @throws DuplicateCharacterException
	 * @throws InvalidActorFeeException
	 */
	private void addRealCharacter(String characterName, String actorName, int cost)
			throws DuplicateCharacterException, InvalidActorFeeException {
		Real character = new RealCharacterClass(characterName, cost);
		currentShow.addRealCharacter(character);
		addCharacterToActor(actorName, character);
	}

	/**
	 * @param actorName
	 * @param character
	 * @throws DuplicateCharacterException
	 */
	private void addCharacterToActor(String actorName, Real character) throws DuplicateCharacterException {
		Actor a = getActor(actorName);
		if (a != null) {
			a.addCharacter(character);
			character.setActor(a);
		} else {
			a = new ActorClass(actorName);
			a.addCharacter(character);
			actors.add(a);
			character.setActor(a);
		}
		a.addShow(currentShow);
	}

	/**
	 * Creates and adds a CGI character to the character list of the show, and the
	 * company who made the character.
	 * 
	 * @param characterName - name of the character.
	 * @param companyName   - name of the company who made the character.
	 * @param cost          - cost per season of the character.
	 * @throws DuplicateCharacterException
	 */
	private void addCGICharacter(String characterName, String companyName, int cost)
			throws DuplicateCharacterException {
		CGI character = new CGICharacterClass(characterName, cost);
		currentShow.addCGICharacter(character);
		addCharacterToCompany(companyName, character);
	}

	/**
	 * Adds a given CGI character to the CGI company with the given name.
	 * 
	 * @param companyName - name of the company
	 * @param character   - character to be added to the company
	 * @pre <code>character != null</code>
	 */
	private void addCharacterToCompany(String companyName, CGI character) {
		CGICompany company = getCompany(companyName);
		if (company != null)
			company.addCharacter(character);
		else {
			CGICompany c = new CGICompanyClass(companyName);
			c.addCharacter(character);
			cgiCompanies.add(c);
		}
	}

	/**
	 * Returns the show with the given name.
	 * 
	 * @param name - name of the show.
	 * @return the show with the given name. Returns <code>null</code> if there is
	 *         no show with the given name.
	 */
	private Show getShow(String name) {
		Show res = null;
		boolean found = false;
		Iterator<Show> it = shows.iterator();
		while (it.hasNext() && !found) {
			Show temp = it.next();
			if (temp.getName().equals(name)) {
				res = temp;
				found = true;
			}
		}
		return res;
	}

	/**
	 * Returns the CGI company with the given name.
	 * 
	 * @param name - name of the company.
	 * @return the CGI company with the given name. Returns <code>null</code> if
	 *         there is no company with the given name.
	 */
	private CGICompany getCompany(String name) {
		CGICompany res = null;
		boolean found = false;
		Iterator<CGICompany> it = cgiCompanies.iterator();
		while (it.hasNext() && !found) {
			CGICompany temp = it.next();
			if (temp.getName().equals(name)) {
				res = temp;
				found = true;
			}
		}
		return res;
	}

	private boolean duplicated(List<String> eventCharacters) {
		boolean duplicated = false;
		for (int i = 0; i < eventCharacters.size(); i++) {
			for (int j = i + 1; j < eventCharacters.size(); j++) {
				if (eventCharacters.get(i).equals(eventCharacters.get(j)))
					duplicated = true;
			}
		}
		return duplicated;
	}

	/**
	 * Returns the actor with the given name.
	 * 
	 * @param name - name of the actor.
	 * @return the actor with the given name. Returns <code>null</code> if there is
	 *         no actor with the given name.
	 */
	private Actor getActor(String name) {
		Actor res = null;
		boolean found = false;
		Iterator<Actor> it = actors.iterator();
		while (it.hasNext() && !found) {
			Actor temp = it.next();
			if (temp.getName().equals(name)) {
				res = temp;
				found = true;
			}
		}
		return res;
	}
}
