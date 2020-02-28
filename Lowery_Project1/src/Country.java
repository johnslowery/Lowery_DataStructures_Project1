/**
 * The Country class is mainly used to assist the Project1 class. Country has all the getters and setters for each different country field
 * (Name, Code, Capitol, Population, GDP, and Happiness Rank), as well as a constructor in order to make and use Country type objects
 * and arrays. It also has a method to compare two Country objects and print a Country object.
 * 
 * @author John Lowery
 * @version 1/31/2020 
 */

import java.util.Scanner;

public class Country {

	static String name;
	static String code;
	static String capitol;
	static String pop;
	static String gdp;
	static String happy;

	/**
	 * The Country constructor allows fileParse to run the various elements of the CVS file into it so they can be put into a Country type array
	 */
	
	public Country() {}
	
	/**
	 * getName is the getter for country Names
	 */
	
	public static String getName() {
		return name;
	}
	
	/**
	 * setName is the setter for country Names
	 * 
	 * @param newName: helps to set name
	 */
	
	public static void setName(String newName) {
		name = newName;
	}
	
	/**
	 * getCode is the getter for country Codes
	 */
	
	public static String getCode() {
		return code;
	}
	
	/**
	 * setCode is the setter for country Codes
	 * 
	 * @param newCode: helps to set code
	 */
	
	public static void setCode(String newCode) {
		code = newCode;
	}
	
	/**
	 * getCapitol is the getter for country Capitols
	 */
	
	public static String getCapitol() {
		return capitol;
	}
	
	/**
	 * setCapitol is the setter for country Capitols
	 * 
	 * @param newCapitol: helps to set capitol
	 */
	
	public static void setCapitol(String newCapitol) {
		capitol = newCapitol;
	}
	
	/**
	 * getPop is the getter for country Populations
	 */
	
	public static String getPop() {
		return pop;
	}
	
	/**
	 * setPop is the setter for country Populations
	 * 
	 * @param newPop: helps to set pop
	 */
	
	public static void setPop(String newPop) {
		pop = newPop;
	}
	
	/**
	 * getGDP is the getter for country GDP's
	 */
	
	public static String getGDP() {
		return gdp;
	}
	
	/**
	 * setGDP is the setter for country GDP's
	 * 
	 * @param newGDP: helps to set gdp
	 */
	
	public static void setGDP(String newGDP) {
		gdp = newGDP;
	}
	
	/**
	 * getHapp is the getter for country Happiness Ranks
	 */
	
	public static String getHapp() {
		return happy;
	}
	
	/**
	 * setHapp is the setter for country Happiness Ranks
	 * 
	 * @param newHappy: helps to set happy
	 */
	
	public static void setHapp(String newHappy) {
		happy = newHappy;
	}
	
	/*
	 * compareName compares two given Country objects by name
	 * 
	 * @param x: first country object to be compared
	 * @param y: second country object to be compared
	 */
	
	public static void compareName(Country x, Country y) {
		int compare = x.getName().compareTo(y.getName());
		if(compare == 0) {
			System.out.println("They are the same");
		}else {
			System.out.println("They are different");
		}
	}
	
	/*
	 * printCountry prints a specified Country object
	 * 
	 * @param x: the Country object that gets printed
	 */
	
	public static void printCountry(Country x) {
		System.out.println(x);
	}
}