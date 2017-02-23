public class Person2
{
	private  String firstName;
  	private  String lastName;
	public Person2(String newFirst, String newLast)
	{
		firstName = newFirst;
		lastName = newLast;
	}
  	String getFirstName() { return firstName; }
  	void setFirstName(String firstName) { this.firstName = firstName; }
  	String getLastName() { return  lastName; }
  	void setLastName(String lastName) { this.lastName = lastName; }
}