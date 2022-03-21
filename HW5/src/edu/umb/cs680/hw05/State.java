package edu.umb.cs680.hw05;

public interface State {

    Escalator escalator = Escalator.getInstance();

    void startButtonPushed();
    void stopButtonPushed();
    void motionDetected();
    void motionNotDetected();

}
