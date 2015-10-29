
package Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import Connect.HttpConnect;


public class ReadFromWeb extends AbstractReader {

    public ReadFromWeb(String url) {

        this.path = url;
        load();

    }

    @Override
    void load() {

        try {

            HttpConnect hc = new HttpConnect(path);
            HttpURLConnection c = hc.prepareConnection();

            this.br = new BufferedReader(new InputStreamReader(c.getInputStream()));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}

