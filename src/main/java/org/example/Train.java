package org.example;

/**
 * @author oleg on 04.09.2022
 */
public class Train extends Vehicle implements Ridable, Steerable{

  private int maxSpeed;

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  private boolean canRideStore;
  private boolean canMoveForwardBackwardStore;
  private boolean canTurnLeftRightStore;
  private String vehicleMarkStore;

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
}
