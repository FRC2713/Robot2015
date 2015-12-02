package org.usfirst.frc.team2713.robot.subsystems;

import org.usfirst.frc.team2713.robot.commands.MechanumDrive;
import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.SubsystemStorage;
import org.usfirst.frc.team2713.robot.UniversalController;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	public RobotDrive roboDrive;
	UniversalController leftBack;
	UniversalController leftFront;
	UniversalController rightBack;
	UniversalController rightFront;
	public Encoder thisEncoder;
	SubsystemStorage base;

	public DriveSubsystem(SubsystemStorage base) {
		this.base = base;
		if (RobotMap.INIT_DRIVE) {
			leftBack = new UniversalController(RobotMap.LEFT_DRIVE_MOTOR_BACK, false);
			leftFront = new UniversalController(RobotMap.LEFT_DRIVE_MOTOR_FRONT, true);
			rightBack = new UniversalController(RobotMap.RIGHT_DRIVE_MOTOR_BACK, false);
			rightFront = new UniversalController(RobotMap.RIGHT_DRIVE_MOTOR_FRONT, true);
			roboDrive = new RobotDrive(rightFront.getProperController(), rightBack.getProperController(), leftFront.getProperController(), leftBack.getProperController());
			roboDrive.setInvertedMotor(MotorType.kFrontLeft, false); // invert the left side motors
			roboDrive.setInvertedMotor(MotorType.kRearLeft, true); // you may need to change or remove this to match your robot
			roboDrive.setInvertedMotor(MotorType.kFrontRight, true);
			roboDrive.setInvertedMotor(MotorType.kRearRight, false);
			roboDrive.setExpiration(0.1);
			roboDrive.setSafetyEnabled(false);
			thisEncoder = new Encoder(RobotMap.DRIVE_ENCODER_A_CHANNEL, RobotMap.DRIVE_ENCODER_B_CHANNEL);
			thisEncoder.setDistancePerPulse(18.4);
		}
	}

	public void startCommand() {
		if (RobotMap.INIT_DRIVE) {
			 new MechanumDrive(base).start();
		}
	}

	public void TankDrive(double left, double right) { // left value, right value
		roboDrive.tankDrive(left, right); // Must plug in axes' values, not the actual Joystick
	}

	public void TankDrive(double left, double right, double deadban) { // left value, right value
		double ban = deadban;
		roboDrive.tankDrive(calcDeadban(left, ban), calcDeadban(right, ban)); // Must plug in axes' values, not the actual Joystick
	}

	public void ArcadeDrive(Joystick joystick1) { // left value, right value
		roboDrive.arcadeDrive(joystick1); // Must plug in axes' values, not the actual Joystick
	}

	public void ManualeArcadeDrice(double move, double rotate) {
		roboDrive.arcadeDrive(move, rotate);
	}

	public void ManualeArcadeDrice(double move, double rotate, double deadban) {
		double ban = deadban;
		roboDrive.arcadeDrive(calcDeadban(move, ban), calcDeadban(rotate, ban));
	}

	public void CartesianDrive(double x, double y, double rotate, double deadban) {
		double ban = deadban;
		roboDrive.mecanumDrive_Cartesian(calcDeadban(x, ban), calcDeadban(y, ban), calcDeadban(rotate, ban), 0);
	}

	private double calcDeadban(double value, double deadban) {
		int sign = (value > 0 ? 1 : -1); // checks the sign of the value
		value *= sign; // changes the value to positive
		if (value <= deadban) {
			return 0.0; // returns 0 if it is less than deadban
		} else {
			return (value - deadban) * sign; // returns vale minus deadban
		}
	}

	@Override
	protected void initDefaultCommand() {

	}
	
	public void rotate(double speed) {
		rightFront.getProperController().set(speed);
		rightBack.getProperController().set(speed);
		leftFront.getProperController().set(speed);
		leftBack.getProperController().set(speed);
	}

	public void move(double speed) {
		rightFront.getProperController().set(speed);
		rightBack.getProperController().set(-speed);
		leftFront.getProperController().set(-speed);
		leftBack.getProperController().set(speed);
	}

}
