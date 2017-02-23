class Person() {
    var firstName = ""
    var lastName = ""
    var age = 0
}

def function_one(a:String): String = {
	return a
}

def function_two(b:Int): Int = {
	return b
}

def function_three(c:Double): Double = {
	return c
}

def function_four(d:Person): Person = {
	return d
}

println(function_one("shrek is love")) //give string, expect string --works!
println(function_two("shrek is life")) //give string, expect int
println(function_three("shrek is weird")) //give string, expect double
println(function_four("this is boring")) //give string, expect person

println(function_one(5)) //give int, expect string
println(function_two(5)) //give int, expect int --works!
println(function_three(5)) //give int, expect double --works!
println(function_four(5)) //give int, expect person

println(function_one(3.14)) //give double, expect string
println(function_two(3.14)) //give double, expect int
println(function_three(3.14)) //give double, expect double --works!
println(function_four(3.14)) //give double, expect person

println(function_one(new Person())) //give person, expect string
println(function_two(new Person())) //give person, expect int
println(function_three(new Person())) //give person, expect double
println(function_four(new Person())) //give person, expect person --works!