package org.example;

/**
 * @author oleg on 04.09.2022
 */
public class Car extends Vehicle implements Ridable, Refuelable, Steerable {
  private String color; // цвет машины
  private int price; // цена машины

  public double getMaxSpeed() {
    return maxSpeed;
  }

  private double maxSpeed; // максимальная скорость

  public int getFuelConsumption() {
    return fuelConsumption;
  }

  public void setFuelConsumption(int fuelConsumption) {
    this.fuelConsumption = fuelConsumption;
  }

  public int getTankCapacity() {
    return tankCapacity;
  }

  public void setTankCapacity(int tankCapacity) {
    this.tankCapacity = tankCapacity;
  }

  private int fuelConsumption; // расход топлива на 100 км
  private int tankCapacity; // емкость бака

  // Store переменные для хранения данных
  private boolean canRideStore;
  private boolean canMoveForwardBackwardStore;
  private boolean canTurnLeftRightStore;
  private String vehicleMarkStore;


  public Car(String color, int price, int maxSpeed, int fuelConsumption, int tankCapacity) {
    this.color = color;
    this.price = price;
    this.maxSpeed = maxSpeed;
    this.fuelConsumption = fuelConsumption;
    this.tankCapacity = tankCapacity;
  }

  public Car(String color, int price, int maxSpeed) {
    this.color = color;
    this.price = price;
    this.maxSpeed = maxSpeed;
  }

  public Car() { // Отдельно создали пустой консруктор, потому что если есть с параметрами, то пустой уже не создастся сам
  }

  @Override
  public double refuel(double time) {
    return time;
  }

  @Override
  public void canRide(boolean isRidable) {
    canRideStore = isRidable;
  }

  @Override
  public void setVehicleMark(String mark) {
    vehicleMarkStore = mark;
  }

  @Override
  public void canTurnLeftRight(boolean turnsLeftRight) {
    canTurnLeftRightStore = turnsLeftRight;
  }

  @Override
  public void canMoveForwardBackward(boolean movesForwardBackward) {
    canMoveForwardBackwardStore = movesForwardBackward;
  }

  public int maxDistanceWithFullTank(int fuelConsumption, int tankCapacity) {
    return tankCapacity / fuelConsumption * 100;
  }

  public void getCarInfo() {
    System.out.println("Это средство передвижения типа " + getType()
        + " которое " + parseBooleanToText(canRideStore) + " ездить, "
        + parseBooleanToText(canMoveForwardBackwardStore) + " двигаться вперед/назад, "
        + parseBooleanToText(canTurnLeftRightStore) + " поворачивать влево/вправо, "
        + " марки " + vehicleMarkStore);

  }

  private String parseBooleanToText(boolean value) {
    if (value) return "может";
    return "не может";
  }
}
