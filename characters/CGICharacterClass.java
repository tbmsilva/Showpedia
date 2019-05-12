/**
 * 
 */
package characters;

/**
 * @author tbmsilva
 *
 */
public class CGICharacterClass extends AbstractCharacter implements CGI {
	
	private int costPerSeason;

	public CGICharacterClass(String name, int costPerSeason) {
		super(name);
		this.costPerSeason = costPerSeason;
	}

	public int getCostPerSeason() {
		return costPerSeason;
	}
}
