public class ListUtilities {
	private IntegerList intListStart = null;
	private IntegerList intListEnd = null;
	
	// haven't got a constructor method because don't really need to do much at this level
	
	public void launch() {
	
		int[] integerArray = {2,1,5,7,22,66,14,35,111,76,84,21,65,47,48,31};
		
		this.populateListfromArray(integerArray);
	
		// now print the entire list, starting from head node and also print it's size
		intListStart.printIntegerlist();
		System.out.println("The Integer list size is " + intListStart.getListSize());
				
		// now print the entire list, starting from tail node
		intListEnd.reversePrintIntegerlist();
		
		// Let's first find and then delete an entry with value = 84
		if (this.deleteItemfromList(84)) {
			//I know we'll find the item and so this line is a bit superfluous but it's good error catching form
			System.out.println("We sure did delete that fella");
		}
		
		// now print the remaining list 
		intListStart.printIntegerlist();
		System.out.println("The Integer list size is " + intListStart.getListSize());
		// now print the entire list, starting from tail node
		intListEnd.reversePrintIntegerlist();
	} 
	
	public void populateListfromArray( int[] integerArray ) {
		IntegerList firstInteger = new IntegerList(integerArray[0]);
		intListStart = firstInteger; // this creates the start of my list
		
		for (int i=1; i<integerArray.length; i++) {			
			IntegerList nextInteger = new IntegerList(integerArray[i]);
			intListStart.addInteger(nextInteger); //add this integer to the end of the existing list
		}
		// the above code won't replace firstInteger object if it's value > new Integer
		// and so the following logic will do that if needed
		
		intListStart=intListStart.checkAndChangeHead();
		
		intListEnd=intListStart.getListTail(); // the end of the list may have changed so loop through to get it
		System.out.print("The last integer is ");
		intListEnd.printInteger();
	} 
	
	public boolean deleteItemfromList(int value) {
		boolean returnValue=false;
		IntegerList integerToFind = null;
		integerToFind = intListStart.findInteger(value);
		
		if (integerToFind != null) {
			returnValue=true;
			System.out.print("The Integer to be deleted has been found and has value ");
			integerToFind.printInteger();
		
			// now let's just delete this Integer
			intListStart.deleteInteger(integerToFind);
		}
		else {
			System.out.println("Could not find the integer");
		}
		
		return returnValue;
	}
	
	public static void main(String[] args) {
		ListUtilities myListUtility = new ListUtilities();
		myListUtility.launch();
	}
	
}