import enums.CoffeeStrength;
import enums.CoffeeType;
import enums.Ingredient;
import java.util.HashMap;

public class Coffee {

  CoffeeType coffeeType;
  HashMap<Ingredient, Integer> ingredients = new HashMap<>();

  public Coffee(CoffeeType coffeeType) {
    this.coffeeType = coffeeType;
  }

  public void setTheIngredients(boolean allowUserInput) {
    if (allowUserInput) {
      //take user input for the ingredients

    } else {
      CoffeeStrength coffeeStrength = coffeeType.getCoffeeStrength();
      if (coffeeStrength == CoffeeStrength.STRONG) {
        ingredients.put(Ingredient.COFFEE, 100);
        ingredients.put(Ingredient.SUGAR, 10);
        ingredients.put(Ingredient.WATER, 70);
      } else if (coffeeStrength == CoffeeStrength.MILD) {
        ingredients.put(Ingredient.COFFEE, 70);
        ingredients.put(Ingredient.SUGAR, 10);
        ingredients.put(Ingredient.WATER, 50);
        ingredients.put(Ingredient.MILK, 30);
      }
    }
  }


  public HashMap<Ingredient, Integer> getTheIngredients() {
    return ingredients;
  }

}
