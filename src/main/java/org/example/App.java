package org.example;

/**
 * @author oleg on 04.09.2022
 */
public class App {
  private static String carColor;
  private static int carPrice;
  private static int carSpeed;

  public static void main(String[] args) {
    // Для примера определим параметры одной из машин в теле метода main
    carColor = "red";
    carPrice = 1000000;
    carSpeed = 100;
    // Здесь просто создали какую-то машину из данных в классе, причем частичо через прямые параметры в конструкторе
    Car car1 = new Car(carColor, carPrice, carSpeed, 6, 40);
    // Сетим данные для машин
    car1.setType("Car");
    car1.canRide(true);
    car1.canMoveForwardBackward(true);
    car1.canTurnLeftRight(true);
    car1.setVehicleMark("Lada");

    // Соберем все остальные средства передвижения методами setCarData и setTrainData и присвоим данные участникам
    Car carCompetitor = setCarData();
    Train trainCompetitor = setTrainData();

    /**
     * А теперь соревнование. Соревнуются car2 и train.
     * Кто быстрее пройдет трассу.
     * Поезд едет по прямой 1000 км, на пути у него 1 подъем (200м). На подъеме скорость падает на 20%
     * Автомобиль едет 1000 км, на пути у него 2 поворота (100м). На поворотах скорость падает на 20%
     * Также на пути у автомобиля может потребоваться дозаправка, которая занимает 10 мин.
     */

    // Рассчитаем на сколько хватит бака у машины

    int totalDistanceWithoutRefuel = carCompetitor.maxDistanceWithFullTank(carCompetitor
        .getFuelConsumption(), carCompetitor.getTankCapacity());
    System.out.println("Машина с полным баком пройдет: " + totalDistanceWithoutRefuel);

    Track track = new Track();

    // Рассчитываем машину
    int totalRefuels = track.DESTINATION / totalDistanceWithoutRefuel;
    System.out.println("Кол-во дозавпавок машины: " + totalRefuels);
    double totalTimeOnRefuels = (double) totalRefuels * track.refuel(track.REFUEL_TIME);
    System.out.println("Время, потраченное на дозаправку машины : " + totalTimeOnRefuels);
    double carSpeedOnTurns = carCompetitor.getMaxSpeed() * 0.8;
    System.out.println("Скорость машины на подъемах составит: " + carSpeedOnTurns);
    track.totalCarTime = ((track.DESTINATION - (track.DISTANCE_ON_TURN * track.TURNS_COUNT)) / carCompetitor.getMaxSpeed())
        + ((track.DISTANCE_ON_TURN * track.TURNS_COUNT) / carSpeedOnTurns) + totalTimeOnRefuels;
    System.out.println("Итого время машины: " + track.totalCarTime + " ч.");

    // Рассчитываем поезд
    double trainSpeedOnIncline = trainCompetitor.getMaxSpeed() * 0.8;
    System.out.println("Скорость поезда на подъемах составит: " + trainSpeedOnIncline);
    track.totalTrainTime = ((track.DESTINATION - (track.INCLINE_DISTANCE * track.UPHILLS_COUNT)) / trainCompetitor.getMaxSpeed())
        + (track.INCLINE_DISTANCE / trainSpeedOnIncline);
    System.out.println("Итого время поезда: " + track.totalTrainTime + " ч.");

    // И победитель:
    System.out.println(track.andTheWinnerIs(track.totalCarTime, track.totalTrainTime));

    System.out.println("Инфо о победителе:");
    carCompetitor.getCarInfo();
  }


  // Объявляем вложенный класс (не было много времени на создание полноценной модели)
  public static class Track implements Refuelable {
    private final int DESTINATION = 1000;
    private final int DISTANCE_ON_TURN = 100;
    private final int INCLINE_DISTANCE = 200;
    private final double REFUEL_TIME = 0.25;
    private final byte UPHILLS_COUNT = 1;
    private final byte TURNS_COUNT = 2;
    private double totalTrainTime;
    private double totalCarTime;

    public String andTheWinnerIs(double totalCarTime, double totalTrainTime) {
      return (totalCarTime > totalTrainTime) ? "Поезд победил!" : "Машина победила";
    }


    @Override
    public double refuel(double time) {
      return time;
    }
  }

  private static Car setCarData() {
    // Создали машину полностью через конструктор
    Car car2 = new Car("blue", 2000000, 180, 10, 70);
    car2.setType("Car");
    car2.canRide(true);
    car2.canMoveForwardBackward(true);
    car2.canTurnLeftRight(true);
    car2.setVehicleMark("Nissan");

    return car2;
  }

  private static Train setTrainData() {
    Train train = new Train(); // Создаем поезд через дефолтный конструктор
    train.canRide(true);
    train.canMoveForwardBackward(true);
    train.canTurnLeftRight(false);
    train.setMaxSpeed(100); // Т.к. в конструкторе нет явного определения скорости и параметр приватный, используем сеттер
    return train;
  }


}
