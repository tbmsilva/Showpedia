/**
 * 
 */
package wiki;

import java.util.*;

import characters.*;
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
	private Map<String, ArrayList<CGI>> cgiCompanies;
	private Map<String, ArrayList<Real>> actors;

	public WikiClass() {
		currentShow = null;
		shows = new ArrayList<Show>();
		cgiCompanies = new HashMap<String, ArrayList<CGI>>();
		actors = new HashMap<String, ArrayList<Real>>();
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
		else if (category.equalsIgnoreCase(CATEGORY_REAL)) {

			if (!actors.containsKey(actorOrCompanyName)) {
				ArrayList<Real> a = new ArrayList<Real>();
				a.add(currentShow.addRealCharacter(characterName, actorOrCompanyName, cost));
				actors.put(actorOrCompanyName, a);
			} else
				actors.get(actorOrCompanyName)
						.add(currentShow.addRealCharacter(characterName, actorOrCompanyName, cost));
		} else {
			if (!cgiCompanies.containsKey(actorOrCompanyName)) {
				ArrayList<CGI> a = new ArrayList<CGI>();
				a.add(currentShow.addCGICharacter(characterName, actorOrCompanyName, cost));
				cgiCompanies.put(actorOrCompanyName, a);
			} else
				cgiCompanies.get(actorOrCompanyName)
						.add(currentShow.addCGICharacter(characterName, actorOrCompanyName, cost));
		}
	}

	public int getActorRoleCount(String actor) {
		return actors.get(actor).size();
	}

	public String addRelationship(String parentName, String kidName)
			throws NoShowSelectedException, UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		return String.format("%s has now %d kids. %s has now %d parent(s).", parentName,
				currentShow.addKid(kidName, parentName), kidName, currentShow.addParent(parentName, kidName));
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
