import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
public class Task2 {

 public static void main(String[] args) {
        String filePath="file1.txt"; // считываем инфу
        String userPath = "user.json";
        ArrayList< Used> newPeople = new ArrayList< Used>();
        String[] arr;
        Gson gson =new GsonBuilder().setPrettyPrinting().create();

        StringBuilder jsonString = new StringBuilder();
//        System.out.println("значення з файлу:  "+filePath);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line!=null){
                line = reader.readLine();
                if (line!=null){
                    arr=obrabLine(line);
                    Used   used = new Used(arr[0],Integer.parseInt (arr[1]));
                    //                   System.out.println("значення  "+ used);
                    newPeople.add(used);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonString.append("[\n");
        int k =0;
        for(Used p : newPeople) {
            jsonString.append(gson.toJson(p)) ;
            k++;
            if(k!= newPeople.size()){
                jsonString.append(",\n");
            }
        }

        jsonString.append("\n]");

        try (PrintWriter out = new PrintWriter(new FileWriter(userPath))) {
            out.write(jsonString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] obrabLine(String line) {
        // обработка введенной строки
//        System.out.println("---------  "+  line);
        line = line.trim();
        int k = 0;
        int j = 0;
        String[] name1 = {"", ""};
        for (int i = 0; i <= line.length() - 1; i++) {
            if (line.charAt(i) == ' ') {
                name1[j] = line.substring(k, i);
                j++;
                k = i + 1;
            }
        }
        name1[j] = line.substring(k, line.length());

//        System.out.println(Arrays.toString(name1));
        return name1;
    }
}
class Used   {
    private String name;
    private Integer age;
    public Used(String name, Integer age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }

    public Integer getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Used {" + "name='" + name + '\'' + ", age=" + age +  '}';
    }

}

//class TestTask2{
//
//}
