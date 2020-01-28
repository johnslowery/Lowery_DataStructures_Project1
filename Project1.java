import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Project1 {
	
	public static void main(String[] args) throws FileNotFoundException{
		parseFile();
		
		//This method checks the user input to make sure it is valid, and runs it again if it is not
		int testInput = 1;
		System.out.println("1. Print a countries report\r\n" + 
				"2. Sort by Name\r\n" + 
				"3. Sort by Happiness\r\n" + 
				"4. Sort by GDP per capita\r\n" + 
				"5. Find and print a given country\r\n" + 
				"6. Quit");
		
		Scanner input = new Scanner(System.in);
		int whichMethod = input.nextInt();
		//Switch case so user can input a number and sort the countries in whatever way they want
		while(testInput == 1) {
			switch(whichMethod) {
			case 1:
				countriesReport();
				testInput = 0;
				break;
			case 2:
				nameSort();
				testInput = 0;
				break;
			case 3:
				happySort();
				testInput = 0;
				break;
			case 4:
				gdpSort();
				testInput = 0;
				break;
			case 5:
				System.out.println("Which Country?");
				input = new Scanner(System.in);
				//conditional logic here to check if the country is real
				String whichCountry = input.nextLine();
				findCountry(whichCountry);
				break;
			case 6:
				quitProgram();
				testInput = 0;
				break;
			//If they do not input 1-6, it will default
			default:
				System.out.println("Invalid Option, Please Try Again!");
				input = new Scanner(System.in);
				whichMethod = input.nextInt();
				break;
				
			}
		}
	}
	
	public static void parseFile() throws FileNotFoundException {
		System.out.println("Please Enter the Name of a Valid CSV File to be Manipulated: ");
		Scanner input = new Scanner(System.in);
		String fileTest = input.nextLine();
		//Checks if the file is correct
		int check = 1;
		//Change this back to Countries1.csv later
		String tester = "j";
		while(check == 1) {
			if(fileTest.contentEquals(tester)) {
				check = 0;
			}else {
				System.out.println("Please try another file: ");
				fileTest = input.nextLine();
			}
		}
		//Finds file and puts it into a Country type array
			File countryInfo = new File("Countries1.csv");
			Scanner sc = new Scanner(countryInfo);
			int i = 1000000;
			sc.useDelimiter("\\n");
			//Make array length less stupid?
			String[] temp = new String[i];
			Country[] fileInfo = new Country[i];
			for(int x = 0; sc.hasNext(); x++) {
				temp[x] = sc.next();
				fileInfo[i] = new Country(temp, fileInfo);
				//Country country = new Country(temp, fileInfo);
				//fileInfo[x] = country;
				System.out.println(temp[x]);
				System.out.println();
				System.out.println(fileInfo[x]);
			}
			System.out.println();
		}
	
	public static void countriesReport() {
		
	}
		
	public static void nameSort() {
		
	}
	
	public static void happySort() {
		
	}
	
	public static void gdpSort() {
		
	}
	
	public static void findCountry(String x) {
		
	}
	
	public static void quitProgram() {
		
	}
}