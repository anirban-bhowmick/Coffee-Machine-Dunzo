package enums;

public enum IngredientType {
  SOLID("grams"),
  LIQUID("millilitres");

  String unitOfMeasurement;

  IngredientType(String unitOfMeasurement) {
    this.unitOfMeasurement = unitOfMeasurement;
  }

  public String getUnitOfMeasurement() {
    return unitOfMeasurement;
  }

}
