package enums;

public enum Ingredient {
  COFFEE("Coffee", IngredientType.SOLID),
  WATER("Water", IngredientType.LIQUID),
  MILK("Milk", IngredientType.LIQUID),
  SUGAR("Sugar", IngredientType.SOLID);

  String name;
  IngredientType ingredientType;

  Ingredient(String name, IngredientType type) {
    this.ingredientType = type;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public IngredientType getIngredientType() {
    return ingredientType;
  }

}
