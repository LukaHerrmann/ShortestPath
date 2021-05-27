public class vlucht {
    final int bagageverlieskans;
    final double kosten;
    final double reisWaarde;

    public vlucht(int bagageverlieskans, double kosten) {
        this.bagageverlieskans = bagageverlieskans;
        this.kosten = kosten;
        this.reisWaarde = bagageverlieskans * kosten;
    }

    public int getBagageverlieskans() {
        return bagageverlieskans;
    }

    public double getKosten() {
        return kosten;
    }

    public double getReisWaarde() {
        return reisWaarde;
    }
}
