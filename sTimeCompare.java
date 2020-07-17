import java.util.Comparator;

public class sTimeCompare implements Comparator<Busses> {
    @Override
    public int compare(Busses s1, Busses s2)
    {
        return s1.sTime.compareTo(s2.sTime);
    }
}
