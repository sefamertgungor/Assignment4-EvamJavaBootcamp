package Threads;

import Model.Student;
import Service.ReadJsonFileService;

import java.util.ArrayList;

//Veri okuma isleminin gerceklestigi metodu barindiran sinif.
public class ReadFileThread implements Runnable {
    public static ArrayList<Student> students;

    //Veri okuma isleminin gerceklestigi metot.
    public void run() {
        try {

            System.out.println("---------------Veri okuma islemi basladi...---------------\n");
            ReadJsonFileService readJsonFileService = new ReadJsonFileService();
            students = readJsonFileService.readJsonFile();
            System.out.println("---------------Veri okuma isleminin sonuna gelindi!---------------\n");

            //Okuma ve konsola yazma threadlari arasinda 3000milis mevcut.
            Thread.sleep(3000);

        } catch (Exception e) {

            //Ileriki asamalarda loglama islemi gerceklestirilebilir.
            System.out.println(e);

        }


    }
}
