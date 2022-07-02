import java.util.ArrayList;

import Model.Student;
import Service.ReadJsonFileService;
import Threads.ReadFileThread;
import Threads.WriteConsoleThread;

public class Main {

    /**
     *
     * JSON dosyalarimiz resources altinda bulunan jsonfiles klasorunun icinden okunmakta.
     */

    public static void main(String[] args) {

        //Threadlar tanimlandi. Runnable interfaceden implement alindi.
        ReadFileThread readFileThread = new ReadFileThread();
        Thread thread1 = new Thread(readFileThread);

        WriteConsoleThread writeConsoleThread = new WriteConsoleThread();
        Thread thread2 = new Thread(writeConsoleThread);

        //Threadlar baslatiliyor.
        thread1.start();
        thread2.start();



    }

}
