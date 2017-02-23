#!/usr/bin/perl
#PROBLEM 1: This script finds the nth prime number. Enter a negative number to quit.
#TESTED: 20,005th prime number: 224813
#Note: it took a while!
use strict;
use warnings;
use bignum;


print "Enter number: ";
my $u = <>;
while ($u != -1) {
	if ($u == 1) {
		print "2\n";
	}
	else {
		my $temp = 3;
		$u = $u - 2;
		while ($u > 0) {
			my $prime = 1;
			$temp = $temp + 2;
			for (my $i = $temp - 2; $i > 1; $i = $i - 2) {
				if ($temp % $i == 0) {
					$prime = 0;
				}
			}
			if ($prime == 1) {
				$u = $u - 1;
			}
		}
		print "$temp\n";
	}
	print "Enter number: ";
		$u = <>;
}