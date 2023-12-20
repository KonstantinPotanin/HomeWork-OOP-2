package Classes;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 *  Класс для работы с логированием
 */
public class LogManager {
    // Поле
    private static final Logger logger = Logger.getLogger(LogManager.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("market_log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод
    public static void log(String message) {
        logger.info(message);
    }
}
