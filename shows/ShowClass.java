/**
 * 
 */
package shows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import characters.CGI;
import characters.CGICharacterClass;
import characters.Real;
import characters.RealCharacterClass;
import characters.ShowCharacter;
import episodes.Episode;
import exceptions.DuplicateCharacterException;
import exceptions.InvalidActorFeeException;

/**
 * @author tbmsilva
 *
 */
public class ShowClass implements Show {

	private String name;
	private HashMap<Integer, ArrayList<Episode>> seasons;
	private ArrayList<ShowCharacter> characters;

	public ShowClass(String name) {
		seasons = new HashMap<>();
		ArrayList<Episode> a = new ArrayList<Episode>();
		seasons.put(1, a);
		characters = new ArrayList<ShowCharacter>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getEpisodeCount() {
		int episodeCount = 0;
		for (int i = 1; i <= seasons.size(); i++) {
			episodeCount += seasons.get(i).size();
		}
		return episodeCount;
	}

	public int getSeasonCount() {
		return seasons.size();
	}

	public int getSeasonEpisodeCount(int season) {
		return seasons.get(season).size();
	}

	public void addSeason() {
		seasons.put(seasons.size() + 1, new ArrayList<Episode>());
	}

	public void addEpisode(Episode e, int season) {
		seasons.get(season).add(e);
	}

	public Real addRealCharacter(String characterName, String actorName, int cost)
			throws DuplicateCharacterException, InvalidActorFeeException {
		if (getCharacter(characterName) != null)
			throw new DuplicateCharacterException();
		else if (cost < 0)
			throw new InvalidActorFeeException();
		else {
			Real c = new RealCharacterClass(characterName, actorName, cost);
			characters.add(c);
			return c;
		}
	}

	public CGI addCGICharacter(String characterName, String companyName, int cost) throws DuplicateCharacterException {
		if (getCharacter(characterName) != null)
			throw new DuplicateCharacterException();
		else {
			CGI c = new CGICharacterClass(characterName, cost);
			characters.add(c);
			return c;
		}
	}

	private ShowCharacter getCharacter(String name) {
		boolean found = false;
		ShowCharacter c = null;
		Iterator<ShowCharacter> it = characters.iterator();
		while (it.hasNext() && !found) {
			ShowCharacter temp = it.next();
			if (temp.getName().equals(name)) {
				c = temp;
				found = true;
			}
		}
		return c;
	}
}
