import java.util.Arrays;

public class MinHeap {

    private int [] heap;
    private int size;

    public MinHeap(int [] h, int s) {
	this.heap = new int[s];
	for(int i = 0; i < s; i++) {
	    this.heap[i] = h[i];
	}
	this.size = s;
	for(int i = s/2; i >= 0; i--)
	    heapify(i);
    }

    private void heapify(int i) {
	if(left(i) == -1)
	    return;
	int l = left(i);
	int r = right(i);
	int m = min(i, l, r);
	if(m != i) {
	    swap(i, m);
	    heapify(m);
	}
    }

    private int left(int i) {
	return (2*i+1) < heap.length ? (2*i+1) : -1;
    }

    private int right(int i) {
	return (2*i+2) < heap.length ? (2*i+2) : -1;
    }

    private int min(int p, int l, int r) {
        if(l == -1)
	    return p;
	int m = (heap[p] < heap[l]) ? p : l;
	if(r != -1)
	    m = (heap[m] < heap[r]) ? m : r;
	return m;
    }

    private void swap(int i, int j) {
	if(i == -1 || j == -1)
	    return;
	if(i > heap.length || j > heap.length)
	    return;
	int aux = heap[i];
	heap[i] = heap[j];
	heap[j] = aux;
    }

    public String toString() {
	return Arrays.toString(this.heap);
    }
}
