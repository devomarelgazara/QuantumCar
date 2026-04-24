

public class CarFactory
{

    public enum EngineType {
        GASOLINE,
        ELECTRONIC,
        HYBRID
    }

    public Car createCar(EngineType type) {
        Engine engine = buildEngine(type);
        System.out.println("[CarFactory] Created car with: " + engine.getClass().getSimpleName());
        return new Car(engine);
    }

    public void replaceEngine(Car car, EngineType newType) {
        Engine engine = buildEngine(newType);
        car.setEngine(engine);
    }

    private Engine buildEngine(EngineType type) {
        return switch (type) {
            case GASOLINE -> new GasolineEngine();
            case ELECTRONIC -> new ElectronicEngine();
            case HYBRID -> new MixedHybridEngine();
            default -> throw new IllegalArgumentException("Unknown engine type: " + type);
        };
    }
}