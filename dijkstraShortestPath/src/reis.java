import java.util.*;
import java.util.stream.Collectors;

public class reis implements comparable {
    public PriorityQueue<stap> stappen = new PriorityQueue<stap>(this::compareTo);
    private ArrayList<stap> snelstereis = new ArrayList<stap>();
    private HashMap<String, Double> kortsteAfstand = new HashMap<String, Double>();
    public String beginpunt;
    final String eindpunt;

    public reis(String beginpunt, String eindpunt) {
        this.beginpunt = beginpunt;
        this.eindpunt = eindpunt;
    }

    public void addStap(stap st) {
        stappen.add(st);
    }

    public String getBeginpunt() {
        return beginpunt;
    }

    public String getEindpunt() {
        return eindpunt;
    }

    public void dijkstra() {
        //bron:
        ArrayList<String> plekken = new ArrayList<String>();
        ArrayList<String> gebruiktePlekken = new ArrayList<String>();
        HashMap<String, String> voorgaandeplekken = new HashMap<String, String>();
        for (stap st : this.stappen) {
            plekken.add(st.getBeginpunt());
            plekken.add(st.getEindpunt());
        }
        ArrayList<String> uniek = new ArrayList<>(new HashSet<>(plekken));
        for (String st : uniek) {
            if (st.equals(this.beginpunt)) {
                kortsteAfstand.put(st, 0.0);
            } else {
                kortsteAfstand.put(st, 10000000000.0);
            }
        }
        String huidigpunt = this.beginpunt;
        for (int i = 0; i < uniek.size(); i++) {
            String finalHuidigpunt1 = huidigpunt;
            List<stap> verbondenStappen = this.stappen.stream().filter(st -> st.getPlekken().contains(finalHuidigpunt1))
                    .collect(Collectors.toList());
            for (stap stp : verbondenStappen) {
                ArrayList<String> huidigeplekken = stp.getPlekken();
                String anderpunt = "temp";
                for (String plek : stp.getPlekken()) {
                    if (plek != huidigpunt) {
                        anderpunt = plek;
                    }
                }
                if (kortsteAfstand.get(huidigpunt) + stp.getWaarde()
                        < kortsteAfstand.get(anderpunt)) {
                    kortsteAfstand.put(anderpunt, kortsteAfstand.get(huidigpunt) + stp.getWaarde());
                    String finalHuidigpunt = huidigpunt;
                    String finalHuidigpunt2 = huidigpunt;
                    voorgaandeplekken.put(anderpunt, huidigpunt);
                }
            }
            gebruiktePlekken.add(huidigpunt);
            String minplek = this.beginpunt;
            for (String plek : kortsteAfstand.keySet()) {
                if (minplek.equals(this.beginpunt)) {
                    for (String plk : kortsteAfstand.keySet()) {
                        if (!gebruiktePlekken.contains(plk)) {
                            minplek = plk;
                            break;
                        }
                    }
                } else if (!gebruiktePlekken.contains(plek) && kortsteAfstand.get(plek) < kortsteAfstand.get(minplek)) {
                    minplek = plek;
                }
            }
            huidigpunt = minplek;
        }
        String snel = this.eindpunt;
        while (snel != this.beginpunt) {
            String finalSnel = snel;
            this.snelstereis.add(0, stappen.stream().filter(st ->
                    st.getPlekken().contains(finalSnel) && st.
                            getPlekken().contains(voorgaandeplekken.get(finalSnel))).findAny().get());
            snel = voorgaandeplekken.get(snel);
        }
    }

    public String toString() {
        String s = "Begin: " + this.beginpunt + "\n";
        for (stap ding : snelstereis) {
            if (ding.getEindpunt() != this.eindpunt) {
                s = s + "door: " +
                        ding.getEindpunt() + "\n";
            }
        }
        s = s + "Eind: " + this.eindpunt;
        return s;
    }


    @Override
    public int compareTo(stap st1, stap st2) {
        return st1.getWaarde() > st2.getWaarde() ? 1 : -1;
    }
}
