public class vlucht {
    final int bagageverlieskans;
    final double kosten;

    public vlucht(int bagageverlieskans, double kosten) {
        this.bagageverlieskans = bagageverlieskans;
        this.kosten = kosten;
    }


    public int getBagageverlieskans() {
        return bagageverlieskans;
    }

    public double getKosten() {
        return kosten;
    }
}
