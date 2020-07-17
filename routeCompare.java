import java.util.Comparator;

public class routeCompare implements Comparator<Busses> {

    @Override
    public int compare(Busses s1, Busses s2)
    {
        return s1.name.compareTo(s2.name);
    }

}
