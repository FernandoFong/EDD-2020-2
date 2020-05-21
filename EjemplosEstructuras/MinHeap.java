import java.util.Arrays;

public class MinHeap {

    private int [] heap;
    private int size;
    private int lastAdded;

    public MinHeap(int [] h, int s) {
	this.heap = new int[s];
	// Construyo el heap al chilazo.
	for(int i = 0; i < s; i++) {
	    this.heap[i] = h[i];
	}
	// Guardo el tamaño, para algo ha de servir. :v
	this.size = s;
	for(int i = s/2; i >= 0; i--)
	    heapify(i); //Mando llamar a Heapify desde la mitad.
    }

    private void heapify(int i) {
	// Si no tengo hijo izquierdo, menos derecho, termino.
	if(left(i) == -1) 
	    return;
	int l = left(i); //Calculo el hijo izquierdo. 
	int r = right(i); //Calculo el hijo derecho.
	//Obtengo el índice donde se encuentra el mínimo elemento.
	int m = min(i, l, r);
	if(m != i) { //Si el índice es distinto al que está en la raíz.
	    swap(i, m); //Hago el cambio en el heap.
	    //Puede ser que al hacer el swap, los hijos de m, sean mayores que
	    //los de i, entonces tengo que repetir recursivamente hacia abajo.
	    heapify(m);
	}
    }

    private int left(int i) {
	//Pregunto primero si tiene izquierdo, si no tiene regreso -1
	return (2*i+1) < heap.length ? (2*i+1) : -1;
    }

    private int right(int i) {
	//Lo mismo que el otro, pero con -1;
	return (2*i+2) < heap.length ? (2*i+2) : -1;
    }

    private int min(int p, int l, int r) {
	//Si no tengo hijo izquierdo, el mínimo pues va a ser el único elemento.
        if(l == -1)
	    return p;
	//Hago la comparación de heap[p] y heap[l] y recuerdo el índice
	//que tiene al mínimo.
	int m = (heap[p] < heap[l]) ? p : l;
	//Si tengo hijo derecho, pregunto por él, si no, ni la modifiques.
	if(r != -1)
	    //Pregunta por el menor.
	    m = (heap[m] < heap[r]) ? m : r;
	//Regresa el índice del menor elemento.
	return m; 
    }

    private void swap(int i, int j) {
	//Si alguno es -1, entonces no hago nada.
	if(i == -1 || j == -1)
	    return;
	//Si salen del arreglo, igual nada.
	if(i > heap.length || j > heap.length)
	    return;
	//Swap clásico.
	int aux = heap[i];
	heap[i] = heap[j];
	heap[j] = aux;
    }

    public int extaerMinimo() {
	//Sabemos que se cumple la condición
	// de que en la raíz se encuentra el elemento más pequeño de toda la colección.
	int m = heap[0];
	heap[0] = Integer.MAX_VALUE;
	heapify(0);
	return m;
    }

    public void agrega(int x) {
	
    }

    public String toString() {
	return Arrays.toString(this.heap);
    }
}
