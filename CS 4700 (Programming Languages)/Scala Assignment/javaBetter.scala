case class Person(firstName:String, lastName:String)
var bob = new Person("Bob", "Jones")
bob.firstName = "Fred" //this throws an error

var fred = new Person("Fred", "Jones") //the only way to get around the error
//this is inefficient because there are now two instances of the Person class