import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import exceptions.*;

import wiki.*;

/**
 * @author tbmsilva & m.lami
 *
 */
public class Main {

	// Commands
	private static final String EXIT = "EXIT";
	private static final String HELP = "HELP";
	private static final String CURRENT_SHOW = "CURRENTSHOW";
	private static final String ADD_SHOW = "ADDSHOW";
	private static final String SWITCH_TO_SHOW = "SWITCHTOSHOW";
	private static final String ADD_SEASON = "ADDSEASON";
	private static final String ADD_EPISODE = "ADDEPISODE";
	private static final String ADD_CHARACTER = "ADDCHARACTER";
	private static final String ADD_RELATIONSHIP = "ADDRELATIONSHIP";
	private static final String ADD_ROMANCE = "ADDROMANCE";
	private static final String ADD_EVENT = "ADDEVENT";

	// Messages
	private static final String EXIT_MESSAGE = "Bye!";
	private static final String HELP_MENU = "currentShow - show the current show\n" + "addShow - add a new show\n"
			+ "switchToShow - change the context to a particular show\n"
			+ "addSeason - add a new season to the current show\n"
			+ "addEpisode - add a new episode to a particular season of the current show\n"
			+ "addCharacter - add a new character to a show\n"
			+ "addRelationship - add a family relationship between characters\n"
			+ "addRomance - add a romantic relationship between characters\n"
			+ "addEvent - add a significant event involving at least one character\n"
			+ "addQuote - add a new quote to a character\n"
			+ "seasonsOutline - outline the contents of the selected seasons for the selected show\n"
			+ "characterResume - outline the main information on a specific character\n"
			+ "howAreTheseTwoRelated - find out if and how two characters may be related\n"
			+ "famousQuotes - find out which character(s) said a particular quote\n"
			+ "alsoAppearsOn - which other shows and roles is the same actor on?\n"
			+ "mostRomantic - find out who is at least as romantic as X\n"
			+ "kingOfCGI - find out which company has earned more revenue with their CGI virtual actors\n"
			+ "help - shows the available commands\n" + "exit - terminates the execution of the program";
	private static final String ERROR = "ERRO";
	private static final String CURRENT_SHOW_INFO = "%s. Seasons: %d Episodes: %d\n";
	private static final String ADD_EPISODE_FORMAT = "%s S%d, Ep%d: %s\n";
	private static final String ADD_REAL_CHARACTER_FORMAT = "%s is now part of %s. This is %s role %d.\n";
	private static final String ADD_VIRTUAL_CHARACTER_FORMAT = "%s is now part of %s. This is a virtual actor.\n";
	private static final String ADD_RELATIONSHIP_FORMAT = "%s has now %d kids. %s has now %d parents.\n";
	private static final String ADD_ROMANCE_FORMAT = "%s and %s are now a couple.";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Wiki wiki = new WikiClass();
		String option = readOption(in);
		while (!option.equals(EXIT)) {
			executeOption(option, in, wiki);
			option = readOption(in);
		}
		executeOption(option, in, wiki);
		in.close();
	}

	private static String readOption(Scanner in) {
		return in.nextLine().trim().toUpperCase();
	}

	private static void executeOption(String option, Scanner in, Wiki wiki) {
		switch (option) {
		case EXIT:
			System.out.println(EXIT_MESSAGE);
			break;
		case HELP:
			executeHelp();
			break;
		case CURRENT_SHOW:
			executeCurrentShow(wiki);
			break;
		case ADD_SHOW:
			executeAddShow(in, wiki);
			break;
		case SWITCH_TO_SHOW:
			executeSwitchToShow(in, wiki);
			break;
		case ADD_SEASON:
			executeAddSeason(wiki);
			break;
		case ADD_EPISODE:
			executeAddEpisode(in, wiki);
			break;
		case ADD_CHARACTER:
			executeAddCharacter(in, wiki);
			break;
		case ADD_RELATIONSHIP:
			executeAddRelationship(in, wiki);
			break;
		case ADD_ROMANCE:
			executeAddRomance(in, wiki);
			break;
		case ADD_EVENT:
			executeAddEvent(in, wiki);
			break;
		default:
			System.out.println(ERROR);
		}
	}

	private static void executeAddEvent(Scanner in, Wiki wiki) {
		String description = in.nextLine();
		int season = in.nextInt();
		int episode = in.nextInt();
		int totalCharacters = in.nextInt();
		in.nextLine();
		List<String> characters = new LinkedList<>();
		for (int i = 0; i < totalCharacters; i++)
			characters.add(in.nextLine());
		try {
			wiki.addEvent(description, season, episode, totalCharacters, characters);
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		} catch (InvalidSeasonException e) {
			System.out.println(e.getMessage());
		} catch (InvalidEpisodeException e) {
			System.out.println(e.getMessage());
		} catch (UnknownCharacterException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateCharacterException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeAddRomance(Scanner in, Wiki wiki) {
		String character1 = in.nextLine().trim();
		String character2 = in.nextLine().trim();
		try {
			wiki.addRomance(character1, character2);
			System.out.printf(ADD_ROMANCE_FORMAT, character1, character2);
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		} catch (SameCharacterRomanceException e) {
			System.out.println(e.getMessage());
		} catch (UnknownCharacterException e) {
			System.out.println(e.getMessage());
		} catch (RepeatedRelationshipException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void executeAddRelationship(Scanner in, Wiki wiki) {
		String parentName = in.nextLine().trim();
		String kidName = in.nextLine().trim();
		try {
			wiki.addRelationship(parentName, kidName);
			System.out.printf(ADD_RELATIONSHIP_FORMAT, parentName, wiki.getKidCount(parentName), kidName,
					wiki.getParentCount(kidName));
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		} catch (InvalidRelationshipException e) {
			System.out.println(e.getMessage());
		} catch (UnknownCharacterException e) {
			System.out.println(e.getMessage());
		} catch (RepeatedRelationshipException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeAddCharacter(Scanner in, Wiki wiki) {
		String category = in.nextLine().trim().toUpperCase();
		String characterName = in.nextLine().trim();
		String actorOrCompanyName = in.nextLine().trim();
		int cost = in.nextInt();
		in.nextLine();
		try {
			wiki.addCharacter(category, characterName, actorOrCompanyName, cost);
			if (category.equalsIgnoreCase("real")) {
				System.out.printf(ADD_REAL_CHARACTER_FORMAT, characterName, wiki.getCurrentShow().getName(),
						actorOrCompanyName, wiki.getActorRoleCount(actorOrCompanyName));
			} else
				System.out.printf(ADD_VIRTUAL_CHARACTER_FORMAT, characterName, wiki.getCurrentShow().getName());
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		} catch (UnknownActorCategoryException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateCharacterException e) {
			System.out.println(e.getMessage());
		} catch (InvalidActorFeeException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeAddEpisode(Scanner in, Wiki wiki) {
		try {
			int season = in.nextInt();
			String name = in.nextLine().trim();
			wiki.addEpisode(season, name);
			System.out.printf(ADD_EPISODE_FORMAT, wiki.getCurrentShow().getName(), season,
					wiki.getCurrentShow().getEpisodeCount(), name);
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		} catch (UnknownSeasonException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeAddSeason(Wiki wiki) {
		try {
			wiki.addSeason();
			System.out.printf(CURRENT_SHOW_INFO, wiki.getCurrentShow().getName(),
					wiki.getCurrentShow().getSeasonCount(), wiki.getCurrentShow().getEpisodeCount());
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeSwitchToShow(Scanner in, Wiki wiki) {
		try {
			String name = in.nextLine().trim();
			wiki.switchToShow(name);
			System.out.printf(CURRENT_SHOW_INFO, wiki.getCurrentShow().getName(),
					wiki.getCurrentShow().getSeasonCount(), wiki.getCurrentShow().getEpisodeCount());
		} catch (UnknownShowException e) {
			System.out.println(e.getMessage());
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeAddShow(Scanner in, Wiki wiki) {
		try {
			String name = in.nextLine().trim();
			wiki.addShow(name);
			System.out.println(name + " created.");
		} catch (ShowAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeCurrentShow(Wiki wiki) {
		try {
			System.out.printf(CURRENT_SHOW_INFO, wiki.getCurrentShow().getName(),
					wiki.getCurrentShow().getSeasonCount(), wiki.getCurrentShow().getEpisodeCount());
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeHelp() {
		System.out.println(HELP_MENU);
	}

}
