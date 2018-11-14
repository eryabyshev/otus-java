import javax.management.NotificationEmitter;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class GCMonitor {

    private static Notification notification = new Notification();
    private static List<String> list = new ArrayList<String>();
    private static GCMonitor gcMonitor;


    private GCMonitor() {
        List<GarbageCollectorMXBean> garbageCollectorMXBeanList = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean mxBean : garbageCollectorMXBeanList) {
            list.add(mxBean.getName());
            NotificationEmitter emitter = (NotificationEmitter) mxBean;
            emitter.addNotificationListener(notification, null, null);
        }
    }

    public static GCMonitor getGCMonitor() {
        if(gcMonitor == null)
            return new GCMonitor();
        return gcMonitor;
    }

    public static List<String> getList() {
        return list;
    }


}
