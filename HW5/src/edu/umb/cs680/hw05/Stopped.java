package edu.umb.cs680.hw05;

public class Stopped implements State {

    private static Stopped instance = null;

    private Stopped() {

    }

    public static Stopped getInstance() {
        if(instance == null) {
            instance = new Stopped();
        }
        return instance;
    }

    public void startButtonPushed() {
        escalator.enableSensor();
        escalator.changeState(StandBy.getInstance());
    }

    public void stopButtonPushed() {
        System.out.println("No Operation");
    }

    public void motionDetected() {
        System.out.println("No Operation");
    }

    public void motionNotDetected() {
        System.out.println("No Operation");
    }

}
