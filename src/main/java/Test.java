import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Test {


    public static void main(String[] args) {

        Employee e1 = new Employee("John","Wayne");
        Employee e2 = new Employee("Maria","Calas");

        Employee [] database  = {e1,e2};
        ArrayList<Employee> databse2 = new ArrayList<>(Arrays.asList(database));


        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();


        String test1 = gson.toJson(e1);
        System.out.println("");
        System.out.println("Json: " + test1);
        System.out.println(" ");
        Employee e3 = gson.fromJson(test1,Employee.class);
        System.out.println("From Json: " + e3 + '\n');
        System.out.println(" ");
        System.out.println("Kowersja tablicy obiektów do formatu JSON");
        System.out.println(" ");
        System.out.println(gson.toJson(database));
        System.out.println(" ");
        System.out.println("Z ArrayList");
        System.out.println(" ");
        System.out.println(gson.toJson(databse2));

        //wpisywanie do pliku

        File file = new File("C:\\Users\\Student.DESKTOP-VNR47RU\\Desktop\\244813_ZPO\\JSON\\json1.json");
        try(FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(database,fileWriter);
        }
        catch (IOException e) {
            System.out.println("IO error");
        }

        Employee [] testDatabase = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            testDatabase = gson.fromJson(bufferedReader, Employee[].class);
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("From Json: " + Arrays.toString(testDatabase)+ '\n');

        //tworzenie mapy atrybutow

        Map m = gson.fromJson(test1,Map.class);
        System.out.println("Obiekt ma: " + m.size() + " atrybuty");

        for (Object key : m.keySet()){
            System.out.println("key: " + key);
        }
        //odczytywanie pol
        System.out.println(m.get("firstName"));
        System.out.println(m.get("lastName"));
    }


}
