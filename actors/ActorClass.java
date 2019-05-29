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
 * @author tbmsilva & m.lami
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
		
		assert name != null;
		assert shows != null;
		assert characters != null;
		assert shows.size() >= 0;
		assert characters.size() >= 0;
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
		assert invariants();
		
		if (characters.contains(character))
			throw new DuplicateCharacterException();
		else
			characters.add(character);
		
		assert invariants();
	}
	
	public void addShow(Show show) {
		assert invariants();
		
		if(!shows.contains(show))
			shows.add(show);
		
		assert invariants();
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
	
	private boolean invariants() {
		return (shows.size() >= 0 && characters.size() >= 0 );
	}
}
