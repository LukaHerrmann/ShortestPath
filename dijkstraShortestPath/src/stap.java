public class stap {
    final Object reismethode;
    final String beginpunt;
    final String eindpunt;

    public stap (Object reismethode, String beginpunt, String eindpunt) {
        this.reismethode = reismethode;
        this.beginpunt = beginpunt;
        this.eindpunt = eindpunt;
    }

    public double getWaarde() {
        if (reismethode instanceof rit) {return ((rit) reismethode).getAfstand();}
        if (reismethode instanceof treinrit) {return ((treinrit) reismethode).getTijdsduur();}
        if (reismethode instanceof vlucht) {return ((vlucht) reismethode).getReisWaarde();}
        else {return -1;}
    }
}
