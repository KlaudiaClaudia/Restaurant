import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    public final static List<Dish> MENU = List.of(
            new Dish(1,"Pizza Pepperoni", 24.99),
            new Dish(2,"Pizza Margherita", 22.99),
            new Dish(3,"Spaghetti", 20.99),
            new Dish(4,"Schabowy z ziemniakami", 27.99),
            new Dish(5,"Zupa pomidorowa", 10.99),
            new Dish(6,"Frytki", 9.99),
            new Dish(7,"Sałatka Cesar", 17.99),
            new Dish(8,"Kawa z mlekiem", 9.99),
            new Dish(9,"Coca Cola", 6.99),
            new Dish(10,"Sernik", 14.99)
    );
    public static List<Dish> convertIdsToDishes(List<Integer> ids){
        return ids.stream()
                .map(id -> MENU.get(id-1))
                .collect(Collectors.toList());
    };
    // convert list type Integer to list type Dishes
    //user will choose numbers with id dishes and we need list of dishes
}
