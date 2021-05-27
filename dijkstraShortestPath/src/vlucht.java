public class vlucht {
    final double bagageverlieskans;
    final double kosten;
    final double reisWaarde;

    public vlucht(double bagageverlieskans, double kosten) {
        this.bagageverlieskans = bagageverlieskans;
        this.kosten = kosten;
        this.reisWaarde = kosten + kosten * bagageverlieskans;
    }

    public double getBagageverlieskans() {
        return bagageverlieskans;
    }

    public double getKosten() {
        return kosten;
    }

    public double getReisWaarde() {
        return reisWaarde;
    }
}
