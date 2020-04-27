import java.util.LinkedList; //Para tener una lista de vértices.
import java.util.Queue;

public class Graficas {

    private class Vertice {

        //Para no tener que hacer getters y setters, pues que todo sea public.
        public int elemento;
        public LinkedList<Vertice> vecinos;
        public boolean marcado;

        //¿Qué recibiría el constructor?
        public Vertice(int e) {
            this.elemento = e;
            this.vecinos = new LinkedList<>(); //Especifico que no tengo vecinos aún.
            this.marcado = false;
        }

        public String toString() {
            String s = Integer.toString(this.elemento) + ": [";
            for(Vertice v : vecinos) {
                s += v.elemento;
                if(vecinos.indexOf(v) != vecinos.size()-1)
                    s += ", ";
            }
            return s + "]";
        }
    }

    public LinkedList<Vertice> vertices;

    public Graficas() {
        this.vertices = new LinkedList<>();
    }

    public void agregaVertice(int v) {
        this.vertices.add(new Vertice(v));
    }

    public void eliminarVertice(int v) {
        Vertice elimina = buscaVertice(v);
        while(!elimina.vecinos.isEmpty()) {
            Vertice vecino = elimina.vecinos.getFirst();
            this.eliminarArista(v, vecino.elemento);
        }
        this.vertices.remove(elimina);
    }

    private Vertice buscaVertice(int v) {
        for(Vertice ve : vertices) {
            if(ve.elemento == v)
                return ve;
        }
        return null;
    }

    public void agregarArista(int v, int u) {
        Vertice vv = buscaVertice(v), vu = buscaVertice(u); //Multiasignación. u, v = buscaVertice(u), buscaVeritce(v);
        /*
         *Vertice vv = buscaVertice(v);
         * Vertice vu = buscaVertice(u);
         */
        vv.vecinos.add(vu);
        vu.vecinos.add(vv); //En caso de que fuera dirigida, entonces lo que habría que hacer sería borrar una de estas.
    }

    public void eliminarArista(int v, int u) {
        Vertice vv = buscaVertice(v), vu = buscaVertice(u);
        vv.vecinos.remove(vu);
        vu.vecinos.remove(vv);//Estos pueden causar NPE (Null Pointer Exception) en caso de que el vértice no exista.
    }

    public String toString() {
        String s = "";
        for(Vertice v : this.vertices) {
            s += v.toString();
            if(this.vertices.indexOf(v) != this.vertices.size()-1)
                s += "\n";
        }
        return s;
    }

    public void bfs(int source) {
        /**
         * Encuentro el vértice asociado a source.
         * Lo marco como visitado.
         * Para todos sus vecinos que no estén visitados:
         *     Los meto a la cola. Cola es una interfaz, hay que usar una clase que
                                   implemente a esa interfaz, como lo es LinkedList.
         * Mientras que la cola no sea vacía:
         *     saco un vértice de la cola.
         *     lo marco como visitado.
         *     y meto a todos sus vecinos que no estén marcados ya.
         */
        // Checar el algoritmo húngaro para gráficas bipartitas.
        Vertice s = buscaVertice(source);
        if(s == null)
            return;
        Queue<Vertice> cola = new LinkedList<>();
        s.marcado = true;
        cola.add(s);
        while(!cola.isEmpty()) {
            Vertice i = cola.poll();
            System.out.println(i.elemento);
            for(Vertice ve : i.vecinos) {
                if(!ve.marcado) {
                    ve.marcado = true;
                    cola.add(ve);
                }
            }
        }
    }

}
