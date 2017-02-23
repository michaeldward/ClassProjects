class Person() {
    var firstName = ""
    var lastName = ""
    var age = 0
}

var x = "yo"
var y = 5
var z = 3.14
var q = new Person()

println (x + x) //string + string //prints string (yoyo)
println (x + y) //string + int //prints string (yo5)
println (x + z) //string + double //prints string (yo3.14)
//println (x + q) //string + person //error
println (y + x) //int + string //prints string (5yo)
println (y + y) //int + int //prints int (10)
println (y + z) //int + double //prints double (8.14)
//println (y + q) //int + person //error
println (z + x) //double + string //prints string (3.14yo)
println (z + y) //double + int //prints double (8.14)
println (z + z) //double + double //prints double (6.28)
//println (z + q) //double + person //error
//println (q + x) //person + string //error
//println (q + y) //person + int //error
//println (q + z) //person + double //error
//println (q + q) //person + person //error