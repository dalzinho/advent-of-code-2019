package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIngestor {

    public List<Integer> readListOfNumbers(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Integer> ints = new ArrayList<>();

        String nextint = reader.readLine();
        while (nextint != null) {
            ints.add(Integer.parseInt(nextint));
            nextint = reader.readLine();
        }

        return ints;
    }
}
