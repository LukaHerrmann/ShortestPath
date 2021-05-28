public class Main {
    public static void main(String[] arg) {
        stap s10 = new stap(new treinrit(12), "Middelburg", "Rotterdam");
        stap s11 = new stap(new treinrit(586), "Middelburg", "Den Bosch");
        stap s12 = new stap(new treinrit(24), "Rotterdam", "Utrecht");
        stap s13 = new stap(new treinrit(65), "Den Bosch", "Utrecht");
        stap s14 = new stap(new treinrit(32), "Rotterdam", "Den Bosch");
        reis r2 = new reis("Middelburg", "Utrecht");
        r2.addStap(s10);
        r2.addStap(s11);
        r2.addStap(s12);
        r2.addStap(s13);
        r2.addStap(s14);
        r2.dijkstra();
        System.out.println(r2.toString());
    }
}
