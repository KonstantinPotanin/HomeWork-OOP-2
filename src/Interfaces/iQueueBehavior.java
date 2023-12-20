package Interfaces;

/**
 * Интерфейс в которой объявлены методы для реализации
 * на приход в очередь
 * на выход из очереди
 * на заказ
 * на получение заказа
 */
public interface iQueueBehavior {
    public void takeInQueue(iActorBehavior actor);
    public void releaseFromQueue();
    public void takeOrder();
    public void giveOrder();
}
