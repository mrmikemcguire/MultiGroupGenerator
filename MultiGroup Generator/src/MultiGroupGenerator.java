import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiGroupGenerator
	{
	static int maxGroupSize;
	static int numberOfGroups;
	static int numberOfLargerGroups;
	static int positionNumber;
	static ArrayList <Student> roster = new ArrayList <Student>();
	static ArrayList <Student> tempRoster = new ArrayList <Student>();
	static ArrayList<Integer> products = new ArrayList <Integer>();
	static ArrayList<Integer> tempProducts = new ArrayList <Integer>();
	static boolean workingSoFar = true;
	static int attemptCounter = 1;

	public static void main(String[] args) throws IOException
		{
		fillArrayFromTextFile();
		getNumberOfGroups();
		//displayStudents();
		printFirstGrouping();
		printNextGrouping();
		}

	public static void fillArrayFromTextFile() throws FileNotFoundException
		{
		Scanner file = new Scanner(new File("roster.txt"));
		while (file.hasNext())
			{
			roster.add(new Student(file.next(), file.next(), file.nextInt()));
			}
		}
	
	public static void displayStudents()
		{
		for (Student s : roster)
			{
			System.out.println(s.getFirstName() + " " + s.getLastName() + "  "  + s.getPrime());
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
	
	public static void printFirstGrouping()
		{
		int counter = 0;
		System.out.println("First Project\n");

		for (int i = 1; i <= numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + i);

			for(int j = 0; j < maxGroupSize; j++)
				{
				System.out.println(roster.get(counter).getLastName());
				for(int m = j + 1; m < maxGroupSize; m++)
					{
					products.add(roster.get(counter).getPrime() * roster.get(m).getPrime());
					}
				
				counter++;
				}
			System.out.println();
			}
		
		for (int i = 0; i < numberOfGroups - numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + (numberOfLargerGroups + i + 1));
			for(int j = 0; j < maxGroupSize - 1; j++)
				{
				System.out.println(roster.get(counter).getLastName());	
				for(int m = j + 1; m < maxGroupSize; m++)
					{
					products.add(roster.get(counter).getPrime() * roster.get(m).getPrime());
					}
				counter++;
				}
			System.out.println();
			}	
		System.out.println();
		}
	
	public static void printNextGrouping()
		{
		int counter = 0;
		System.out.println("First Project\n");

		for (int i = 1; i <= numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + i);

			for(int j = 0; j < maxGroupSize; j++)
				{
				System.out.println(roster.get(counter).getPrime());	

				for(int m = j + 1; m < maxGroupSize; m++)
					{
					if (!products.contains(roster.get(counter).getPrime() * roster.get(m).getPrime()))
						{
						tempProducts.add(roster.get(counter).getPrime() * roster.get(m).getPrime());
						tempRoster.add(roster.get(counter));
						}
					else
						{
						tempProducts.clear();
						tempRoster.clear();
						reshuffle();
						}
					}
				
				counter++;
				}
			System.out.println();
			}
		
		for (int i = 0; i < numberOfGroups - numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + (numberOfLargerGroups + i + 1));
			for(int j = 0; j < maxGroupSize - 1; j++)
				{
				System.out.println(roster.get(counter).getPrime());	
				for(int m = j + 1; m < maxGroupSize; m++)
					{
					if (!products.contains(roster.get(counter).getPrime() * roster.get(m).getPrime()))
						{
						tempProducts.add(roster.get(counter).getPrime() * roster.get(m).getPrime());
						tempRoster.add(roster.get(counter));
						}
					else
						{
						tempProducts.clear();
						tempRoster.clear();
						reshuffle();
						}
					}
				counter++;
				}
			System.out.println();
			}	
		if (tempProducts.size() == products.size())
			{
			for (Integer i : tempProducts)
				{
					products.add(i);
				}
			}
		System.out.println();
		}
	
	private static void reshuffle()
		{
		Collections.shuffle(roster);
		System.out.println();
		System.out.println("Attempt # " + attemptCounter);
		System.out.println();
		attemptCounter++;
		//testProducts();
		printNextGrouping();
		}

	public static void testProducts()
	{
		for(Integer i : products)
			{
				System.out.println(i);
			}
	}
	
	
		
	}
	
