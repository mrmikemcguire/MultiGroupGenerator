
public class Student
	{
	private String name;
	private int rosterNumber;
	
	public Student (String n, int r)
		{
		name = n;
		rosterNumber = r;
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
	}

