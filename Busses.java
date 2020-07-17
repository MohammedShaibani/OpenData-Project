import java.time.LocalTime;

public class Busses {

    String name;
    LocalTime sTime;
    LocalTime eTime;

    public Busses(String name, LocalTime sTime, LocalTime eTime)
    {
        this.name = name;
        this.sTime = sTime;
        this.eTime = eTime;
    }
}
