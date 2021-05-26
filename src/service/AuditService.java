package service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AuditService {
    private PrintWriter logger;
    final String filepath = "reports/log.csv";

    public AuditService() {
        try {
            logger = new PrintWriter(new FileWriter(filepath, true));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to initialize the logging service!");
        }
    }

    public void close() {
        logger.close();
    }

    public void log(String event) {
        logger.write(event + ", " + new Date().toString() + "\n");
    }
}
