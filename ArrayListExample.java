public class ArrayListExample {
    private int[] array;
    private int length;

    public ArrayListExample() {
        //create an array of length 4 as a starting point
        array = new int[4];
        length = 0;
    }

    public ArrayListExample(int firstElement) {
        //create an array of length 4 as a starting point
        array = new int[4];
        //set the first index's value to match the first element given in the constructor argument
        array[0] = firstElement;
        length = 1;
    }

    public void addAtEnd(int data) {
        //check that our array has space. if not, we'll double the size before adding
        if (array.length <= length) {
            doubleArrayLimit();
        }
        //length is guaranteed to give the next "empty" indexed slot in the array
        //remember that the last valid index is length-1, and the next index adds 1
        //mathematically, (length - 1) + 1 gives length
        array[length] = data;
        length++;
    }

    public int getData(int index) throws ArrayIndexOutOfBoundsException {
        //check to make sure the index is within our known data, if not then we pretend we're out of bounds
        if (index > length-1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public int removeData(int index) throws ArrayIndexOutOfBoundsException {
        //check to make sure the index is within our known data, if not then we pretend we're out of bounds
        if (index > length-1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        //we're about to lose the information located at the given index, so let's store it
        //this will let us give it back at the end, as promised
        int returnValue = array[index];

        //shift everything after the given index to the left once
        //we want to stop 1 short of the last current valid index because we're looking one past said index
        for (int i = index; i < length-1; i++) {
            array[i] = array[i+1];
        }

        length--;

        return returnValue;
    }

    public int getLength() {
        return length;
    }

    public void printAll() {
        String output = "[";
        for (int i = 0; i < length; i++) {
            //a comma will be placed before each element, except before the first
            if (i > 0) {
                output += ",";
            }
            output += Integer.toString(array[i]);
        }
        output += "]";
        System.out.println(output);
    }

    public int getRealArrayLength() {
        //this is the actual array length, whose details are normally abstracted away
        return array.length;
    }

    private void doubleArrayLimit() {
        //we want the array to expand to double the current length
        int newLength = 2 * array.length;
        int[] newArray = new int[newLength];

        //fill the new, currently empty array with everything from the previous array
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }

        //forget about the old array that was too small by overwriting the field named array
        //instead it will now point to the new array
        array = newArray;
    }
}
