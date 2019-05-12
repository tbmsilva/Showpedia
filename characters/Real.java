/**
 * 
 */
package characters;

/**
 * @author tbmsilva
 *
 */
public interface Real extends ShowCharacter {

	/**
	 * Returns the actor's name who plays the character.
	 * 
	 * @return the actor's name who plays the character.
	 */
	public String getActor();

	/**
	 * Returns the cost per episode of the character.
	 * 
	 * @return the cost per episode of the character.
	 */
	public int getCostPerEpisode();
}
