package enums;

import java.util.List;

public enum CoffeeType {
  BLACK_COFFEE("Black Coffee", CoffeeStrength.STRONG),
  CAFFE_MOCHA("Caffe Mocha", CoffeeStrength.MILD);

  String name;
  CoffeeStrength coffeeStrength;

  CoffeeType(String name, CoffeeStrength coffeeStrength) {
    this.name = name;
    this.coffeeStrength = coffeeStrength;
  }

  public String getName() {
    return name;
  }

  public CoffeeStrength getCoffeeStrength() {
    return coffeeStrength;
  }

}