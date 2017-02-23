#!/usr/bin/perl
#PROBLEM 2: This script determines if a number is a palindrome. Enter a negative number to quit
use strict;
use warnings;

print "Enter number: ";
chomp(my $u = <>);
while ($u != -1) {
	if ($u eq reverse($u)) {
		print "Palindrome!\n";
	}
	else {
		print "Not palindrome!\n";
	}
	print "Enter number: ";
	chomp($u = <>);
}