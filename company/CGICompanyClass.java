package company;

import java.util.*;

import characters.*;

/**
 * @author tbmsilva & m.lami
 *
 */
public class CGICompanyClass implements CGICompany {
	
	private String name;
	private List<CGI> characters;
	private int profit;

	public CGICompanyClass(String name) {
		this.name = name;
		characters = new ArrayList<>();
		profit = 0;
	}
	
	public String getName() {
		return name;
	}

	public void addCharacter(CGI character) {
		characters.add(character);
	}
	
	
	public Iterator<CGI> getCharacters() {
		return characters.iterator();
	}
	
	public void setProfit(int profit) {
		this.profit = profit;
	}
	
	public int profit() {
		return profit;
	}
}
