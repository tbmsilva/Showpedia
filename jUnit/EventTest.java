package jUnit;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import characters.CGI;
import event.*;
import wiki.*;
/**
 * @project ShowPedia
 * @author tbmsilva
 * @date 28/05/2019
 * @time 18:37:54
 */
public class EventTest {

	@Test
	public void test() throws Exception {
		Wiki wiki = new WikiClass();
		wiki.addShow("Show");
		assertNotEquals(wiki.getCurrentShow(), null);
		wiki.addCharacter("REAL", "Character 1", "Actor 1", 100);
		wiki.addCharacter("VIRTUAL", "Character 2", "Company 1", 100);
		wiki.addCharacter("VIRTUAL", "Character 3", "Company 1", 100);
		wiki.addCharacter("REAL", "Character 4", "Actor 2", 100);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character 1"), null);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character 2"), null);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character 3"), null);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character 4"), null);
		wiki.addEpisode(1, "Episode 1");
		wiki.addEpisode(1, "Episode 2");
		wiki.addEpisode(1, "Episode 3");
		assertEquals(wiki.getCurrentShow().getEpisodeCount(), 3);
		List<String> l1 = new ArrayList<>();
		l1.add("Character 1");
		wiki.addEvent("Event 1", 1, 1, 1, l1);
		assertEquals(wiki.getCurrentShow().getEpisode(1, 1).getEventIterator().hasNext(), true);
		Event e1 = wiki.getCurrentShow().getEpisode(1, 1).getEventIterator().next();
		assertEquals(e1.isInEvent("Character 1"), true);
		assertNotEquals(e1.isInEvent("Character 2"), true);
		List<String> l2 = new ArrayList<>();
		l2.add("Character 1");
		l2.add("Character 2");
		l2.add("Character 3");
		l2.add("Character 4");
		wiki.addEvent("Event 2", 1, 2, 4, l2);
		assertEquals(wiki.getCurrentShow().getEpisode(1, 2).getEventIterator().hasNext(), true);
		Event e2 = wiki.getCurrentShow().getEpisode(1, 2).getEventIterator().next();
		assertEquals(e2.isInEvent("Character 1"), true);
		assertEquals(e2.isInEvent("Character 2"), true);
		assertEquals(e2.isInEvent("Character 3"), true);
		assertEquals(e2.isInEvent("Character 4"), true);
		CGI v1 = (CGI) wiki.getCurrentShow().getCharacter("Character 2");
		assertEquals(v1.numberOfParticipatingSeasons(), 1);
		wiki.addSeason();
		wiki.addEpisode(2, "Episode 1");
		assertEquals(wiki.getCurrentShow().getSeasonCount(), 2);
		assertEquals(wiki.getCurrentShow().getSeasonEpisodeCount(2), 1);
		List<String> l3 = new ArrayList<>();
		l3.add("Character 2");
		wiki.addEvent("Event 3", 2, 1, 1, l3);
		CGI v2 = (CGI) wiki.getCurrentShow().getCharacter("Character 2");
		assertEquals(v2.numberOfParticipatingSeasons(), 2);
	}

}
