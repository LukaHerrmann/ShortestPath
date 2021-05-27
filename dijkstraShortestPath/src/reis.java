import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;

public class reis implements comparable{
    public PriorityQueue<stap> stappen = new PriorityQueue<stap>(this::compareTo);
    private ArrayList<stap> snelstereis = new ArrayList<stap>();
    private String beginpunt;
    private String eindpunt;

    public reis (String beginpunt, String eindpunt) {
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

    @Override
    public int compareTo(stap st1, stap st2) {
        return st1.getWaarde() > st2.getWaarde() ? 1 : -1;
    }
}
