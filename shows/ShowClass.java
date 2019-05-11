/**
 * 
 */
package shows;

import java.util.ArrayList;
import java.util.HashMap;

import episodes.Episode;

/**
 * @author tbmsilva
 *
 */
public class ShowClass implements Show {

	private String name;
	private HashMap<Integer, ArrayList<Episode>> seasons;

	public ShowClass(String name) {
		seasons = new HashMap<>();
		ArrayList<Episode> a = new ArrayList<Episode>();
		a.add(null);
		seasons.put(1, a);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getEpisodeCount() {
		int episodeCount = 0;
		for (int i = 1; i <= seasons.size(); i++) {
			episodeCount += seasons.get(i).size();
		}
		return episodeCount;
	}

	public int getSeasonCount() {
		return seasons.size();
	}

	public int getSeasonEpisodeCount(int season) {
		return seasons.get(season).size();
	}

	public void addSeason() {
		seasons.put(seasons.size() + 1, new ArrayList<Episode>());
	}

	public void addEpisode(Episode e, int season) {
		if (season == 1 && seasons.get(1).remove(null)) // Se a season for 1 E se a remocao de um null acontecer (quer
														// dizer que e o episodio temporario)
			seasons.get(season).add(e);
		else
			seasons.get(season).add(e);
	}

}
