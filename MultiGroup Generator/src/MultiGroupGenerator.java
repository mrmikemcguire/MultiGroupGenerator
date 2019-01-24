import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class MultiGroupGenerator
	{
	static int maxGroupSize;
	static int numberOfGroups;
	static int numberOfLargerGroups;
	static ArrayList <Student> roster = new ArrayList <Student>();

	public static void main(String[] args) throws IOException
		{
		fillArrayFromTextFile();
		//displayStudents();
		getNumberOfGroups();
		printFirstGrouping();
		}

	public static void fillArrayFromTextFile() throws FileNotFoundException
		{
		Scanner file = new Scanner(new File("roster.txt"));
		int counter = 1;
		while (file.hasNext())
			{
			roster.add(new Student(file.nextLine(), counter));
			counter++;
			}
		}
	public static void displayStudents()
		{
		for (Student s : roster)
			{
			System.out.println(s.getName() + " is #" + s.getRosterNumber());
			}
		}
	
	public static void getNumberOfGroups()
		{
		Scanner userInput = new Scanner(System.in);
		System.out.println("You have " + roster.size() + " students.");
		System.out.println("What is your maximum group size?");
		maxGroupSize = userInput.nextInt();
		numberOfGroups = (roster.size() / maxGroupSize) + 1;
		numberOfLargerGroups = roster.size() % numberOfGroups;
		System.out.println("You will have " + numberOfGroups + " groups,");
		System.out.println(numberOfLargerGroups + " groups of " +
				maxGroupSize + " and " + (numberOfGroups - numberOfLargerGroups) +
				" groups of " + (maxGroupSize - 1) + ".\n\n");
		}
	
	public static void printFirstGrouping()
		{
		int counter = 0;
		System.out.println("First Project\n");
		for (int i = 1; i < numberOfLargerGroups + maxGroupSize - 1; i++)
			{
			System.out.println("Group #" + i);
			for(int j = 1; j <= maxGroupSize; j++)
				{
				if(roster.get(counter).getRosterNumber() == j)
					{
					System.out.println(roster.get(j).getName());
					}	
				counter++;
				}
			System.out.println();
			}
		}
	}
