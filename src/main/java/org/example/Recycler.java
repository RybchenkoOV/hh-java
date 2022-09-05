package org.example;

/**
 * @author oleg on 05.09.2022
 */
public class Recycler<T extends Vehicle> {
  private T vehicle;

  public void setVehicle(T vehicle) {
    this.vehicle = vehicle;
  }

  public double moneyOutput(T vehicle) {
    return vehicle.getVehiclePrice() * 0.5;
  }
}
