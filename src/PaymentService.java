import java.util.List;

public class PaymentService {
    private static final double TIP_MARGIN = 100;
    private static final double LOWER_TIP = 0.1;
    private static final double HIGHER_TIP = 0.15;

    public static double calculateServiceCost(double price){
        if (price < TIP_MARGIN){
            return price*HIGHER_TIP;
        }else
            return price*LOWER_TIP;
    }
    //calculate amount of tip that user need to pay
    public static double calculateDishesSum(List<Dish>dishes){
        return dishes.stream().mapToDouble(Dish::getPrice).sum();
    }
    //return summary of all the dishes that user order
}
