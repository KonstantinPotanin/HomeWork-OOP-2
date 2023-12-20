import Classes.*;

import java.util.List;
import Interfaces.iActorBehavior;

public class App {
    public static void main(String[] args) {
        // Магазин 1
        Market marketWithPromo = new Market(3);

        // Создание участников акции
        iActorBehavior promoClient1 = new PromoClient("Иван", "Promo1");
        iActorBehavior promoClient2 = new PromoClient("Марина", "Promo1");
        iActorBehavior promoClient3 = new PromoClient("Семён", "Promo1");

        marketWithPromo.acceptToMarket(promoClient1);
        marketWithPromo.acceptToMarket(promoClient2);
        marketWithPromo.acceptToMarket(promoClient3);

        marketWithPromo.update();

        // Создание участника акции, которому будет отказано
        iActorBehavior promoClientOverflow = new PromoClient("Яна", "Promo1");

        marketWithPromo.acceptToMarket(promoClientOverflow);

        marketWithPromo.update();
        System.out.println("-------------------------------------------------");

        // Магазин 2
        Market magnetFamily= new Market();

        // Создание обычного клиента который заберёт заказ, а потом вернёт его в магазин
        OrdinaryClient ordinaryClient = new OrdinaryClient("Альберт");

        magnetFamily.acceptToMarket(ordinaryClient);
        magnetFamily.update();
        magnetFamily.giveOrder();
        ordinaryClient.returnOrder(ordinaryClient);
        ordinaryClient.leaveTheMarket(ordinaryClient);

        // Создание VIP клиента который заберёт заказ, а потом вернёт его в магазин
        SpecialClient vipClient = new SpecialClient("Трамп", 1);

        marketWithPromo.acceptToMarket(vipClient);
        marketWithPromo.update();
        marketWithPromo.giveOrder();
        vipClient.returnOrder(vipClient);
        vipClient.leaveTheMarket(vipClient);
        System.out.println("-------------------------------------------------");

        // Магазин 3
        Market magnetAtHome = new Market();

        // Создаем обычного клиента, VIP клиента и инспектора со стандартным поведением в магазине
        iActorBehavior ordinaryClient1 = new OrdinaryClient("Печкин");
        iActorBehavior vipClient1 = new SpecialClient("Матроскин", 2);
        iActorBehavior taxInspector = new TaxInspector();

        magnetAtHome.acceptToMarket(ordinaryClient1);
        magnetAtHome.acceptToMarket(vipClient1);
        magnetAtHome.acceptToMarket(taxInspector);

        magnetAtHome.update();
    }
}

