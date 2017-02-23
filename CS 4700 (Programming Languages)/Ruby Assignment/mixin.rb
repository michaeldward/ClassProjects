module Debug
	def who_am_i?
		"#{self.class.name}" +
		"(\##{self.object_id}): #{self.to_s}"
	end
end

class Employee
	include Debug
end
class Manager < Employee
	include Debug
end
emp = Employee.new()
mgr = Manager.new()

puts "\n\nWho are they?"
puts emp.who_am_i?
puts mgr.who_am_i?