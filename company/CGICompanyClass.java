package company;

import java.util.*;

import characters.CGI;

/**
 * @author tbmsilva & m.lami
 *
 */
public class CGICompanyClass implements CGICompany {
	
	private String name;
	private List<CGI> characters;

	public CGICompanyClass(String name) {
		this.name = name;
		characters = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void addCharacter(CGI character) {
		characters.add(character);
	}
}
