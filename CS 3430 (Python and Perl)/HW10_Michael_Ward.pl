 #!/usr/bin/perl

 use warnings;
 use diagnostics;

 sub matrix_add {
 	#my $size = $#{$_[0]} + 1;
 	my $size = scalar @{ $_[0]};
 	#print $size;
 	my @final = ();
 	for (my $i = 0; $i < $size; ++$i) {
 		for (my $u = 0; $u < $size; ++$u) {
 			$final[$i][$u] = $_[0][$i][$u] + $_[1][$i][$u];
 		}
 	}
 	return @final;
}

 sub matrix_subtract {
 	my $size = $#{$_[0]} + 1;
 	#print $size;
 	my @final = ();
 	for (my $i = 0; $i < $size; ++$i) {
 		for (my $u = 0; $u < $size; ++$u) {
 			$final[$i][$u] = $_[0][$i][$u] - $_[1][$i][$u];
 		}
 	}
 	return @final;
 }

 ## print cells of a 2D matrix_subtract
 sub print_matrix {
 	foreach (@_) {
 		foreach (@{$_}) {
 			print "$_ ";
 		}
 		print "\n";
 	}
 }

#########
# TESTS #
#########

my @m2by2_1 = (
	[1,2],
	[4,5]
	);

my @m2by2_2 = (
	[10, 11],
	[13,14],
	);

my @m3by3_1 = (
	[1, 2, 3],
	[4, 5, 6],
	[7, 8, 9]
	);

my @m3by3_2 = (
	[10, 11, 12],
	[13, 14, 15],
	[16, 17, 18]
	);

my @m4by4_1 = (
	[1, 2, 3, 4],
	[5, 6, 7, 8],
	[9, 10, 11, 12],
	[13, 14, 15, 16],
	);

my @m4by4_2 = (
	[10, 11, 12, 13],
	[14, 15, 16, 17],
	[18, 19, 20, 21],
	[22, 23, 24, 25],
	);

print "Matrix Addition Results:\n\n";
my @add_m2by2 = matrix_add(\@m2by2_1, \@m2by2_2);
my @add_m3by3 = matrix_add(\@m3by3_1, \@m3by3_2);
my @add_m4by4 = matrix_add(\@m4by4_1, \@m4by4_2);

print_matrix(@add_m2by2); print "\n";
print_matrix(@add_m3by3); print "\n";
print_matrix(@add_m4by4); print "\n";

print "Matrix Subtraction Results:\n\n";
my @subt_m2by2 = matrix_subtract(\@m2by2_2, \@m2by2_1);
my @subt_m3by3 = matrix_subtract(\@m3by3_2, \@m3by3_1);
my @subt_m4by4 = matrix_subtract(\@m4by4_2, \@m4by4_1);

print_matrix(@subt_m2by2); print "\n";
print_matrix(@subt_m3by3); print "\n";
print_matrix(@subt_m4by4); print "\n";
