package edu.umb.cs680.hw05;

public class Operating implements State {

    private static Operating instance = null;

    private Operating() {
    }

    public static Operating getInstance() {
        if(instance == null) {
            instance = new Operating();
        }
        return instance;
    }

    public void startButtonPushed() {
        System.out.println("No Operation");
    }

    public void stopButtonPushed() {
        escalator.stopSteps();
        escalator.disableSensor();
        escalator.changeState(Stopped.getInstance());
    }

    public void motionDetected() {
        System.out.println("No Operation");
    }

    public void motionNotDetected() {
        escalator.stopSteps();
        escalator.changeState(StandBy.getInstance());
    }

}
