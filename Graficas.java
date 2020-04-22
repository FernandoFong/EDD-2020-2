import java.util.LinkedList; //Para tener una lista de vértices.

public class Graficas {

    private class Vertice {

        //Para no tener que hacer getters y setters, pues que todo sea public.
        public int elemento;
        public LinkedList<Vertice> vecinos;

        //¿Qué recibiría el constructor?
        public Vertice(int e) {
            this.elemento = e;
            this.vecinos = new LinkedList<>(); //Especifico que no tengo vecinos aún.
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

}
