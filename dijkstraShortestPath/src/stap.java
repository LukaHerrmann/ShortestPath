import java.util.ArrayList;

public class stap {
    final Object reismethode;
    private ArrayList<String> plekken = new ArrayList<String>();

    public stap (Object reismethode, String beginpunt, String eindpunt) {
        this.reismethode = reismethode;
        this.plekken.add(beginpunt);
        this.plekken.add(eindpunt);
    }

    public String getBeginpunt() {
        return plekken.get(0);
    }

    public String getEindpunt() {
        return plekken.get(1);
    }

    public ArrayList<String> getPlekken() {
        return plekken;
    }

    public double getWaarde() {
        if (reismethode instanceof rit) {return ((rit) reismethode).getAfstand();}
        else if (reismethode instanceof treinrit) {return ((treinrit) reismethode).getTijdsduur();}
        else if (reismethode instanceof vlucht) {return ((vlucht) reismethode).getReisWaarde();}
        else {return -1;}
    }
}
