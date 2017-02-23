
public class MichaelsBugs {
	int a = 1;
	int b = 2;
	int c = -1;
	int d = a + b;
	float e = 0.5;
	d = d / e;
}
