package Threads;

import Model.Student;
import Service.ReadJsonFileService;

public class WriteConsoleThread implements Runnable {

    public void run() {
        try {
            //Okuma ve konsola yazdirma islemleri arasinda 3000milis mevcut. Okumadan yazdirilamaz.
            Thread.sleep(3000);
            if (ReadJsonFileService.readThreadControl) {//Okuma islemi bitis kontrolu yapiliyor.
                writeToConsole();//Okuma islemi baslatiliyor.
            }
        } catch (Exception error) {
            //İleriki Asamalarda Loglama Islemi Yapilabilir.
            System.out.println(error);
        }
    }

    //Okunan verinin konsola  yazdirilmasi icin gerekli metot.
    public static void writeToConsole() {
       try {
           System.out.println("---------------Okunan Veri Yazdiriliyor...---------------");
           for (Student student: ReadFileThread.students) {
               System.out.println("**************************************************");
               System.out.println("Student Name: "+student.getName());
               System.out.println("Student Surname: "+student.getSurname());
               System.out.println("Student Age: "+student.getAge());
               System.out.println("**************************************************");
               Thread.sleep(1000);//Yazdirilma asamasinda gercekci olmasi adina her veri arasinda 1000 milis yazdirma farki mevcut.
           }
           System.out.println("---------------Yazdirma İsleminin Sonuna Gelindi!---------------");
       } catch (Exception error) {
           System.out.println(error);
       }
    }
}
