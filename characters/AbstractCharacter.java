/**
 * 
 */
package characters;

/**
 * @author tbmsilva
 *
 */
public abstract class AbstractCharacter implements ShowCharacter {

	protected String name;

	public AbstractCharacter(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
