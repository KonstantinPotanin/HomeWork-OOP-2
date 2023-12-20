package Classes;

/**
 * Класс описывающий поведение участника акции
 */
public class PromoClient extends Actor{
    // Поля
    private static int participantsCount;   // Счетчик для количества участников акции
    private String promoName;               // Название рекламной акции
    private int clientId;                   // id участника акции

    /**
     *  Конструктор
     * @param name          имя клиента-участника в рекламной акции
     * @param promoName     название рекламной акции
     * новому клиенту присваивается id в соответствии со счетчиком, когда количество участников акции будет равно
     * заданному количеству, всем последующим желающим участникам будет отказ.
     */
    public PromoClient(String name, String promoName) {
        super(name);
        this.promoName = promoName;
        this.clientId = participantsCount + 1;
        participantsCount++;
    }

    // Методы
    public static int getParticipantsCount() {
        return participantsCount;
    }

    public String getPromoName() {
        return promoName;
    }

    public int getClientId() {
        return clientId;
    }

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
