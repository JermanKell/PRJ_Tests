package Maps_Tests;

public class Main {

	public static void main(String[] args) {
	    TreeMap_Test test = new TreeMap_Test();

		test.AddKeyVal((float) 16.2, 2);
		test.AddKeyVal((float) 17.3, 6);
		test.AddKeyVal((float) 16.2, 14);
		test.AddKeyVal((float) 15, 12);

		test.CrossMap();
	}

}
