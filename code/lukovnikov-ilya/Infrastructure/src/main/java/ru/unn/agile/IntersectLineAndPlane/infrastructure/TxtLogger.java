package ru.unn.agile.IntersectLineAndPlane.infrastructure;

import ru.unn.agile.IntersectLineAndPlane.viewmodel.ILogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TxtLogger implements ILogger {
    private static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
    private final BufferedWriter writer;
    private final String filename;

    private static String now() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW, Locale.ENGLISH);
        return sdf.format(calendar.getTime());
    }

    public TxtLogger(final String fileName) {
        this.filename = fileName;

        BufferedWriter logwriter = null;
        try {
            logwriter = new BufferedWriter(new FileWriter(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer = logwriter;
    }

    @Override
    public void log(final String string) {
        try {
            writer.write(now() + " > " + string);
            writer.newLine();
            writer.flush();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public List<String> getLog() {
        BufferedReader read;
        ArrayList<String> log = new ArrayList<String>();
        try {
            read = new BufferedReader(new FileReader(filename));
            String line = read.readLine();

            while (line != null) {
                log.add(line);
                line = read.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return log;
    }
}
