


public interface Engine
{
    void start();
    void stop();
    void increase();
    void decrease();
    void onSpeedUpdate(int carSpeed);
    int getSpeed();
}