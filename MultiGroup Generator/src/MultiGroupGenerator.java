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
	static int positionNumber;
	static ArrayList <Student> roster = new ArrayList <Student>();
	static ArrayList <Student> teammates = new ArrayList <Student>();

	public static void main(String[] args) throws IOException
		{
		fillArrayFromTextFile();
		getNumberOfGroups();
		addTeammates();
		displayStudents();
		//printFirstGrouping();
		//printSecondGrouping();
		}

	public static void fillArrayFromTextFile() throws FileNotFoundException
		{
		Scanner file = new Scanner(new File("roster.txt"));
		int counter = 1;
		while (file.hasNext())
			{
			roster.add(new Student(file.nextLine(), counter, null));
			counter++;
			}
		}
	
	public static void displayStudents()
		{
		for (Student s : roster)
			{
			System.out.println(s.getName() + "   " + s.getTeammates());
			}
		System.out.println();
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
	
	public static void addTeammates()
		{
		int index = 0;
		for (int i = 0; i < roster.size(); i++)
			{
			for (int j = 0; j < numberOfLargerGroups; j++)
				{
				for (int k = 0; k < maxGroupSize; k ++)
					{
					roster.get(index).setTeammates((roster.get(2)));
					}

				}
			for (int l = 0; l < numberOfGroups - numberOfLargerGroups; l++)
				{
				for (int k = 0; k < maxGroupSize - 1; k ++)
					{
						
					}
				}
			}
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
		System.out.println("Second Project\n");

		for (int i = 1; i <= numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + i);
			positionNumber = i - 1;

			for(int j = 0; j < maxGroupSize; j++)
				{
				if (positionNumber < roster.size())
					{	
					System.out.println(roster.get(positionNumber).getName());
					}
				else
					{
					positionNumber = 0;
					}
				positionNumber += 4;
				}
			System.out.println();
			}

		
		for (int i = 0; i < numberOfGroups - numberOfLargerGroups; i++)
			{
			positionNumber = (numberOfLargerGroups + i);
			System.out.println("Group #" + (numberOfLargerGroups + i + 1));
			for(int j = 0; j < maxGroupSize - 1; j++)
				{
				if (positionNumber < roster.size())
					{	
					System.out.println(roster.get(positionNumber).getName());
					}
				else
					{
					positionNumber = 0;
					}
				positionNumber += 4;
				}
			System.out.println();
			}	
		}
	}
	
