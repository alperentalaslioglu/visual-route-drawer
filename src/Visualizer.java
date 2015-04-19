import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Visualizer {
	private static int[][] coordinates;
	private static int numberOfNodes;
	private static ArrayList[] routes;
	
	public static void main(String[] args) throws FileNotFoundException{
		routes = new ArrayList[3]; // Creating 3 empty routes		
		readCoordinates(new File("data.txt")); // Reading coordinates		
		//Creating sample routes
		
		ArrayList route1 = new ArrayList();
		route1.add(2);
		route1.add(22);
		route1.add(31);
		route1.add(7);
		route1.add(43);		
		routes[0] = route1;
		
		ArrayList route2 = new ArrayList();
		route2.add(1);
		route2.add(26);
		route2.add(41);
		route2.add(5);
		route2.add(38);		
		routes[1] = route2;
		
		
		ArrayList route3 = new ArrayList();
		route3.add(3);
		route3.add(19);
		route3.add(27);
		route3.add(8);
		route3.add(40);		
		routes[2] = route3;
		
		/*
		 * Structure of route :
		 * 
		 * route[0] = { 1 , 26 , 41 , 5 , 38 }
		 * A vehicle starts route from depot then
		 * firstly go node 1 then 26 then 41 then 5 then 38 
		 * at the end from 38 it comes back to depot. 
		 * 
		 * So route[0] means 0 -> 1 -> 26 -> 41 -> 5 -> 38 -> 0
		 * 
		 */
			
		//Draw GUI
		new MainFrame(routes, coordinates);		
	}

	private static void readCoordinates(File file) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(file);
		
		//Read number of nodes
		numberOfNodes = fileScanner.nextInt();
		
		//Creating coordinates array
		coordinates = new int[numberOfNodes][2];
		
		//Reading coordinates from file		
		//First coordinates is the depot's coordinates
		int itemIndex = 0;
		while (fileScanner.hasNextInt()) {
			// First getting the coordinates of current indexed item
			int x = fileScanner.nextInt();
			int y = fileScanner.nextInt();

			// Putting coordinates to array
			coordinates[itemIndex][0] = x;
			coordinates[itemIndex][1] = y;

			itemIndex++;
		}		
	}
}
