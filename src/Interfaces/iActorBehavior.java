package Interfaces;

import Classes.Actor;

/**
 * Интерфейс для границ и чертежа кода для поведения актора в магазине
 * также включает ссылку на класс Актор для реализации проведения класса Инспектор
 */
public interface iActorBehavior {
    // Методы
    public boolean isTakeOrder();
    public boolean isMakeOrder();
    public void setTakeOrder(boolean val);
    public void setMakeOrder(boolean val);
    public Actor getActor();
}
