import enums.CoffeeType;
import enums.Ingredient;
import java.util.HashMap;
import java.util.Map.Entry;

public class CoffeeMachine {

  int outlets;
  HashMap<Ingredient, Integer> ingredientsPresent = new HashMap<>();

  public CoffeeMachine(int outlets) {
    this.outlets = outlets;
  }

  private void deductIngredientsFromMachine(HashMap<Ingredient, Integer> ingredients) {
    System.out.println("Ingredients will be picked for the coffee here");
    for (Entry mapEntry : ingredients.entrySet()) {
      Ingredient ingredient = (Ingredient) mapEntry.getKey();
      Integer qty = (Integer) mapEntry.getValue();

      Integer currentQty = ingredientsPresent.get(ingredient);
      ingredientsPresent.put(ingredient, currentQty - qty);
    }

    ingredientsPresent.values().removeIf(f -> f == 0);

  }

  private void checkIngredientsAvailability(HashMap<Ingredient, Integer> ingredientsRequired)
      throws Exception {
    System.out.println("Checking ingredients availability");
    for (Entry mapEntry : ingredientsRequired.entrySet()) {
      Ingredient ingredientRequired = (Ingredient) mapEntry.getKey();
      Integer qtyRequired = (Integer) mapEntry.getValue();

      if (!ingredientsPresent.containsKey(ingredientRequired)) {
        throwAlertOnLowItemAvailable(ingredientRequired);
      } else {
        Integer qtyPresent = ingredientsPresent.get(ingredientRequired);
        if (qtyPresent < qtyRequired) {
          throwAlertOnLowItemAvailable(ingredientRequired);
        }
      }
    }
  }

  public HashMap<Ingredient, Integer> getCurrentIngredientsAvailable() {
    return ingredientsPresent;
  }

  public void startCoffeePreparation(CoffeeType coffeeType, boolean isUserInoutForIngredients)
      throws Exception {
    System.out.println("Starting coffee preparation");
    Coffee coffee = new Coffee(coffeeType);
    coffee.setTheIngredients(isUserInoutForIngredients);
    HashMap<Ingredient, Integer> ingredientsRequired = coffee.getTheIngredients();

    checkIngredientsAvailability(ingredientsRequired);
    deductIngredientsFromMachine(ingredientsRequired);

    System.out.println("Coffee was made using: ");
    for (Entry mapEntry : ingredientsRequired.entrySet()) {
      Ingredient ingredient = (Ingredient) mapEntry.getKey();
      Integer qty = (Integer) mapEntry.getValue();
      System.out.println(
          ingredient.getName() + ": " + qty + " " + ingredient.getIngredientType()
              .getUnitOfMeasurement());
    }


  }

  public void addIngredientsToMachine(HashMap<Ingredient, Integer> ingredients) {
    for (Entry mapEntry : ingredients.entrySet()) {
      Ingredient ingredient = (Ingredient) mapEntry.getKey();
      Integer qty = (Integer) mapEntry.getValue();

      Integer newQty = ingredientsPresent.getOrDefault(ingredient, 0) + qty;
      ingredientsPresent.put(ingredient, newQty);
      System.out.println("New quantity for " + ingredient.getName() + ": " + newQty);

    }
  }

  public void throwAlertOnLowItemAvailable(Ingredient ingredient) throws Exception {
    throw new Exception("Please refill " + ingredient.getName());
  }

}
