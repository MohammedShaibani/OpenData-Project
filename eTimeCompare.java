import java.util.Comparator;

public class eTimeCompare implements Comparator<Busses> {
    @Override
    public int compare(Busses s1, Busses s2)
    {
        return s2.eTime.compareTo(s1.eTime);
    }
}
