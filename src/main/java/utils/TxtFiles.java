package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtFiles {

    public String[] read(String nombre) {
        List<String> txt = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(nombre));
            String linea = bf.readLine();
            while (linea != null) {
                txt.add(linea);
                linea = bf.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return txt.toArray(new String[txt.size()]);
    }
}
