import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Singleton Logger class
public class Logger {
    private static Logger instance = null;
    private PrintWriter logFile;

    // Private constructor to prevent instantiation outside this class
    private Logger() {
        try {
            // Open log file for appending
            logFile = new PrintWriter(new FileWriter("application.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Static method to get the singleton instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        // Get current timestamp
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format message with timestamp
        String formattedMessage = timestamp.format(formatter) + " - " + message;

        // Write to log file
        logFile.println(formattedMessage);
        logFile.flush(); // Ensure the message is written immediately (flush the buffer)
    }

    // Method to close the log file
    public void close() {
        logFile.close();
    }
}
