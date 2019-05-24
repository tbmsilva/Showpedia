/**
 * 
 */
package actors;

import java.util.*;

import characters.Real;
import exceptions.DuplicateCharacterException;
import shows.Show;
import shows.ShowComparator;

/**
 * @author tbmsilva
 *
 */
public class ActorClass implements Actor {

	private List<Show> shows;
	private List<Real> characters;
	private String name;

	public ActorClass(String name) {
		this.name = name;
		characters = new ArrayList<>();
		shows = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public int getRoleCount() {
		return characters.size();
	}
	
	public int getNumberOfShows() {
		return shows.size();
	}

	public void addCharacter(Real character) throws DuplicateCharacterException {
		if (characters.contains(character))
			throw new DuplicateCharacterException();
		else
			characters.add(character);
	}
	
	public void addShow(Show show) {
		if(!shows.contains(show))
			shows.add(show);
	}
	
	public Iterator<Show> getShowIterator() {
		shows.sort(new ShowComparator());
		return shows.iterator();
	}

	public int getTotalRomances() {
		int romances = 0;
		Iterator<Real> it = characters.iterator();
		while(it.hasNext())
			romances += it.next().getAmountOfPartners();
		return romances;
	}
	
	public int getShowsWithRomances() {
		int romances = 0;
		boolean hasRomance = false;
		Iterator<Show> it = shows.iterator();
		while(it.hasNext() && !hasRomance) {
			if(it.next().actorHasRomance(name))
				romances++;
		}
		return romances;
	}
}
