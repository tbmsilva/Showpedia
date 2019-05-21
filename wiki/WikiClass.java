/**
 * 
 */
package wiki;

import java.util.*;

import characters.*;
import company.CGICompany;
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
	// o prof recomendou classe
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

//	public void addCharacter(String category, String characterName, String actorOrCompanyName, int cost)
//			throws NoShowSelectedException, UnknownActorCategoryException, DuplicateCharacterException,
//			InvalidActorFeeException {
//		if (currentShow == null)
//			throw new NoShowSelectedException();
//		else if (!category.equals(CATEGORY_REAL) && !category.equals(CATEGORY_VIRTUAL))
//			throw new UnknownActorCategoryException();
//		else if (category.equalsIgnoreCase(CATEGORY_REAL)) {
//			if (!actors.containsKey(actorOrCompanyName)) {
//				ArrayList<Real> a = new ArrayList<Real>();
//				a.add(currentShow.addRealCharacter(characterName, actorOrCompanyName, cost));
//				actors.put(actorOrCompanyName, a);
//			} else
//				actors.get(actorOrCompanyName)
//						.add(currentShow.addRealCharacter(characterName, actorOrCompanyName, cost));
//		} else {
//			if (!cgiCompanies.containsKey(actorOrCompanyName)) {
//				ArrayList<CGI> a = new ArrayList<CGI>();
//				a.add(currentShow.addCGICharacter(characterName, actorOrCompanyName, cost));
//				cgiCompanies.put(actorOrCompanyName, a);
//			} else
//				cgiCompanies.get(actorOrCompanyName)
//						.add(currentShow.addCGICharacter(characterName, actorOrCompanyName, cost));
//		}
//	}

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

	private void addCGICharacter(String characterName, String actorOrCompanyName, int cost) {
		
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
}
