package org.usfirst.frc.team2713.robot.subsystems;

import org.usfirst.frc.team2713.robot.commands.mechanumDrive;
import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.UniversalController;

import edu.wpi.first.wpilibj.CANJaguar;
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
    mechanumDrive driveCommand;
    
    public void initMechanumDrive() {
        mechanumDrive();
    }
    
    public DriveSubsystem(){
    	leftBack = new UniversalController(RobotMap.LEFT_DRIVE_MOTOR_BACK);
    	leftFront = new UniversalController(RobotMap.LEFT_DRIVE_MOTOR_FRONT);
    	rightBack = new UniversalController(RobotMap.RIGHT_DRIVE_MOTOR_BACK);
    	rightFront = new UniversalController(RobotMap.RIGHT_DRIVE_MOTOR_FRONT);
    	roboDrive = new RobotDrive(rightFront.getProperController(),rightBack.getProperController(),leftFront.getProperController(),leftBack.getProperController());
    	roboDrive.setInvertedMotor(MotorType.kFrontLeft, true);	// invert the left side motors
    	roboDrive.setInvertedMotor(MotorType.kRearLeft, true); // you may need to change or remove this to match your robot
    	roboDrive.setInvertedMotor(MotorType.kFrontRight, false);
    	roboDrive.setInvertedMotor(MotorType.kRearRight, false);
        roboDrive.setExpiration(0.1);
         
    }
    
    public void mechanumDrive() {
        roboDrive.setSafetyEnabled(true);
    	driveCommand = new mechanumDrive();
    	driveCommand.start();
    }
    
    public void TankDrive(double left, double right){ //left value, right value 
        roboDrive.tankDrive(left, right);              //Must plug in axes' values, not the actual Joystick
    }
    
    public void TankDrive(double left, double right, double deadban){ //left value, right value 
        double ban = deadban;
        roboDrive.tankDrive(calcDeadban(left, ban), calcDeadban(right, ban));              //Must plug in axes' values, not the actual Joystick
    }
    
    public void ArcadeDrive(Joystick joystick1){ //left value, right value 
        roboDrive.arcadeDrive(joystick1); //Must plug in axes' values, not the actual Joystick
    }
    
    public void ManualeArcadeDrice(double move, double rotate){
        roboDrive.arcadeDrive(move, rotate);
    }
    
    public void ManualeArcadeDrice(double move, double rotate, double deadban){
        double ban = deadban;
        roboDrive.arcadeDrive(calcDeadban(move, ban), calcDeadban(rotate, ban));
    }
    
    public void CartesianDrive(double x, double y, double rotate, double deadban){
    	double ban = deadban;
    	roboDrive.mecanumDrive_Cartesian(calcDeadban(x, ban), calcDeadban(y,ban), calcDeadban(rotate,ban), 0);
    }
    
    
    
    private double calcDeadban(double value, double deadban) {
        int sign = (value > 0 ? 1 : -1);                //checks the sign of the value
        value *= sign;                                  //changes the value to positive
        if(value <= deadban) {                          
            return 0.0;                                 //returns 0 if it is less than deadban
        } else{
            return (value - deadban) * sign;            //returns vale minus deadban
        }
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
    
}


