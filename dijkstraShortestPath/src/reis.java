import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;

public class reis implements comparable{
    public PriorityQueue<stap> stappen = new PriorityQueue<stap>(this::compareTo);
    private ArrayList<stap> snelstereis = new ArrayList<stap>();

    public void addStap(stap st) {
        stappen.add(st);
    }

    @Override
    public int compareTo(stap st1, stap st2) {
        return st1.getWaarde() < st2.getWaarde() ? 1 : -1;
    }
}
