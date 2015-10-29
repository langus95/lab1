
package Connect;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class Source {

    private String source = null;
    public Source(String source) {
        this.source = source;
    }

    public boolean isValidLink() {

        if((source.startsWith("www.")) || (source.startsWith("http://"))) {
            try {
                if(source.startsWith("www."))
                    source = source.replace("www.", "http://www.");
                HttpConnect hc = new HttpConnect(source);
                HttpURLConnection c = hc.prepareConnection();
                return c.getResponseCode() == HttpURLConnection.HTTP_OK;

            } catch (IOException e) {
                return false;
            }
        } else
            return false;

    }

    public boolean isValidDiskFile() {
        File f = new File(source);
        return (f.exists() && !f.isDirectory());
    }

    public String getSource() {
        return source;
    }

}