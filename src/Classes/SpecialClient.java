package Classes;

import Interfaces.iReturnOrder;

/**
 * Класс описывающий поведение vip клиента
 */
public class SpecialClient extends Actor implements iReturnOrder {
    // Поле
    private int idVIP;      // id клиента

    /**
     * Конструктор
     * @param name
     * @param idVIP
     */
    public SpecialClient(String name, int idVIP) {
        super(name);
        this.idVIP = idVIP;
    }

    // Методы
    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public void setTakeOrder(boolean val) {
        super.isTakeOrder = val;
    }

    @Override
    public void setMakeOrder(boolean val) {
        super.isMakeOrder = val;
    }

    @Override
    public Actor getActor() {
        return this;
    }
}
