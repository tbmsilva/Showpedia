/**
 * 
 */
package shows;

import java.util.*;

import characters.*;
import episodes.Episode;
import exceptions.*;

/**
 * @author tbmsilva & m.lami
 *
 */
public class ShowClass implements Show {

	private String name;
	private ArrayList<ArrayList<Episode>> seasons;
	private List<ShowCharacter> characters;

	public ShowClass(String name) {
		seasons = new ArrayList<>();
		seasons.add(new ArrayList<>());
		characters = new ArrayList<ShowCharacter>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getEpisodeCount() {
		int episodeCount = 0;
		for (int i = 0; i < seasons.size(); i++) {
			episodeCount += seasons.get(i).size();
		}
		return episodeCount;
	}

	public int getSeasonCount() {
		return seasons.size();
	}

	public int getSeasonEpisodeCount(int season) {
		return seasons.get(season - 1).size();
	}

	public void addSeason() {
		seasons.add(new ArrayList<>());
	}

	public void addEpisode(Episode e, int season) {
		seasons.get(season - 1).add(e);
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

	public int addParent(String parentName, String kidName)
			throws UnknownCharacterException, InvalidRelationshipException {
		ShowCharacter parent = getCharacter(parentName);
		ShowCharacter kid = getCharacter(kidName);
		if (parent == null)
			throw new UnknownCharacterException(parentName);
		else if (kid == null)
			throw new UnknownCharacterException(kidName);
		else
			return kid.addParent(parent);
	}

	public int addKid(String kidName, String parentName)
			throws UnknownCharacterException, InvalidRelationshipException {
		ShowCharacter kid = getCharacter(kidName);
		ShowCharacter parent = getCharacter(parentName);
		if (kid == null)
			throw new UnknownCharacterException(kidName);
		else if (parent == null)
			throw new UnknownCharacterException(parentName);
		else
			return parent.addKid(kid);
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
