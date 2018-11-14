import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Utils {

    private final static String DIV =  "------------------------------------------------------------";


    private static String getRandomString(){
        int min = 1;
        int max = 255;
        int size =  min + (int)(Math.random() * max);

        char[] word = new char[size];

        for(int i = 0; i < word.length; i++)
            word[i] = (char)(min + (int)(Math.random() * max));
        return new String(word);

    }



    public static void fillList(List<String> list, int counterOfAdd, int counterOfRemove){
        for (int i = 0; i < counterOfAdd; i++)
            list.add(getRandomString());
        for(int i = 0; i < counterOfRemove; i++)
            list.remove(list.size() - 1);
    }

    public static void saveNotifations(){
        Notification.addValueToList("Count of minor garbage collections: " + Notification.getCountMinorCleanUp() +
                ". Total duration: " + Notification.getDurationMinorCleanUp());
        Notification.addValueToList("Count of major garbage collections: " + Notification.getCountMajorCleanUp() +
                ". Total duration: " + Notification.getDurationMajorCleanUp());
        Notification.addValueToList(DIV);
    }

    public static void getNotifications() {
        System.out.println("Count of minor garbage collections: " + Notification.getCountMinorCleanUp() +
                ". Total duration: " + Notification.getDurationMinorCleanUp());
        System.out.println("Count of major garbage collections: " + Notification.getCountMajorCleanUp() +
                ". Total duration: " + Notification.getDurationMajorCleanUp());
        System.out.println(DIV);
    }


    public static void printLogs(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        GCMonitor gcMonitor = GCMonitor.getGCMonitor();
        List<String> list = gcMonitor.getList();


        for (int i = 0; i < list.size(); i++)
            fileWriter.write("The name of using GC in application: " + list.get(i) + "\n");
        fileWriter.write("\n" + DIV + "\n");

        for(int i = 0; i < Notification.getList().size(); i++)
            fileWriter.write(Notification.getList().get(i));
        fileWriter.flush();
        fileWriter.close();
    }
}
