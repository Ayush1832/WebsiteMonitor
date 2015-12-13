package WebsiteMonitor;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import java.net.URL;

// http://stackoverflow.com/questions/6068197/utils-read-resource-text-file-to-string-java

public class EntryPoint {
    public static void main(String[] args) throws Exception {

        URL url = Resources.getResource("config.json");
        String text = Resources.toString(url, Charsets.UTF_8);

        Gson gson = new Gson();
        Config config = gson.fromJson(text, Config.class);

        WebServer webServer = new WebServer(config);
        webServer.StartServer();
    }
}
