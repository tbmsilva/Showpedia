package event;

public class EventClass implements Event {

	private String description;
	private int season, episode;

	public EventClass(String description, int season, int episode) {
		this.description = description;
		this.season = season;
		this.episode = episode;
	}

	public String description() {
		return description;
	}

	public int season() {
		return season;
	}

	public int episode() {
		return episode;
	}

}
