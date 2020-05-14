package logic;

import java.util.ArrayList;
import java.util.List;

public class Logs {

    public class Log{
        String log;
        boolean isToBeDisplayed;

        public Log(String message){
            this.log = message;
            isToBeDisplayed = true;
        }
    }

    public List<Log> logs;

    public Logs(){
        this.logs = new ArrayList<>();
    }

    public void putLog(String log){
        logs.add(new Log(log));
    }

    public String getLastLog(){
        return logs.get(logs.size() - 1).log;
    }

    public List<String> currentLogs(){
        List<String> logsToBeDisplayed = new ArrayList<>();
        for(Log l : this.logs)
            if(l.isToBeDisplayed == true){
                Log logToBeAdded = new Log(l.log);
                logsToBeDisplayed.add(logToBeAdded.log);
            }
        for(Log l : this.logs)
            l.isToBeDisplayed = false;
                return logsToBeDisplayed;
    }
}
