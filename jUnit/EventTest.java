package jUnit;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import characters.CGI;
import event.*;
import wiki.*;

/**
 * @project ShowPedia
 * @author tbmsilva & m.lami
 * @date 28/05/2019
 * @time 18:37:54
 */
public class EventTest {

	private Wiki wiki;

	@Before
	public void setup() throws Exception {
		wiki = new WikiClass();
		wiki.addShow("Show");
	}

	@Test
	public void testAddCharacters() throws Exception {
		wiki.addCharacter("REAL", "Character 1", "Actor 1", 100);
		wiki.addCharacter("REAL", "Character 2", "Actor 2", 100);
		wiki.addCharacter("REAL", "Character 3", "Actor 3", 100);
		wiki.addCharacter("REAL", "Character 4", "Actor 4", 100);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character 1"), null);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character 2"), null);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character 3"), null);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character 4"), null);
	}

	@Test
	public void addEpisodes() throws Exception {
		wiki.addEpisode(1, "Episode 1");
		wiki.addEpisode(1, "Episode 2");
		wiki.addEpisode(1, "Episode 3");
		assertEquals(wiki.getCurrentShow().getEpisodeCount(), 3);
	}

	@Test
	public void addSingleCharacterEvent() throws Exception {
		wiki.addEpisode(1, "Episode 1");
		wiki.addCharacter("REAL", "Character 1", "Actor 1", 100);
		List<String> l = new ArrayList<>();
		l.add("Character 1");
		wiki.addEvent("Event", 1, 1, 1, l);
		assertEquals(wiki.getCurrentShow().getEpisode(1, 1).getEventIterator().hasNext(), true);
		Event e = wiki.getCurrentShow().getEpisode(1, 1).getEventIterator().next();
		assertEquals(e.description(), "Event");
		assertEquals(e.episode(), 1);
		assertEquals(e.season(), 1);
		assertEquals(e.isInEvent("Character 1"), true);
		assertNotEquals(e.isInEvent("Character 2"), true);
	}
	
	@Test
	public void addMultipleCharacterEvent() throws Exception {
		wiki.addEpisode(1, "Episode 1");
		wiki.addCharacter("REAL", "Character 1", "Actor 1", 100);
		wiki.addCharacter("VIRTUAL", "Character 2", "Company 1", 100);
		wiki.addCharacter("REAL", "Character 3", "Actor 2", 100);
		List<String> l = new ArrayList<>();
		l.add("Character 1");
		l.add("Character 2");
		l.add("Character 3");
		wiki.addEvent("Event", 1, 1, 3, l);
		Event e = wiki.getCurrentShow().getEpisode(1, 1).getEventIterator().next();
		assertEquals(e.description(), "Event");
		assertEquals(e.episode(), 1);
		assertEquals(e.season(), 1);
		assertEquals(e.isInEvent("Character 1"), true);
		assertEquals(e.isInEvent("Character 2"), true);
		assertEquals(e.isInEvent("Character 3"), true);
	}
	
	@Test
	public void checkVirtualCaracterParticipation() throws Exception {
		wiki.addEpisode(1, "Episode 1");
		wiki.addCharacter("VIRTUAL", "Character 1", "Company 1", 100);
		wiki.addCharacter("VIRTUAL", "Character 2", "Company 2", 100);
		wiki.addCharacter("VIRTUAL", "Character 3", "Company 3", 100);
		List<String> l1 = new ArrayList<>();
		l1.add("Character 1");
		l1.add("Character 2");
		wiki.addEvent("Event", 1, 1, 2, l1);
		wiki.addSeason();
		wiki.addEpisode(2, "Episode 2");
		List<String> l2 = new ArrayList<>();
		l2.add("Character 1");
		wiki.addEvent("Event", 2, 1, 1, l2);
		CGI c1 = (CGI) wiki.getCurrentShow().getCharacter("Character 1");
		CGI c2 = (CGI) wiki.getCurrentShow().getCharacter("Character 2");
		CGI c3 = (CGI) wiki.getCurrentShow().getCharacter("Character 3");
		assertEquals(c1.numberOfParticipatingSeasons(), 2);
		assertEquals(c2.numberOfParticipatingSeasons(), 1);
		assertEquals(c3.numberOfParticipatingSeasons(), 0);
	}
}
