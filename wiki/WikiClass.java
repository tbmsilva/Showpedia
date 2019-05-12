/**
 * 
 */
package wiki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import characters.CGI;
import characters.Real;
import episodes.Episode;
import episodes.EpisodeClass;
import exceptions.DuplicateCharacterException;
import exceptions.InvalidActorFeeException;
import exceptions.InvalidRelationshipException;
import exceptions.NoShowSelectedException;
import exceptions.ShowAlreadyExistsException;
import exceptions.UnknownActorCategoryException;
import exceptions.UnknownCharacterException;
import exceptions.UnknownSeasonException;
import exceptions.UnknownShowException;
import shows.Show;
import shows.ShowClass;

/**
 * @author tbmsilva
 *
 */
public class WikiClass implements Wiki {

	private static final String CATEGORY_REAL = "REAL";
	private static final String CATEGORY_VIRTUAL = "VIRTUAL";

	private Show currentShow;
	private ArrayList<Show> shows;
	private HashMap<String, ArrayList<CGI>> cgiCompanies;
	private HashMap<String, ArrayList<Real>> actors;

	public WikiClass() {
		currentShow = null;
		shows = new ArrayList<Show>();
		cgiCompanies = new HashMap<String, ArrayList<CGI>>();
		actors = new HashMap<String, ArrayList<Real>>();
	}

	public String currentShowInfo() throws NoShowSelectedException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else {
			return String.format("%s. Seasons: %d Episodes: %d", currentShow.getName(), currentShow.getSeasonCount(),
					currentShow.getEpisodeCount());
		}
	}

	public void addShow(String name) throws ShowAlreadyExistsException {
		if (getShow(name) != null)
			throw new ShowAlreadyExistsException();
		else {
			Show s = new ShowClass(name);
			shows.add(s);
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

	public String addEpisode(int season, String name) throws NoShowSelectedException, UnknownSeasonException {
		if (currentShow == null)
			throw new NoShowSelectedException();
		else if (season > currentShow.getSeasonCount() || season <= 0)
			throw new UnknownSeasonException();
		else {
			Episode e = new EpisodeClass(name);
			currentShow.addEpisode(e, season);
			return String.format("%s S%d, Ep%d: %s", currentShow.getName(), season,
					currentShow.getSeasonEpisodeCount(season), e.getName());
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

	public String getCharacterInfo(String category, String characterName, String actorOrCompanyName) {
		if (category.equals(CATEGORY_REAL)) {
			return String.format("%s is now part of %s. This is %s role %d.", characterName, currentShow.getName(),
					actorOrCompanyName, actors.get(actorOrCompanyName).size());
		} else {
			return String.format("%s is now part of %s. This is a virtual actor.", characterName,
					currentShow.getName());
		}
	}

	public int addParent(String parentName, String kidName)
			throws UnknownCharacterException, InvalidRelationshipException {
		return currentShow.addParent(parentName, kidName);
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
