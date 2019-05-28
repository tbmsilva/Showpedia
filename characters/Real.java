/**
 * 
 */
package characters;

import actors.Actor;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface Real extends ShowCharacter {

	/**
	 * Returns the actor who plays the character.
	 * 
	 * @return the actor who plays the character.
	 */
	Actor getActor();

	/**
	 * Sets the actor playing the character.
	 * 
	 * @param actor - actor playing the character.
	 */
	void setActor(Actor actor);

	/**
	 * Returns the cost per episode of the character.
	 * 
	 * @return the cost per episode of the character.
	 */
	int getCostPerEpisode();
}
