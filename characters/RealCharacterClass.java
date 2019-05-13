/**
 * 
 */
package characters;

/**
 * @author tbmsilva & m.lami
 *
 */
public class RealCharacterClass extends AbstractCharacter implements Real {

	private String actor;
	private int costPerEpisode;

	public RealCharacterClass(String name, String actor, int costPerEpisode) {
		super(name);
		this.actor = actor;
		this.costPerEpisode = costPerEpisode;
	}

	public String getActor() {
		return actor;
	}

	public int getCostPerEpisode() {
		return costPerEpisode;
	}

}
