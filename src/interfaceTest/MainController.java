/**
 * @file MainController.java
 * @authors Leah Talkov, Jerry Tsui
 * @date 8/15/2016
 * Contains the main function for the program, and brings up the main menu. 
 * This program allows users to input log files, and finds errors within
 * the files for the user. The timestamp, Ucode, the error message, and 
 * a suggested solution are displayed on the screen. If the user is an
 * admin, then the user can also modify, delete, or add entries into the
 * file that contains information on the various errors that the program
 * searches for. 
 */

package interfaceTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.EventQueue;


public class MainController {
	static String[] inputArray;
	

	public static void main(String[] args)throws IOException
	{	
		


	
	
	//Arguments are given the program is being run from the command line		
	if(args.length != 0){	
	Scanner scanner = new Scanner(System.in);
		
		System.out.println("# ------------------------------------ #");
		System.out.println("#               LogReader              #");
		System.out.println("# ------------------------------------ #");
		System.out.println("# ------------------------------------ #");
		System.out.println("\n\n");
		
	
		
		//List of valid Products and Groups 
		ArrayList<String> validGroups = new ArrayList<String>();
		ArrayList<String> validProducts = new ArrayList<String>();
		validProducts.add("AutomationEngine");
		validProducts.add("DollarUniverse");
		validProducts.add("ApplicationManager");
		
		
		
		//User enters arguments manually 		
		
		inputArray = new String[2];
		String softwareProduct;
		
		
		//Verify Path 
		String filePathString = args[0];
		boolean validPath=false;
		while(!validPath){
		File f = new File(filePathString);
		if(f.exists() && !f.isDirectory() && (filePathString.contains(".txt") || filePathString.contains(".log"))) { 
			inputArray[0] = args[0];
			validPath=true;
		}
		}
	
			
	
		//Verify SoftwareProduct
		boolean isValidSoftwareProduct=false;
		softwareProduct = args[1];	
		while(!isValidSoftwareProduct){
			if(!validProducts.contains(softwareProduct)){
				
			System.out.println(softwareProduct + " is an invalid Software Product.");
			System.out.println("The available choices are:");
			for(String element :validProducts)
				System.out.println(element);
			System.out.println("Please enter the Software Product");
				softwareProduct = scanner.next();		
			}
			else{
				isValidSoftwareProduct=true;
			}
		}
		inputArray[1] = softwareProduct;				
			
		/*
		//Verify Groups
		String groups=args[1];
	
		if(groups.equals("NoGroup"))
		{
			
			inputArray[1]="NoGroup";
		}
		*/
		
	}
	
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					MainMenu mainMenu = new MainMenu(inputArray);
					
					if(inputArray==null){
					mainMenu.setVisible(true);
					}
					else{
						mainMenu.setVisible(false);
					}
				} 
				catch (Exception e) {
					e.printStackTrace();
					}
			}
		}
		);	
		
	}
	
}
