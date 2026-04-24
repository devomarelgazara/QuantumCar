public class Main {

    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        Car gasCar = factory.createCar(CarFactory.EngineType.GASOLINE);
        gasCar.start();
        gasCar.accelerate();
        gasCar.accelerate();
        gasCar.accelerate();
        gasCar.brake();
        gasCar.brake();
        gasCar.brake();
        gasCar.stop();


        Car electricCar = factory.createCar(CarFactory.EngineType.ELECTRONIC);
        electricCar.start();
        electricCar.accelerate();
        electricCar.accelerate(); // 40
        electricCar.brake();      // 20
        electricCar.brake();      // 0
        electricCar.stop();


        Car hybridCar = factory.createCar(CarFactory.EngineType.HYBRID);
        hybridCar.start();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.brake();
        hybridCar.brake();
        hybridCar.brake();
        hybridCar.brake();
        hybridCar.stop();


        Car car = factory.createCar(CarFactory.EngineType.GASOLINE);
        car.start();
        car.accelerate();  // 20
        // Try replacing while running (should be rejected)
        factory.replaceEngine(car, CarFactory.EngineType.ELECTRONIC);
        car.brake();
        car.stop();
        // Now replace successfully
        factory.replaceEngine(car, CarFactory.EngineType.ELECTRONIC);
        car.start();
        car.accelerate();  // 20
        car.brake();
        car.stop();


        Car edgeCar = factory.createCar(CarFactory.EngineType.GASOLINE);
        edgeCar.start();
        edgeCar.accelerate();       // 20
        edgeCar.stop();             // should be rejected (speed != 0)
        edgeCar.brake();
        edgeCar.stop();
    }
}