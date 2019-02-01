import java.util.ArrayList;

public class Student
	{
	private String firstName;
	private String lastName;
	private int prime;

	
	public Student (String fn, String ln, int p)
		{
		firstName = fn;
		lastName = ln;
		prime = p;
		}


	public String getFirstName()
		{
			return firstName;
		}


	public void setFirstName(String firstName)
		{
			this.firstName = firstName;
		}


	public String getLastName()
		{
			return lastName;
		}


	public void setLastName(String lastName)
		{
			this.lastName = lastName;
		}


	public int getPrime()
		{
			return prime;
		}


	public void setPrime(int prime)
		{
			this.prime = prime;
		}

	}

