/**
 * 
 */
package jUnit;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import wiki.*;

/**
 * @project ShowPedia
 * @author tbmsilva & m.lami
 * @date 27/05/2019
 * @time 15:23:30
 */
public class EventTest {

	@Test
	public void testAddCharacters() throws Exception {
		Wiki wiki = new WikiClass();
		wiki.addShow("Show");
		wiki.addCharacter("REAL", "Character1", "Actor1", 100);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character1"), null);
		wiki.addCharacter("REAL", "Character2", "Actor2", 100);
		assertNotEquals(wiki.getCurrentShow().getCharacter("Character2"), null);

	}
}