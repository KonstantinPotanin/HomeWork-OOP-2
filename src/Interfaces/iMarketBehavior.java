package Interfaces;

import Classes.Actor;

import java.util.List;

/**
 * Интерфейс в которой объявлены методы для реализации
 * на приход в магазин
 * на выход из магазина
 * на обновление состояния
 */
public interface iMarketBehavior {
    public void acceptToMarket(iActorBehavior actor);
    public void releaseFromMarket(List<Actor> actors);
    public void update();
}
