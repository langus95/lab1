package Connect;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnect {

    private String u;
    private final String m;
    private final int t;
    private final String a;

    public HttpConnect(String u) {

        this.u = u;
        this.m = "GET";
        this.t = 5000;
        this.a = "Mozilla/5.0";

    }

    public HttpURLConnection prepareConnection() throws IOException {

        URL url = new URL(u);
        HttpURLConnection c = (HttpURLConnection) url.openConnection();

        c.setRequestMethod(m);
        c.setConnectTimeout(t);
        c.setRequestProperty("User-Agent", a);

        return c;

    }

}