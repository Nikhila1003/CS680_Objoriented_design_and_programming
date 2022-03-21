package edu.umb.cs680.hw05;

public class Escalator {

    private State state;
    private static Escalator instance = null;

    private Escalator(State s) {
        state = s;
    }

    public static Escalator getInstance() {
        if(instance == null) {
            State state = Stopped.getInstance();
            instance = new Escalator(state);
        }
        return instance;
    }

    public State getState() {
        return state;
    }

    public void changeState(State newState) {
        state = newState;
    }

    public void startButtonPushed() {
        state.startButtonPushed();
    }

    public void stopButtonPushed() {
        state.stopButtonPushed();
    }

    public void motionDetected() {
        state.motionDetected();
    }

    public void motionNotDetected() {
        state.motionNotDetected();
    }

    public void moveSteps() {
        System.out.println("Move Steps");
    }

    public void stopSteps() {
        System.out.println("Stop Steps");
    }

    public void enableSensor() {
        System.out.println("Enable Sensor");
    }

    public void disableSensor() {
        System.out.println("Disable Sensor");
    }

    public static void main(String[] args) {
        System.out.println("This is Escalator Class");
    }

}
