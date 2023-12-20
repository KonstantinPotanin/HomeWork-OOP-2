package Interfaces;

import Classes.Actor;

/**
 *  Интерфейс в которой объявлен метод для реализации
 *  на возврат заказа
 */
public interface iReturnOrder {
    void returnOrder(Actor actor);
    void leaveTheMarket(Actor actor);
}
