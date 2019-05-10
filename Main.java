import java.util.Scanner;

import exceptions.NoShowSelectedException;
import wiki.*;

/**
 * 
 */

/**
 * @author tbmsilva & m.lami
 *
 */
public class Main {

	// Commands
	private static final String EXIT = "EXIT";
	private static final String HELP = "HELP";
	private static final String CURRENT_SHOW = "CURRENTSHOW";

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
		}
	}

	private static void executeCurrentShow(Wiki wiki) {
		try {
			System.out.println(wiki.currentShowInfo());
		} catch (NoShowSelectedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeHelp() {
		System.out.println(HELP_MENU);
	}

}
