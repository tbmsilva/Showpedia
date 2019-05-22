/**
 * 
 */
package shows;

import java.util.Comparator;

/**
 * @author tbmsilva
 *
 */
public class ShowComparator implements Comparator<Show>{

	public int compare(Show s1, Show s2) {
		String s1Name = s1.getName().toUpperCase();
		String s2Name = s2.getName().toUpperCase();
		return s1Name.compareTo(s2Name);
	}

}
