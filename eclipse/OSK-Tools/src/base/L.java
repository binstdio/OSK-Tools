package base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class L {
    public static Logger l=Logger.getLogger("OSK_"+getTime());
    private static String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date now = new Date();
        return formatter.format(now);
    }
}
