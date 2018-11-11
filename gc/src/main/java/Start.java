import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class Start {

    private static int TIME = 60_000;
    private static int MIN_MEMORY = 125_000;
    private static int MAX_MEMORY = 250_000;
    private static String DEFAULT_PATH = "src/main/resources/log.txt";

    public static void main(String[] args) throws InterruptedException {

        GCMonitor.getGCMonitor();
        String path;

        if(args.length != 1){
            Console console = System.console();
            if(console != null)
                path = console.readLine("Enter path to log file : ");
            else
                path = DEFAULT_PATH;
        }else{
            path = args[0];
        }

        File file = new File(path);


        TimerTask timerTask = new GCTimerTask(file);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, TIME, TIME);

        List<String> list = new ArrayList<>();
        while (true) {
            Utils.fillList(list, MAX_MEMORY, MIN_MEMORY);
            Thread.sleep(9_000);
        }






    }

}
