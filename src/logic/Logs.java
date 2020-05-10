package logic;

import java.util.ArrayList;

public class Logs {
    static ArrayList<String>  logs;

    public Logs(){
        this.logs = new ArrayList<>();
    }

    public static void putLog(String log){
        logs.add(log);
    }

    public static String getLastLog(){
        return logs.get(logs.size() - 1);
    }
}
