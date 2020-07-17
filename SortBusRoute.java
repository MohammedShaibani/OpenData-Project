import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;


public class SortBusRoute {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("bus.txt"));
        ArrayList<Busses> busRecords = new ArrayList<Busses>();
        String currentLine = reader.readLine();

        while (currentLine != null) {
            String[] routeDetails = currentLine.split("-");
            String name = routeDetails[0];
            String stTime = routeDetails[1];
            String etTime = routeDetails[2];
            stTime = stTime.replaceAll("\\s+","");
            etTime = etTime.replaceAll("\\s+","");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime sTime = LocalTime.parse(stTime, formatter);
            LocalTime eTime = LocalTime.parse(etTime, formatter);

            busRecords.add(new Busses(name, sTime, eTime));
            currentLine = reader.readLine();
        }
        Scanner stdin = new Scanner(System.in);
        System.out.println("Welcome! Which criteria would you like to sort the data? Choose by typing in the corresponding number\n1. Alphabetical\n2. Earliest Time \n3. Latest Time \n");
        int answer = stdin.nextInt();

        if (answer == 1) {
            busRecords.sort(new routeCompare());
        }
        if (answer == 2) {
            busRecords.sort(new sTimeCompare());
        }
        if (answer == 3) {
            busRecords.sort(new eTimeCompare());
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (Busses route : busRecords)
        {
            writer.write(route.name);
            writer.write(" "+route.sTime + " - " + route.eTime);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}