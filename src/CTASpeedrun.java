//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.zip.*;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CTASpeedrun {

  private static final String DATA_ZIP_FILEPATH = "C:\\Users\\Willson\\Downloads\\google_transit.zip"; // put file path for google_tranist.zip

  public static void main() throws IOException{



    String regex = "(\\d{11,}),(\\d{2}:\\d{2}:\\d{2}),(\\d{2}:\\d{2}:\\d{2}),(\\d+),(\\d+),([^,]*),(\\d+),(\\d+)";
    Pattern pattern = Pattern.compile(regex);

    ZipFile zipFile = new ZipFile(DATA_ZIP_FILEPATH);
    ZipEntry entry = zipFile.getEntry("stop_times.txt");

    BufferedReader reader = new BufferedReader(
            new InputStreamReader(zipFile.getInputStream(entry))
    );

    //reading lines
    String line;
    while ((line = reader.readLine()) != null)
      System.out.println(line);
    }

    reader.close();
    zipFile.close();

  }

  public static void detection (){

  }

}
