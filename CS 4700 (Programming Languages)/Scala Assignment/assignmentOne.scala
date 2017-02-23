class Person() {
    var firstName = ""
    var lastName = ""
    var age = 0
} 

var x = "yo"
var y = 5
var z = 3.14
var q = new Person()

println (x + x) //string + string
println (x + y) //string + int
println (x + z) //string + double
//print (x + q) //string + person
println (y + x) //int + string
println (y + y) //int + int
println (y + z) //int + double
//print (y + q) //int + person
println (z + x) //double + string
println (z + y) //double + int
println (z + z) //double + double
//print (z + q) //double + person
//print (q + x) //person + string
//print (q + y) //person + int
//print (q + z) //person + double
//print (q + q) //person + person

var a = "yo"
var b = 5
var c = 1.5
var d = new Person()

a = "yo" //assign string to string
b = "yo" //assign string to int
c = "yo" //assign string to double
d = "yo" //assign string to person

var e = "yo"
var f = 5
var g = 5.1
var h = new Person()

e = 5 //assign int to string
f = 5 //assign int to int
g = 5 //assign int to double
h = 5 //assign int to person

var i = "yo"
var j = 5
var k = 5.1
var l = new Person()

i = 5.1 //assign double to string
j = 5.1 //assign double to int
k = 5.1 //assign double to double
l = 5.1 //assign double to person

var m = "yo"
var n = 5
var o = 5.1
var p = new Person()
var q = new Person()

m = q //assign person to string
n = q //assing person to int
o = q //assign person to double
p = q //assign person to person
