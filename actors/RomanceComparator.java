/**
 * 
 */
package actors;

import java.util.Comparator;

/**
 * @author tbmsilva
 *
 */
public class RomanceComparator implements Comparator<Actor> {

	public int compare(Actor a1, Actor a2) {
		int totalRomancesA1 = a1.getTotalRomances();
		int totalRomancesA2 = a2.getTotalRomances();
		if (totalRomancesA1 > totalRomancesA2)
			return 1;
		else if (totalRomancesA1 < totalRomancesA2)
			return -1;
		else {
			int numberOfShowsA1 = a1.getNumberOfShows();
			int numberOfShowsA2 = a2.getNumberOfShows();
			if (numberOfShowsA1 > numberOfShowsA2)
				return 1;
			else if (numberOfShowsA1 < numberOfShowsA2)
				return -1;
			else {
				int showsWithRomanceA1 = a1.getShowsWithRomances();
				int showsWithRomanceA2 = a2.getShowsWithRomances();
				if (showsWithRomanceA1 > showsWithRomanceA2)
					return 1;
				else if (showsWithRomanceA1 < showsWithRomanceA2)
					return -1;
				else {
					String a1Name = a1.getName();
					String a2Name = a2.getName();
					return a1Name.compareTo(a2Name);
				}
			}
		}
	}
}
