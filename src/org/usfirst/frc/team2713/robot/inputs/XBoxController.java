/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2713.robot.inputs;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Finn
 */
public class XBoxController extends Joystick {
    
    public XBoxController(final int port) {
        super(port);
    }

    public double getLeftX() {
        return getX();
    }

    public double getLeftY() {
        return getY();
    }

    public double getRightX() {
        return getRawAxis(4);
    }

    public double getRightY() {
        return getRawAxis(5);
    }
    
    public double getTriggerAxis() {
        return getRawAxis(3);
    }
    
    public double getDpadX() {
        return getRawAxis(6);
    }
    
    public double getDpadY() {
        return getRawAxis(7);
    }

    public boolean getButtonA() {
        return getRawButton(1);
    }

    public boolean getButtonB() {
        return getRawButton(2);
    }

    public boolean getButtonX() {
        return getRawButton(3);
    }

    public boolean getButtonY() {
        return getRawButton(4);
    }
    
    public boolean getLeftBumper() {
        return getRawButton(5);
    }

    public boolean getRightBumper() {
        return getRawButton(6);
    }
    
    public boolean getStart() {
        return getRawButton(8);
    }
    
    public boolean getBack() {
        return getRawButton(7);
    }
    
    public boolean getLeftStickButton() {
        return getRawButton(9);
    }
    
    public boolean getRightStickButton() {
        return getRawButton(10);
    }
    
}
