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
//		displayStudents();
		printFirstGrouping();
//		printNextGrouping();
		findNextGrouping();
		System.out.println("end");
		}

	private static void findNextGrouping() 
	{
		Collections.shuffle(roster);
		boolean fail = true;
		while(fail)
		{
			int counter = 0;
			boolean pauseRedo = false;
			for (int i = 1; i <= numberOfLargerGroups; i++)
				{
				for(int j = 0; j < maxGroupSize; j++)
					{
					int tempSizeOfGroup = maxGroupSize - j;
					for(int m =1; m < tempSizeOfGroup; m++)
						{
						if (!products.contains(roster.get(counter).getPrime() * roster.get(counter + m).getPrime()))
							{
							tempProducts.add(roster.get(counter).getPrime() * roster.get(counter + m).getPrime());
							}
						else
							{
							tempProducts.clear();
							tempRoster.clear();
							pauseRedo = true;
							attemptCounter++;
							System.out.println("Fail! Attempt # " + attemptCounter);
							continue;
							}
						}
					
					if(pauseRedo = true)
					{
						continue;
					}
					tempRoster.add(roster.get(counter));
					counter++;
					}
				if(pauseRedo = true)
				{
					continue;
				}
				}
//			if(pauseRedo = true)
//			{
//				continue;
//			}
			if(pauseRedo = false)
			{
				for (int i = 0; i < numberOfGroups - numberOfLargerGroups; i++)
				{
				for(int j = 0; j < maxGroupSize - 1; j++)
					{
					int tempSizeOfGroup = maxGroupSize - j;
					for(int m =1; m < tempSizeOfGroup; m++)
						{
						if (!products.contains(roster.get(counter).getPrime() * roster.get(counter + m).getPrime()))
							{
							tempProducts.add(roster.get(counter).getPrime() * roster.get(counter + m).getPrime());
							}
						else
							{
							tempProducts.clear();
							tempRoster.clear();
							pauseRedo = true;
							attemptCounter++;
							System.out.println("Fail! Attempt # " + attemptCounter);
							continue;
							}
						}
					if(pauseRedo = true)
					{
						continue;
					}
					tempRoster.add(roster.get(counter));
					counter++;
					}
				if(pauseRedo = true)
				{
					continue;
				}
				}	
			}
			
			if (tempProducts.size() == products.size())
				{
				for (Integer i : tempProducts)
					{
						products.add(i);
					}
				printNextGrouping();
				fail = false;
				}
		}
		
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
		tempRoster = roster;
		int counter = 0;
		System.out.println("Next Project\n");

		for (int i = 1; i <= numberOfLargerGroups; i++)
			{
			System.out.println("Group #" + i);

			for(int j = 0; j < maxGroupSize; j++)
				{
				System.out.println(tempRoster.get(counter).getLastName());
				for(int m = j + 1; m < maxGroupSize; m++)
					{
					products.add(tempRoster.get(counter).getPrime() * tempRoster.get(m).getPrime());
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
				System.out.println(tempRoster.get(counter).getLastName());	
				for(int m = j + 1; m < maxGroupSize; m++)
					{
					products.add(tempRoster.get(counter).getPrime() * tempRoster.get(m).getPrime());
					}
				counter++;
				}
			System.out.println();
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
	
