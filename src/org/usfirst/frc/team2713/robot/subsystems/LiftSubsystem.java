package org.usfirst.frc.team2713.robot.subsystems;

import org.usfirst.frc.team2713.robot.RobotMap;

import org.usfirst.frc.team2713.robot.UniversalController;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {

	public int currentLevel = 0;
	UniversalController arm;
	public Encoder thisEncoder;
	public int lastPossition = 0;
	public double heightOfArm = 72.8;
	public double pulses = 48;
	public double distancePerRotation = 11.0;
	public double distancePerPulse = distancePerRotation/pulses;
	public final double[] totesLocation;
	public final double toteHeight = 12.1;
	public DigitalInput limitSwitchBottom;
	public DigitalInput limitSwitchTop;
	public boolean atBottom = false;
	public boolean atTop = false;
	public boolean toBeReleased = false;

	public LiftSubsystem() {
		System.out.println(distancePerRotation);
		System.out.println(distancePerPulse);
		arm = new UniversalController(RobotMap.LIFT_MOTOR);
		thisEncoder = new Encoder(RobotMap.LIFT_ENCODER_A_CHANNEL, RobotMap.LIFT_ENCODER_B_CHANNEL);
		thisEncoder.setDistancePerPulse(distancePerPulse * -10);
		thisEncoder.reset();
		totesLocation = new double[6];
		limitSwitchBottom = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH_LIFT);
		limitSwitchTop = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH_LIFT);
		for (int i = 0; i < 6; i++) {
			totesLocation[i] = toteHeight * i;
		}
	}

	public void lift(int polarity) {
		arm.getProperController().set(polarity);
	}

	public void initDefaultCommand() {

	}

}
