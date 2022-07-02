package Service;

import Model.Student;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//Json dosyasi okumak icin yazilan metot. Json dosyasi icinden veriler okunuyor.
public class ReadJsonFileService {

    //Veri okuma isleminin bitis kontrolunun yapildigi degisken.
    public static boolean readThreadControl = false;

    public ArrayList<Student> readJsonFile() {

        ArrayList<Student> students = new ArrayList<Student>();
        JSONParser jsonParser = new JSONParser();

        try {

            //Dosya bulundu. Dosya yolu verilebilir. 
            FileReader reader = new FileReader("\\jsonfiles\\student.json");

            Object fileObj = jsonParser.parse(reader);

            JSONArray fileArray = (JSONArray) fileObj;

            //Json icerisinden veriler belirli formata gore okunarak students liste atildi.
            for (int i =0; i<fileArray.size();i++){
                JSONObject studentLine = (JSONObject) fileArray.get(i);
                String name = (String)studentLine.get("name");
                String surname = (String)studentLine.get("surname");
                int age = Integer.valueOf(String.valueOf(studentLine.get("age")));

                students.add(new Student(name, surname, age));
            }

            //Veri okuma islemi bittigi icin degisken degeri true.
            readThreadControl = true;

        } catch (Exception e) {

            //Ileriki asamalarda loglama islemi gerceklestirilebilir.
            System.out.println(e);

        }

        //Okunan jsondaki veriler konsola yazilmak uzere donduruluyor.
        return students;
    }

}
