
public aspect Lab {
	private int totalPublic = 0;
	private int totalPrivate = 0;
	private int totalProtected = 0;
	private int totalPackage = 0;
	private int totalStatic = 0;
	private int totalNonStatic = 0;
	private int totalMethods = 0;
	private int sexybodies = 0;
	pointcut allMethodBodies():
		(execution(* *.*(..)) || execution(*.new(..))) && !within(Lab);
	pointcut mainBody():
		(execution(public static void main(String[]))) && !within(Lab);

	before():
		allMethodBodies() {
			String name = thisJoinPoint.toLongString();
			if(name.contains("public")) ++totalPublic;
			if(name.contains("static")) ++totalStatic;
			if(name.contains("private")) ++totalPrivate;
			if(name.contains("protected")) ++totalProtected;
			if(name.contains("sexy")) ++sexybodies;
			++totalMethods;
	}
		
	after() returning:
		mainBody() {
			totalNonStatic = totalMethods - totalStatic;
			totalPackage = totalMethods - totalPublic - totalPrivate - totalProtected;
			System.out.println("Calls to public methods: " + totalPublic);
			System.out.println("Calls to private methods: " + totalPrivate);
			System.out.println("Calls to protected methods: " + totalProtected);
			System.out.println("Calls to package-private methods: " + totalPackage);
			System.out.println("Calls to static methods: " + totalStatic);
			System.out.println("Calls to non-static methods: " + totalNonStatic);
			System.out.println("Calls to all methods: " + totalMethods);
	}


	after() throwing (Throwable t): allMethodBodies() {
		System.out.println(
			"Exiting " + thisJoinPoint.getSignature()
			+ " (" + t.getClass().getName() + " thrown)");
	}
}
