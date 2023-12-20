package Classes;

import Interfaces.iActorBehavior;

/**
 *  Класс описывающий поведение инспектора в магазине
 */
public class TaxInspector implements iActorBehavior {
    // Поля
    private String name;            // Имя актора
    private boolean isTakeOrder;    // Флаг для перехода состояний инспектора
    private boolean isMakeOrder;    // Флаг для перехода состояний инспектора

    /**
     * Конструктор
     */
    public TaxInspector() {
        this.name = "Tax audit";
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
        this.isTakeOrder = val;
    }

    @Override
    public void setMakeOrder(boolean val) {
        this.isMakeOrder = val;
    }

    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }
}
