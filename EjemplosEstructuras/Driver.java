public class Driver {

    public static void main(String [] args) {
	int [] a = {7, 6, 5, 4, 3, 2, 1};
	MinHeap min = new MinHeap(a, a.length);
	System.out.println(min.toString());
    }
}
