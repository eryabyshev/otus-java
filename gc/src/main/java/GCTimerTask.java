import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

public class GCTimerTask extends TimerTask {

    private int count = 0;
    private File file;

    public GCTimerTask(File file){
        this.file = file;
    }


    public void run() {
        Utils.getNotifications();
        Utils.saveNotifations();
        count++;
        if (count == 5) {
            try {
                Utils.printLogs(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            cancel();
        }
    }
}
