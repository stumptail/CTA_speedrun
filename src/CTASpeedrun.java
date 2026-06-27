//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.ArrayList;
import java.util.zip.*;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CTASpeedrun {

  private static final String DATA_ZIP_FILEPATH = "C:\\Users\\Willson\\Downloads\\google_transit.zip"; // put file path for google_tranist.zip
  private static ArrayList<CTAStopTimes> trainStops = new ArrayList<CTAStopTimes>();

  public static void main(String[] args) throws IOException{



    String regex = "(\\d{11,}),(\\d{2}:\\d{2}:\\d{2}),(\\d{2}:\\d{2}:\\d{2}),(\\d+),(\\d+),([^,]*),(\\d+),(\\d+)";
    Pattern pattern = Pattern.compile(regex);

    ZipFile zipFile = new ZipFile(DATA_ZIP_FILEPATH);
    ZipEntry entry = zipFile.getEntry("stop_times.txt");

    BufferedReader reader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));

    //reading lines

    String line;
    reader.readLine();

    while ((line = reader.readLine()) != null){
      detection(pattern, line);
      //System.out.println(line);
    }

    System.out.println("Done");

    reader.close();
    zipFile.close();

  }

  public static void detection (Pattern pat,String lineToBeParsed){
    Matcher mat = pat.matcher(lineToBeParsed);
    if(!mat.matches()){
      System.out.println("String did not match expected input");
      return;
    }
    long tripID = Long.parseLong(mat.group(1));

    if(tripID/1000000/10000 != 9){ //filters out all the buses
      return;
    }
    //System.out.println(tripID);

    String arrivalTime = mat.group(2);
    String departureTime = mat.group(3);
    int stopID = Integer.parseInt(mat.group(4));
    int stopSequence = Integer.parseInt(mat.group(5));
    //String stopHeadsign = mat.group(6);

    CTATime arrive = new CTATime(arrivalTime);
    CTATime depart = new CTATime(departureTime);

    CTAStopTimes newStopTime = new CTAStopTimes(tripID, arrive, depart, stopID, stopSequence);
    trainStops.add(newStopTime);
  }

}
