/**
 * 
 */
package wiki;

import java.util.ArrayList;

import exceptions.NoShowSelectedException;
import shows.Show;

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
}
