package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EscalatorTest {
    
    @Test
    public void StateChangedToStoppedFromStandBy() {
        Escalator instance = Escalator.getInstance();
        instance.changeState(StandBy.getInstance());
        instance.stopButtonPushed();
        State expected = Stopped.getInstance();
        assertEquals(expected, instance.getState());
    }

    @Test
    public void StateChangedToOperatingFromStandByWhenMotionDetected() {
        Escalator instance = Escalator.getInstance();
        instance.changeState(StandBy.getInstance());
        instance.motionDetected();
        State expected = Operating.getInstance();
        assertEquals(expected, instance.getState());
    }

    @Test
    public void StateChangedToOperatingFromStandByWhenStartButtonPressed() {
        Escalator instance = Escalator.getInstance();
        instance.changeState(StandBy.getInstance());
        instance.startButtonPushed();
        State expected = Operating.getInstance();
        assertEquals(expected, instance.getState());
    }

    @Test
    public void StateChangedToStoppedFromOperating() {
        Escalator instance = Escalator.getInstance();
        instance.changeState(Operating.getInstance());
        instance.stopButtonPushed();
        State expected = Stopped.getInstance();
        assertEquals(expected, instance.getState());
    }

    @Test
    public void StateChangedToStandByFromOperating() {
        Escalator instance = Escalator.getInstance();
        instance.changeState(Operating.getInstance());
        instance.motionNotDetected();
        State expected = StandBy.getInstance();
        assertEquals(expected, instance.getState());
    }

}
