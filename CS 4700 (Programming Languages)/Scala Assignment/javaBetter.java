public class Person
{
	private  String firstName;
  	private  String lastName;
	public Person(String newFirst, String newLast)
	{
		firstName = newFirst;
		lastName = newLast;
	}
  	String getFirstName() { return firstName; }
  	void setFirstName(String firstName) { this.firstName = firstName; }
  	String getLastName() { return  lastName; }
  	void setLastName(String lastName) { this.lastName = lastName; }
}

public static void main(String[] args)
{
	Person bob = new Person("Bob", "Jones");
	bob.firstName = "Fred";
}