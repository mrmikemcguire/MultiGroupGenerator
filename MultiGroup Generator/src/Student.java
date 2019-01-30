import java.util.ArrayList;

public class Student
	{
	private String name;
	private int rosterNumber;
	private ArrayList <Student> teammates;
	
	public Student (String n, int r, ArrayList <Student> t)
		{
		name = n;
		rosterNumber = r;
		teammates = t;
		}

	public String getName()
		{
			return name;
		}

	public void setName(String name)
		{
			this.name = name;
		}

	public int getRosterNumber()
		{
			return rosterNumber;
		}

	public void setRosterNumber(int rosterNumber)
		{
			this.rosterNumber = rosterNumber;
		}

	public ArrayList<Student> getTeammates()
		{
			return teammates;
		}

	public void setTeammates(ArrayList<Student> teammates)
		{
			this.teammates = teammates;
		}
	
	}

