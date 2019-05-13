/**
 * 
 */
package characters;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface Real extends ShowCharacter {

	/**
	 * Returns the actor's name who plays the character.
	 * 
	 * @return the actor's name who plays the character.
	 */
	String getActor();

	/**
	 * Returns the cost per episode of the character.
	 * 
	 * @return the cost per episode of the character.
	 */
	int getCostPerEpisode();
}
