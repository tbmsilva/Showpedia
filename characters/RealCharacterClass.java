/**
 * 
 */
package characters;

import actors.Actor;

/**
 * @author tbmsilva & m.lami
 *
 */
public class RealCharacterClass extends AbstractCharacter implements Real {

	private Actor actor;
	private int costPerEpisode;

	public RealCharacterClass(String name, int costPerEpisode) {
		super(name);
		this.costPerEpisode = costPerEpisode;
	}

	public Actor getActor() {
		return actor;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public int getCostPerEpisode() {
		return costPerEpisode;
	}

}
