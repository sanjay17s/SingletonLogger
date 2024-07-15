public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of Logger
        Logger logger = Logger.getInstance();

        // Example usage: Logging messages
        logger.log("Application started.");
        logger.log("Processing data...");

        // Simulate some operation
        try {
            Thread.sleep(2000); // Simulate some time-consuming operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.log("Operation completed.");

        // Close the logger when application shuts down
        logger.close();    }
}