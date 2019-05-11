/**
 * 
 */
package episodes;

/**
 * @author tbmsilva
 *
 */
public class EpisodeClass implements Episode {
	
	private String name;
	
	public EpisodeClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
