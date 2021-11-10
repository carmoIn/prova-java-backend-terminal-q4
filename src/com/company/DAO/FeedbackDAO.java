package com.company.DAO;

import com.company.model.Feedback;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    private static List<Feedback> feedbackSession = new ArrayList<>();

    public List<Feedback> list() {
        return feedbackSession;
    }

    public Feedback create(Feedback feedback) {
        if (feedback != null) {
            feedbackSession.add(feedback);
            this.writeLog(feedback);
            return feedback;
        }
        return null;
    }

    public void writeLog(Feedback feedback) {
        File logFile = new File("log.txt");
        if(!logFile.isFile()){
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(logFile);
            PrintWriter printWriter  = new PrintWriter(fileWriter);
            printWriter.println(feedback);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
