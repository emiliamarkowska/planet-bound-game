package logic.data;

import java.util.ArrayList;
import java.util.List;

public class LogRecorder {
    private List<Log> logs;
    private List<Log> unreadLogs;

    public LogRecorder() {
        logs = new ArrayList<>();
        unreadLogs = new ArrayList<>();
    }

    public void addLog(Log log) {
        logs.add(log);
        unreadLogs.add(log);
    }

    public void addLog(String msg) {
        logs.add(new Log(msg));
        unreadLogs.add(new Log(msg));
    }

    public Log getLastLog() {
        return logs.get(logs.size() - 1);
    }

    public List<Log> getFewLastLogs(int amount) {
        if (amount > logs.size()) return logs;
        return logs.subList(logs.size() - 1 - amount, logs.size() - 1);
    }

    public List<Log> getAllLogs() {
        return logs;
    }

    public List<Log> getUnreadLogs() {
        List<Log> copyLogList = new ArrayList<>();
        for (Log l : unreadLogs) {
            copyLogList.add(new Log(l));
        }
        unreadLogs.clear();
        return copyLogList;
    }
}
