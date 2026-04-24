
public class ElectronicEngine implements Engine
{

    private int speed = 0;
    private boolean running = false;

    @Override
    public void start() {
        running = true;
        speed = 0;
        System.out.println("[ElectronicEngine] Started.");
    }

    @Override
    public void stop() {
        running = false;
        speed = 0;
        System.out.println("[ElectronicEngine] Stopped.");
    }

    @Override
    public void increase() {
        if (running) {
            speed++;
            System.out.println("[ElectronicEngine] Internal speed: " + speed);
        }
    }

    @Override
    public void decrease() {
        if (running && speed > 0) {
            speed--;
            System.out.println("[ElectronicEngine] Internal speed: " + speed);
        }
    }

    @Override
    public void onSpeedUpdate(int carSpeed) {
        System.out.println("[ElectronicEngine] Notified of car speed: " + carSpeed + " km/h");
        increase();
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}