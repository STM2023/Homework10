import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Task1 {
    private static final String NUM_PHONE_REGEX="^\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}$";
    private static final String NUM1_PHONE_REGEX="^\\d{3}\\-\\d{3}\\-\\d{4}$";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(NUM_PHONE_REGEX);
        Pattern pattern1= Pattern.compile(NUM1_PHONE_REGEX);

        String filePath="file.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line );
            while (line != null) {
                if (line.matches(NUM_PHONE_REGEX)||line.matches(NUM1_PHONE_REGEX)) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

