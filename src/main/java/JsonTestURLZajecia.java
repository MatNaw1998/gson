import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonTestURLZajecia {

    public static void main(String[] args) {
        System.out.println(" hello");
        Gson gson = new Gson();

        StringBuffer response = new StringBuffer();
        String url = "http://api.open-notify.org/iss-now.json";

        try{
            URL obj = new URL(url);
            HttpURLConnection  connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response: "  + responseCode);

String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

while ((inputLine = in.readLine()) != null){
    response.append(inputLine);
}

            System.out.println(response);

            File file = new File("C:\\Users\\Student.DESKTOP-VNR47RU\\Desktop\\244813_ZPO\\JSON\\json2.json");
            try(FileWriter fileWriter = new FileWriter(file)) {
                gson.toJson(response,fileWriter);
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
