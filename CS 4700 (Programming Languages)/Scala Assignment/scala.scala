class Person() {
    var firstName = ""
    var lastName = ""
    var age = 0
}

var x = "yo"
var y = 5
var z = 3.14
var q = new Person()

println (x + x)
println (x + y)
println (x + z)
print (x + q)
println (y + x)
println (y + y)
println (y + z)
print (y + q)
println (z + x)
println (z + y)
println (z + z)
print (z + q)
print (q + x)
print (q + y)
print (q + z)
print (q + q)

var x = 51324713204731287481237491723
println(x)


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

println(function_one("shrek is love"))
println(function_two("shrek is life"))
println(function_three("shrek is weird"))
println(function_four("this is boring"))
println(function_one(5))
println(function_two(5))
println(function_three(5))
println(function_four(5))
println(function_one(3.14))
println(function_two(3.14))
println(function_three(3.14))
println(function_four(3.14))
println(function_one(new Person()))
println(function_two(new Person()))
println(function_three(new Person()))
println(function_four(new Person()))