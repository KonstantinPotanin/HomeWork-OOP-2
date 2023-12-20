package Classes;
import Interfaces.iActorBehavior;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Абстрактный класс описывающий поведение актора
 */
public abstract class Actor implements iActorBehavior {
    // Поля
    protected String name;          // Имя актора
    protected boolean isTakeOrder;  // Флаг для перехода состояний актора
    protected boolean isMakeOrder;  // Флаг для перехода состояний актора
    protected boolean isInsideMarket; // Флаг для перехода состояний актора


    /**
     * Конструктор
     * @param name
     */
    public Actor(String name) {
        this.name = name;
    }

    // Методы, не стал их делать абстрактными, т.к. в классах наследниках они будут неизменными (чтобы не переписывать код)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isInsideMarket() {
        return isInsideMarket;
    }

    public void setInsideMarket(boolean insideMarket) {
        isInsideMarket = insideMarket;
    }
    public void returnOrder(Actor actor) {
        if (isTakeOrder()) {
            setTakeOrder(false);
            setMakeOrder(false); // Сброс заказа
            setInsideMarket(true);
            String logMessage = getName() + " клиент возвратился в магазин и вернул свой заказ ";
            System.out.println(logMessage);
            LogManager.log(logMessage);
        }
    }

    public void leaveTheMarket(Actor actor) {
        setInsideMarket(true);
        String logMessage = getName() + " клиент вышел из магазина ";
        System.out.println(logMessage);
        LogManager.log(logMessage);
    }
}
