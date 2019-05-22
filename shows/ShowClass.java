package shows;

import java.util.*;

import characters.*;
import episodes.*;
import exceptions.*;
import event.*;

/**
 * @author tbmsilva & m.lami
 *
 */
public class ShowClass implements Show {

	private String name;
	private List<List<Episode>> seasons;
	private List<ShowCharacter> characters;
	private Map<String, List<ShowCharacter>> quotes;

	public ShowClass(String name) {
		this.name = name;
		seasons = new ArrayList<>();
		seasons.add(new ArrayList<>());
		characters = new ArrayList<>();
		quotes = new TreeMap<>();
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

	public List<Episode> getSeason(int season) {
		return seasons.get(season - 1);
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

	public void addRealCharacter(Real character) throws DuplicateCharacterException, InvalidActorFeeException {
		if (getCharacter(character.getName()) != null)
			throw new DuplicateCharacterException();
		else if (character.getCostPerEpisode() < 0)
			throw new InvalidActorFeeException();
		else
			characters.add(character);
	}

	public void addCGICharacter(CGI character) throws DuplicateCharacterException {
		if (getCharacter(character.getName()) != null)
			throw new DuplicateCharacterException();
		else
			characters.add(character);
	}

	public void addParent(String parentName, String kidName)
			throws UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException {
		ShowCharacter parent = getCharacter(parentName);
		ShowCharacter kid = getCharacter(kidName);
		if (parent == null)
			throw new UnknownCharacterException(parentName);
		else if (kid == null)
			throw new UnknownCharacterException(kidName);
		else
			kid.addParent(parent);
	}

	public int getParentCount(String kidName) {
		ShowCharacter kid = getCharacter(kidName);
		return kid.getParentCount();
	}

	public void addKid(String kidName, String parentName)
			throws UnknownCharacterException, InvalidRelationshipException, RepeatedRelationshipException {
		ShowCharacter kid = getCharacter(kidName);
		ShowCharacter parent = getCharacter(parentName);
		if (parent == null)
			throw new UnknownCharacterException(parentName);
		else if (kid == null)
			throw new UnknownCharacterException(kidName);
		else
			parent.addKid(kid);
	}

	public int getKidCount(String parentName) {
		ShowCharacter parent = getCharacter(parentName);
		return parent.getKidCount();
	}

	public void addRomance(String character1, String character2)
			throws UnknownCharacterException, SameCharacterRomanceException, RepeatedRelationshipException {
		ShowCharacter c1 = getCharacter(character1);
		ShowCharacter c2 = getCharacter(character2);
		if (c1 == null)
			throw new UnknownCharacterException(character1);
		else if (c2 == null)
			throw new UnknownCharacterException(character2);
		else {
			c1.addRomance(c2);
			c2.addRomance(c1);
		}
	}

	public void addEvent(String description, int season, int episode, int totalCharacters,
			SortedSet<String> eventCharacters) throws UnknownCharacterException {
		Iterator<String> it = eventCharacters.iterator();
		while (it.hasNext()) {
			String s = it.next();
			ShowCharacter c = getCharacter(s);
			if (c == null) {
				throw new UnknownCharacterException(s);
			}
		}
		Event e = new EventClass(description, season, episode);
		seasons.get(season - 1).get(episode - 1).addEvent(e);
		it = eventCharacters.iterator();
		while (it.hasNext()) {
			ShowCharacter c = getCharacter(it.next());
			c.addEvent(e);
		}
	}

	public void addQuote(int season, int episode, String character, String quote) throws UnknownCharacterException {
		ShowCharacter c = getCharacter(character);
		if (c == null)
			throw new UnknownCharacterException(character);
		else if (quotes.containsKey(quote))
			quotes.get(quote).add(c);
		else {
			List<ShowCharacter> l = new ArrayList<>();
			l.add(c);
			quotes.put(quote, l);
		}
	}

	public Iterator<ShowCharacter> getParents(String characterName) throws UnknownCharacterException {
		ShowCharacter c = getCharacter(characterName);
		if (c == null)
			throw new UnknownCharacterException(characterName);
		else
			return c.getParents();
	}

	public Iterator<ShowCharacter> getKids(String characterName) throws UnknownCharacterException {
		ShowCharacter c = getCharacter(characterName);
		if (c == null)
			throw new UnknownCharacterException(characterName);
		else
			return c.getKids();
	}

	public Iterator<ShowCharacter> getPartners(String characterName) throws UnknownCharacterException {
		ShowCharacter c = getCharacter(characterName);
		if (c == null)
			throw new UnknownCharacterException(characterName);
		else
			return c.getPartners();
	}
	
	public Iterator<Event> getEvents(String characterName) throws UnknownCharacterException {
		ShowCharacter c = getCharacter(characterName);
		if(c==null)
			throw new UnknownCharacterException(characterName);
		else
			return c.getEvents();
	}
	
	public Iterator<ShowCharacter> getSiblings(String characterName) throws UnknownCharacterException {
		ShowCharacter c = getCharacter(characterName);
		if(c == null)
			throw new UnknownCharacterException(characterName);
		else {
			SortedSet<ShowCharacter> siblings = new TreeSet<>();
			Iterator<ShowCharacter> itP = c.getParents();
			while(itP.hasNext()) {
				Iterator<ShowCharacter> itK = itP.next().getKids();
				while(itK.hasNext())
					siblings.add(itK.next());
			}
			return siblings.iterator();
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
