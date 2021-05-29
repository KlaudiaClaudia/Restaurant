import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RestaurantController {

    public void mainMenu() {
        printer("Witamy w naszej restauracji: ");
        printMenu();
        printSummary(takeOrder());
        getDishesNumber();
    }

    private void printMenu() {
        printer("Dziś serwujemy: ");
        Menu.MENU.forEach(System.out::println);
        printer("Zamów wybrane potrawy wybierając ich numery po przecinku:");
    }

    //get menu from Menu class
    private Order takeOrder() {
        List<Integer> dishesids = getDishesNumber();
        List<Dish> dishes = Menu.convertIdsToDishes(dishesids);
        return new Order(dishes);
    }
// convert list of numbers to list of dishes

    private void printSummary(Order order) {
        String summary = order.toString();
        printer(summary);
    }

    private List<Integer> getDishesNumber()  {
        boolean optionOk = false;
        List list = null;
        while (!optionOk) {
            try {
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();
                String[] split = line.replaceAll(" ", "").split(",");
                list = Arrays.stream(split)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
                optionOk = true;
            } catch (NumberFormatException e) {
                printer("Złe dane. Spróbuj jeszcze raz");
            }
        }return list;
    }

    // gets id dishes from user
    // deleting space from user order , so it doesnt matter if user provide numbers only with ',' or also with space
    public void printer(String text) {
        System.out.println(text);
    }
}
