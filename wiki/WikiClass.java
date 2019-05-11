/**
 * 
 */
package wiki;

import java.util.ArrayList;
import java.util.Iterator;

import episodes.Episode;
import episodes.EpisodeClass;
import exceptions.NoShowSelectedException;
import exceptions.ShowAlreadyExistsException;
import exceptions.UnknownSeasonException;
import exceptions.UnknownShowException;
import shows.Show;
import shows.ShowClass;

/**
 * @author tbmsilva
 *
 */
public class WikiClass implements Wiki {

	private Show currentShow;
	private ArrayList<Show> shows;

	public WikiClass() {
		currentShow = null;
		shows = new ArrayList<Show>();
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
