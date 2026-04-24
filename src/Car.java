public class Car {
    private static final int MAX_SPEED = 200;
    private static final int SPEED_STEP = 20;

    private Engine engine;
    private int speed = 0;
    private boolean started = false;

    public Car(Engine engine) {
        this.engine = engine;
    }

    // Allows easy engine replacement (Strategy Pattern)
    public void setEngine(Engine engine) {
        if (started) {
            System.out.println("[Car] Cannot replace engine while car is running. Please stop first.");
            return;
        }
        this.engine = engine;
        System.out.println("[Car] Engine replaced with: " + engine.getClass().getSimpleName());
    }

    public Engine getEngine() {
        return engine;
    }

    public void start() {
        if (started) {
            System.out.println("[Car] Already started.");
            return;
        }
        engine.start();
        speed = 0;
        started = true;
        System.out.println("[Car] Car started at speed: " + speed + " km/h\n");
    }

    public void stop() {
        if (!started) {
            System.out.println("[Car] Car is not running.");
            return;
        }
        if (speed != 0) {
            System.out.println("[Car] Cannot stop: speed must be 0 before stopping. Current speed: " + speed + " km/h");
            return;
        }
        engine.stop();
        started = false;
        System.out.println("[Car] Car stopped.\n");
    }

    public void accelerate() {
        if (!started) {
            System.out.println("[Car] Car is not started.");
            return;
        }
        if (speed >= MAX_SPEED) {
            System.out.println("[Car] Already at maximum speed: " + MAX_SPEED + " km/h");
            return;
        }
        speed += SPEED_STEP;
        System.out.println("[Car] Accelerating → speed: " + speed + " km/h");
        engine.onSpeedUpdate(speed);
        System.out.println();
    }

    public void brake() {
        if (!started) {
            System.out.println("[Car] Car is not started.");
            return;
        }
        if (speed <= 0) {
            System.out.println("[Car] Already at 0 km/h.");
            return;
        }
        speed -= SPEED_STEP;
        System.out.println("[Car] Braking → speed: " + speed + " km/h");
        engine.onSpeedUpdate(speed);
        System.out.println();
    }

    public int getSpeed() {
        return speed;
    }
}