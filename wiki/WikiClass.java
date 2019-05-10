/**
 * 
 */
package wiki;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.NoShowSelectedException;
import exceptions.ShowAlreadyExistsException;
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
		if(getShow(name) != null)
			throw new ShowAlreadyExistsException();
		else {
			Show s = new ShowClass(name);
			shows.add(s);
		}
	}
	
	private Show getShow(String name) {
		Show res = null;
		boolean found = false;
		Iterator<Show> it = shows.iterator();
		while(it.hasNext() && !found) {
			Show temp = it.next();
			if(temp.getName().equals(name)) {
				res = temp;
				found = true;
			}
		}
		return res;
	}
}
