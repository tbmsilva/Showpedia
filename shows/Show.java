/**
 * 
 */
package shows;

import episodes.Episode;

/**
 * @author tbmsilva
 *
 */
public interface Show {

	/**
	 * Returns the show name
	 * 
	 * @return the show name
	 */
	String getName();

	/**
	 * Returns the number of seasons of the show
	 * 
	 * @return the number of seasons of the show
	 */
	int getSeasonCount();

	/**
	 * Returns the number of episodes of the show
	 * 
	 * @return the number of seasons of the show
	 */
	int getEpisodeCount();

	/**
	 * Returns the number of episodes in a season
	 * 
	 * @param season - season to get episode count
	 * @return number of episodes in given season
	 */
	int getSeasonEpisodeCount(int season);

	/**
	 * Adds a new season to the show. The new season is added with a new serial
	 * number (the successor of the last season).
	 */
	void addSeason();

	/**
	 * Adds an episode to a season
	 * 
	 * @param e      - episode to be added
	 * @param season - season to add the episode to
	 */
	void addEpisode(Episode e, int season);
}
