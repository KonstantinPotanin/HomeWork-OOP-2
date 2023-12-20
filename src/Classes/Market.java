package Classes;

import Interfaces.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  Класс описывающий методы из интерфейсов поведения магазина и поведения очереди
 */
public class Market implements iMarketBehavior, iQueueBehavior{
    // Поля
    private List<iActorBehavior> queue;     // Список очереди
    private int maxParticipants;            // Количество участников промо акции

    /**
     * Конструктор для магазина в котором проходит промо акция
     * @param maxParticipants
     */
    public Market(int maxParticipants) {
        this.queue = new ArrayList<iActorBehavior>();
        setMaxParticipants(maxParticipants);
    }

    /**
     * Конструктор для магазина без акций
     */
    public Market() {
        this.queue = new ArrayList<iActorBehavior>();
    }

    // Методы
    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int value) {
        if (value < 1) {
            this.maxParticipants = 1;
        } else this.maxParticipants = value;
    }

    @Override
    public void acceptToMarket(iActorBehavior actor) {
        String logMessage = actor.getActor().getName() + " клиент пришел в магазин ";
        System.out.println(logMessage);
        LogManager.log(logMessage);
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(iActorBehavior actor) {
        if (actor instanceof PromoClient) {
            PromoClient promoClient = (PromoClient) actor;
            if (promoClient.getParticipantsCount() > maxParticipants) {
                String logMessage = "Отказ в обслуживании для акционного клиента " + actor.getActor().getName() +
                        ". Превышено количество участников акции.";
                System.out.println(logMessage);
                LogManager.log(logMessage);
                return;
            }
        }

        this.queue.add(actor);
        String logMessage = actor.getActor().getName() + " клиент добавлен в очередь ";
        System.out.println(logMessage);
        LogManager.log(logMessage);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            String logMessage = actor.getName() + " клиент ушел из магазина ";
            System.out.println(logMessage);
            LogManager.log(logMessage);
            queue.remove(actor);
        }

    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }

    @Override
    public void giveOrder() {
        for (iActorBehavior actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                String logMessage = actor.getActor().getName() + " клиент получил свой заказ ";
                System.out.println(logMessage);
                LogManager.log(logMessage);
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehavior actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                String logMessage = actor.getActor().getName() + " клиент ушел из очереди ";
                System.out.println(logMessage);
                LogManager.log(logMessage);
            }
        }
        releaseFromMarket(releaseActors);
    }

    @Override
    public void takeOrder() {
        for (iActorBehavior actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                String logMessage = actor.getActor().getName() + " клиент сделал заказ ";
                System.out.println(logMessage);
                LogManager.log(logMessage);
            }
        }
    }
}
