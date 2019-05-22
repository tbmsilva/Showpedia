/**
 * 
 */
package wiki;

import java.util.*;

import characters.*;
import company.CGICompany;
import company.CGICompanyClass;
import episodes.*;
import exceptions.*;
import shows.*;

/**
 * @author tbmsilva & m.lami
 *
 */
public class WikiClass implements Wiki {

	private static final String CATEGORY_REAL = "REAL";
	private static final String CATEGORY_VIRTUAL = "VIRTUAL";

	private Show currentShow;
	private List<Show> shows;
	private List<CGICompany> cgiCompanies;
	private Map<String, List<Real>> actors;

	public WikiClass() {
		currentShow = null;
		shows = new ArrayList<>();
		cgiCompanies = new ArrayList<>();
		actors = new HashMap<>();
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
		return actors.get(actor).size();
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
		return currentShow.getParentCount(parentName);
	}

	public void addRomance(String character1, String character2) throws NoShowSelectedException,
			UnknownCharacterException, SameCharacterRomanceException, RepeatedRelationshipException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else
			currentShow.addRomance(character1, character2);
	}

	public void addEvent(String description, int season, int episode, int totalCharacters, SortedSet<String> characters)
			throws NoShowSelectedException, InvalidSeasonException, InvalidEpisodeException, UnknownCharacterException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else if (season > currentShow.getSeasonCount() || season <= 0)
			throw new InvalidSeasonException(currentShow.getName(), season);
		else if (episode > currentShow.getSeasonEpisodeCount(season) || episode <= 0)
			throw new InvalidEpisodeException(currentShow.getName(), season, episode);
		else
			currentShow.addEvent(description, season, episode, totalCharacters, characters);
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
	
	private void addRealCharacter(String characterName, String actorName, int cost)
			throws DuplicateCharacterException, InvalidActorFeeException {
		Real character = new RealCharacterClass(characterName, actorName, cost);
		currentShow.addRealCharacter(character);
		addCharacterToActor(actorName, character);
	}

	private void addCharacterToActor(String actorName, Real character) {
		if (actors.containsKey(actorName))
			actors.get(actorName).add(character);
		else {
			List<Real> a = new ArrayList<>();
			a.add(character);
			actors.put(actorName, a);
		}
	}

	private void addCGICharacter(String characterName, String companyName, int cost)
			throws DuplicateCharacterException {
		CGI character = new CGICharacterClass(characterName, cost);
		currentShow.addCGICharacter(character);
		addCharacterToCompany(companyName, character);
	}

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
}
