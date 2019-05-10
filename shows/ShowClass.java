/**
 * 
 */
package shows;

/**
 * @author tbmsilva
 *
 */
public class ShowClass implements Show {
	
	private static final int STARTING_COUNT = 1;
	
	private String name;
	private int episodeCount, seasonCount;

	public ShowClass(String name) {
		episodeCount = STARTING_COUNT;
		seasonCount = STARTING_COUNT;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public int getSeasonCount() {
		return seasonCount;
	}
	
	
}
