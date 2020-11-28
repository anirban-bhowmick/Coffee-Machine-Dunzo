import enums.CoffeeType;
import enums.Ingredient;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

  public static void main(String args[]) {
    Scanner myObj = new Scanner(System.in);

    CoffeeMachine coffeeMachine = new CoffeeMachine(10);
    System.out.println("Choice : 1: Make Coffee, 2: Add Ingredients\n");
    int choice;

    while (true) {
      System.out.println("\nEnter choice: ");
      choice = Integer.parseInt(myObj.nextLine());
      switch (choice) {
        case 1:
          try {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            //Demo task
            Runnable runnableTask = () -> {
              try {
                coffeeMachine.startCoffeePreparation(CoffeeType.BLACK_COFFEE, false);
              } catch (Exception e) {
                System.out.println(e.getMessage());
              }
            };

            for (int i = 0; i < 3; i++) {
              executor.execute(runnableTask);
            }

          } catch (Exception ex) {
            System.out.println(ex.getMessage());
          }
          break;
        case 2:
          HashMap<Ingredient, Integer> ingredients = new HashMap<>();
          ingredients.put(Ingredient.COFFEE, 300);
          ingredients.put(Ingredient.SUGAR, 100);
          ingredients.put(Ingredient.WATER, 5000);
          ingredients.put(Ingredient.MILK, 3000);

          coffeeMachine.addIngredientsToMachine(ingredients);
          break;
        case 3:
          HashMap<Ingredient, Integer> ingredientsPresent = coffeeMachine
              .getCurrentIngredientsAvailable();
          for (Entry mapEntry : ingredientsPresent.entrySet()) {
            Ingredient ingredient = (Ingredient) mapEntry.getKey();
            Integer qty = (Integer) mapEntry.getValue();

            System.out.println(
                ingredient.getName() + ": " + qty + " " + ingredient.getIngredientType()
                    .getUnitOfMeasurement());
          }
          break;
        default:
          System.out.println("Invalid Choice");
          System.exit(1);
          break;
      }
    }

  }

}
