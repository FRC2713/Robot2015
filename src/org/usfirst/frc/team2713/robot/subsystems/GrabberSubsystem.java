package org.usfirst.frc.team2713.robot.subsystems;

import org.usfirst.frc.team2713.robot.RobotMap;

import org.usfirst.frc.team2713.robot.UniversalController;
import org.usfirst.frc.team2713.robot.commands.moveGrabber;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GrabberSubsystem extends Subsystem {

	public UniversalController grab;
	moveGrabber graberCommand;
	public DigitalInput armClosed;

	public GrabberSubsystem() {
		grab = new UniversalController(RobotMap.GRAB_MOTOR);
		if (armClosed == null) {
			armClosed = new DigitalInput(RobotMap.ARM_LIMIT_SWITCH_NUM);
		}
	}
	
	public void startCommand() {
		new moveGrabber().start();
	}

	protected void initDefaultCommand() {
		
	}

	public void setLift(double polarity) {
		grab.getProperController().set(polarity);
	}

	public double getAmps() {
		return ((CANJaguar) grab.getProperController()).getBusVoltage();
	}

	public double getRaw() {
		return ((Talon) grab.getProperController()).getRaw();
	}

}
