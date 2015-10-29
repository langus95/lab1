
package Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

abstract public class AbstractReader {
    
    private ArrayList<String> data = new ArrayList<>();

    protected BufferedReader br;
    protected String path;

    abstract void load();

    public void loadSource() {

        ArrayList<String> list = new ArrayList<>();
        String line;

        try {

            while ((line = br.readLine()) != null)
                list.add(line);

            data.addAll(list);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public ArrayList<String> returnSource() {

        return this.data;

    }

    public ArrayList<String> returnAllLinks() {

        ArrayList<String> list = new ArrayList<>();
        list.addAll(data);

        ArrayList<String> links = new ArrayList<>();

        String tmp[];

        for (String x : list) {

            if (x.contains("<a href=\"")) {

                tmp = x.split("<a href=\"");

                for (int j = 1; j < tmp.length; j++)
                    links.add(tmp[j].substring(0, tmp[j].indexOf("\"")));

            }
        }

        return links;
    }

    public ArrayList<String> returnLocalLinks() {

        ArrayList<String> list = returnAllLinks();
        ArrayList<String> local = new ArrayList<>();

        for(String x : list) {

            if (!x.startsWith("http"))
                local.add(x);
        }

        return local;

    }
}
