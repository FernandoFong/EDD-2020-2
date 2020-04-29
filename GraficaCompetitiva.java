public class GraficaCompetitiva {


    private static void agregarArista(boolean [][] grafica, int u, int v) {
        grafica[u][v] = true;
        grafica[v][u] = true;
    }

    private static void eliminarArista(boolean [][] grafica, int u, int v) {
        grafica[u][v] = false;
        grafica[v][u] = false;
    }

    private static int grado(boolean [][] grafica, int u) {
        int contador = 0;
        for(int i = 0; i < grafica.length; i++)
            contador = (grafica[u][i]) ? contador+1 : contador;
        return contador;
    }

    public static void main(String [] args) {
        boolean [][] grafica = new boolean [10][10]; //Ojo, las etiquetas de los vértices irían del 0 -9;
        agregarArista(grafica, 4, 3);
        agregarArista(grafica, 4, 5);
        System.out.println(grafica);
        System.out.println(grado(grafica, 4));
        System.out.println(grado(grafica, 2));
    }
}
