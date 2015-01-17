package org.usfirst.frc.team2713.robot.subsystems;

import org.usfirst.frc.team2713.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GrabberSubsystem extends Subsystem {
	
	CANJaguar grab;
	
	public GrabberSubsystem() {
		grab = new CANJaguar(RobotMap.GRAB_MOTOR);
	}

	protected void initDefaultCommand() {
		
	}
	
	public void setLift(double polarity) {
		grab.set(polarity);
	}
	
	public double getAmps() {
		return grab.getBusVoltage();
	}

}
