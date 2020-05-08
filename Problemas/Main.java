public class Main {

    public static void main(String [] args) {
        Graficas g = new Graficas();
        for(int i = 1; i <= 10; i++)
            g.agregaVertice(i);

        g.agregarArista(1, 2);
        g.agregarArista(2, 3);
        g.agregarArista(3, 4);
        g.agregarArista(4, 5);
        g.agregarArista(5, 6);
        g.agregarArista(6, 7);
        g.agregarArista(7, 8);
        g.agregarArista(8, 9);
        g.agregarArista(9, 10);
        g.agregarArista(10, 1);
        System.out.println(g.toString());
        g.bfs(1);
    }
}
