import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.util.ArrayList;

public class Notification implements NotificationListener {

    private static int countMinorCleanUp = 0;
    private static long durationMinorCleanUp = 0;
    private static int countMajorCleanUp = 0;
    private static int durationMajorCleanUp = 0;
    private static ArrayList<String> list = new ArrayList<String>();

    public static void addValueToList(String s) {
        list.add(s);
    }


    public void handleNotification(javax.management.Notification notification, Object handback) {
        GarbageCollectionNotificationInfo gcni = GarbageCollectionNotificationInfo
                .from((CompositeData) notification.getUserData());

        if(gcni.getGcAction().equals("end of minor GC")){
            countMinorCleanUp++;
            durationMinorCleanUp += gcni.getGcInfo().getDuration();
        }else{
            countMajorCleanUp++;
            durationMajorCleanUp += gcni.getGcInfo().getDuration();
        }
    }

    public static int getCountMinorCleanUp() {
        return countMinorCleanUp;
    }

    public static void setCountMinorCleanUp(int countMinorCleanUp) {
        Notification.countMinorCleanUp = countMinorCleanUp;
    }

    public static long getDurationMinorCleanUp() {
        return durationMinorCleanUp;
    }

    public static void setDurationMinorCleanUp(long durationMinorCleanUp) {
        Notification.durationMinorCleanUp = durationMinorCleanUp;
    }

    public static int getCountMajorCleanUp() {
        return countMajorCleanUp;
    }

    public static void setCountMajorCleanUp(int countMajorCleanUp) {
        Notification.countMajorCleanUp = countMajorCleanUp;
    }

    public static int getDurationMajorCleanUp() {
        return durationMajorCleanUp;
    }

    public static void setDurationMajorCleanUp(int durationMajorCleanUp) {
        Notification.durationMajorCleanUp = durationMajorCleanUp;
    }

    public static ArrayList<String> getList() {
        return list;
    }

    public static void setList(ArrayList<String> list) {
        Notification.list = list;
    }
}
