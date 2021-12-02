import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Runner {

  public static void main(String[] args) throws IOException {

    Runner runner = new Runner();
    String response = runner.invoke(Constant.registryUrl);
    if (response.equals("false")) System.out.println("We are started!");
  }

  public String invoke(String url) throws IOException {
    URL registryUrl = new URL(Constant.registryUrl);
    HttpURLConnection connection = (HttpURLConnection) registryUrl.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();
    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    return response.toString();
  }
}
