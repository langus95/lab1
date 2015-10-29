
package Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile extends AbstractReader {

    public ReadFromFile(String path) {

        this.path = path;
        load();

    }

    @Override
    void load() {

        try {
            this.br = new BufferedReader(new FileReader(new File(path)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}