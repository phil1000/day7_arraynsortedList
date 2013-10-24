public class IntegerList {
	private int myInteger;
	private IntegerList priorInteger;
	private IntegerList nextInteger;
	
	public IntegerList (int inInteger) {
		this.myInteger=inInteger;
		this.priorInteger = null;
		this.nextInteger = null;
	}
	
	public void printInteger() {
		System.out.println("I=" + this.myInteger);
	}
	
	public void addInteger(IntegerList newInteger) {
		if (this.nextInteger == null) {
			// this is the last integer in the list
			this.nextInteger = newInteger;
			newInteger.priorInteger=this;
		} else {
			this.nextInteger.addInteger(newInteger); // 
		}
	}
	
	public boolean deleteInteger(IntegerList Integer) {
		IntegerList tempInteger=null;
		if (this.nextInteger == null) {
			// Integer to remove was not found
			return false;
		} else if (this.nextInteger.myInteger==Integer.myInteger) {
			// we found it and it's the next one
			// link this integer to the one after the next
			// the next object is not specifically deleted, just removed from the list
			// ultimately the garbage collector will remove it
			tempInteger=this.nextInteger;
			this.nextInteger = this.nextInteger.nextInteger;
			tempInteger.nextInteger.priorInteger=tempInteger.priorInteger;
			return true;
		} else {
			return this.nextInteger.deleteInteger(Integer); // recursive program 
		}
	}
	
	public boolean printIntegerlist() {
		if (this.nextInteger == null) {
			// came to end of list so can finish printing
			this.printInteger(); // print this instance of the patient
			return false;
		} else {
			this.printInteger();
			return this.nextInteger.printIntegerlist(); // recursive program 
		}
	}
	
	public boolean reversePrintIntegerlist() {
		if (this.priorInteger == null) {
			// came to start of list so can finish printing
			this.printInteger(); // print this instance of the patient
			return false;
		} else {
			this.printInteger();
			return this.priorInteger.reversePrintIntegerlist(); // recursive program 
		}
	}
	
	public int getListSize() {
		int listSize=0;
		IntegerList listNavigator=this; // I am setting navigator to the current object instance I am in, which is the start of the list
		while (listNavigator.nextInteger != null) {
			listNavigator=listNavigator.nextInteger;
			listSize++;
		}
		if (listSize>0) {
			listSize++; //need to add this instance of the patient to the list
		}
		return listSize;
	}
	
	public IntegerList findInteger(int intToFind) {
	
		// I used a loop rather than recursive program as I find it easier
		IntegerList intToReturn = null;
		IntegerList listNavigator = null;
		
		if (this.myInteger==intToFind) {
			// cannot delete first item in the list 
			System.out.println("Cannot delete first item in list so bye");
		}
		else {
			if (this.nextInteger==null) {
				// only one item in the list 
				System.out.println("Only one item in list and cannot delete it");
			}
			else {
				listNavigator=this.nextInteger;
				do {
					if (listNavigator.myInteger==intToFind) {
						intToReturn=listNavigator;
						break;
					} else {
						listNavigator=listNavigator.nextInteger;
					}
				}
				while (listNavigator.nextInteger != null);
			}
		}
		
		return intToReturn; // will either be null or a pointer to correct IntegerList object
	}
}