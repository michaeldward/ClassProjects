let reverse s =
	let rec reversesub i =
		if i >= String.length s then "" else (reversesub (i+1))^(String.make 1 s.[i])
	in
		reversesub 0

let palindrome word = if reverse word = word then true else false