/**
 * 
 */
package characters;

import java.util.Comparator;

/**
 * @author tbmsilva
 *
 */
public class CharacterComparator implements Comparator<ShowCharacter> {

	public int compare(ShowCharacter c1, ShowCharacter c2) {
		String characterName1 = c1.getName();
		String characterName2 = c2.getName();
		return characterName1.compareTo(characterName2);
	}

}
