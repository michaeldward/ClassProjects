import java.lang.System;
public class MichaelBugsFixed {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int d = a + b;
		System.out.print(d);
	}
}
