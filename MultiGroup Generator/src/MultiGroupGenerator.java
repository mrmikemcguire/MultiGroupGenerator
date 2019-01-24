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
		printSecondGrouping();
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
		System.out.println("You have " + roster.size() + " students.\n");
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

		for (int i = 1; i <= numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + i);
			for(int j = 0; j < maxGroupSize; j++)
				{
				System.out.println(roster.get(counter).getName());	
				counter++;
				}
			System.out.println();
			}
		
		for (int i = 0; i < numberOfGroups - numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + (numberOfLargerGroups + i + 1));
			for(int j = 0; j < maxGroupSize - 1; j++)
				{
				System.out.println(roster.get(counter).getName());	
				counter++;
				}
			System.out.println();
			}	
		System.out.println();
		}
	
	public static void printSecondGrouping()
		{
		int counter = 0;
		System.out.println("Second Project\n");

		for (int i = 1; i <= numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + i);
			if (counter % 4 == 0)
				{
				for(int j = 0; j < maxGroupSize; j++)
					{
					System.out.println(roster.get(counter).getName());	
					if (counter < roster.size() - 4)
						{
						counter = counter + 4;
						}
					else
						{
						counter = 1;
						}
					}
				}
			System.out.println();
			}
		
		for (int i = 0; i < numberOfGroups - numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + (numberOfLargerGroups + i + 1));
			for(int j = 0; j < maxGroupSize - 1; j++)
				{
				if (counter % 4 == 0)
					{
					System.out.println(roster.get(counter).getName());	
					}
				counter++;
				}
			System.out.println();
			}	
		}
	}
	
