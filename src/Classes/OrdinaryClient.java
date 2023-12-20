package Classes;

import Interfaces.iReturnOrder;

/**
 *  Класс описывающий поведение обычного клиента
 */
public class OrdinaryClient extends Actor implements iReturnOrder{

    /**
     * Конструктор
     *
     * @param name
     */
    public OrdinaryClient(String name) {
        super(name);
    }

    // Методы
    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
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
