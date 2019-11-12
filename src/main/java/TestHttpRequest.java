import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class TestHttpRequest {

    public static void main(String[] args) {

        StringBuffer response = new StringBuffer();
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Wroclaw&units=metric&APPID=TWOJEID";

        try{
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
       connection.setRequestMethod("GET");
       int responseCode = connection.getResponseCode();
            System.out.println("Response: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
        }



        catch (MalformedURLException e) {
            System.out.println("bad url");
        } catch (IOException e) {
            System.out.println("Conection failed");
        }
        System.out.println(response);

    }

}
