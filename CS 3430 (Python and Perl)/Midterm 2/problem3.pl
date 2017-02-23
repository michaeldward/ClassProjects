#!/usr/bin/perl
#PROBLEM 3: This scipt prints a triangle pattern with a height specified by the user. Enter a negative number to quit
use strict;
use warnings;

print "Enter number: ";
my $u = <>;

while ($u > 0) {
	my $dots = "*";
	while ($u > 0) {
		my $str = $dots;
		for (my $i = 0; $i < $u - 1; ++$i) {
			$str = " " . $str;
		}
		print "$str\n";
		$dots = $dots . "**";
		$u = $u - 1;
	}
	print "Enter number: ";
	$u = <>;
}