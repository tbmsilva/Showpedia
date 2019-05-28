/**
 * 
 */
package characters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tbmsilva & m.lami
 *
 */
public class CGICharacterClass extends AbstractCharacter implements CGI {

	private int costPerSeason;
	private Map<Integer, Boolean> participations;

	public CGICharacterClass(String name, int costPerSeason) {
		super(name);
		this.costPerSeason = costPerSeason;
		participations = new HashMap<>();
	}

	public int getCostPerSeason() {
		return costPerSeason;
	}

	public void addParticipation(int season) {
		participations.put(season, true);
	}

	public int numberOfParticipatingSeasons() {
		return participations.size();
	}
}
