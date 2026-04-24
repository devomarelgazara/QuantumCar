
public class MixedHybridEngine implements Engine
{
    private static final int ELECTRIC_THRESHOLD = 50;

    private final GasolineEngine gasolineEngine;
    private final ElectronicEngine electronicEngine;
    private Engine activeEngine;
    private int speed = 0;

    public MixedHybridEngine() {
        this.gasolineEngine = new GasolineEngine();
        this.electronicEngine = new ElectronicEngine();
    }

    @Override
    public void start() {
        // Start at speed 0, so electric is active
        electronicEngine.start();
        activeEngine = electronicEngine;
        speed = 0;
        System.out.println("[MixedHybridEngine] Started. Using ElectronicEngine (speed < " + ELECTRIC_THRESHOLD + ").");
    }

    @Override
    public void stop() {
        activeEngine.stop();
        speed = 0;
        System.out.println("[MixedHybridEngine] Stopped.");
    }

    @Override
    public void increase() {
        activeEngine.increase();
    }

    @Override
    public void decrease() {
        activeEngine.decrease();
    }

    @Override
    public void onSpeedUpdate(int carSpeed) {
        this.speed = carSpeed;
        switchEngineIfNeeded(carSpeed);
        System.out.println("[MixedHybridEngine] Notified of car speed: " + carSpeed + " km/h — Active: "
                + activeEngine.getClass().getSimpleName());
        activeEngine.onSpeedUpdate(carSpeed);
    }

    private void switchEngineIfNeeded(int carSpeed) {
        if (carSpeed < ELECTRIC_THRESHOLD && activeEngine == gasolineEngine) {
            System.out.println("[MixedHybridEngine] Switching to ElectronicEngine (speed below " + ELECTRIC_THRESHOLD + ").");
            gasolineEngine.stop();
            electronicEngine.start();
            activeEngine = electronicEngine;
        } else if (carSpeed >= ELECTRIC_THRESHOLD && activeEngine == electronicEngine) {
            System.out.println("[MixedHybridEngine] Switching to GasolineEngine (speed >= " + ELECTRIC_THRESHOLD + ").");
            electronicEngine.stop();
            gasolineEngine.start();
            activeEngine = gasolineEngine;
        }
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public Engine getActiveEngine() {
        return activeEngine;
    }
}