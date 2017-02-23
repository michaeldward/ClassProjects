class Cheese
	@@aged = false
	def aged
		@@aged
	end
end

class Duck
	@@aged = 15
	def aged
		@@aged
	end
end

def printAgePlusFive(yo)
	puts (yo.aged + 5)
end

#This first line will work since aged is an int
printAgePlusFive(Duck.new)
#This line will not work since the method expects an int, but aged is a bool in Cheese
printAgePlusFive(Cheese.new)