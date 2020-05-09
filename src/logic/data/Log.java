package logic.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private String msg;
    private String logDate;

    public Log(String msg) {
        this.msg = msg;
        logDate = getDateTime();
    }

    public Log(Log clone) {
        this.msg = clone.msg;
        this.logDate = clone.logDate;
    }

    @Override
    public String toString() {
        return logDate + " " + msg;
    }


    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void setTime(String time) {
        this.logDate = time;
    }

    private String getTime() {
        return logDate;
    }
}
