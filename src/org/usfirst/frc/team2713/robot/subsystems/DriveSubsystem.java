package org.usfirst.frc.team2713.robot.subsystems;

import org.usfirst.frc.team2713.robot.OI;
import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.commands.commandBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveSubsystem extends Subsystem {
	
    
    RobotDrive roboDrive;
    
    public void initDefaultCommand() {
    	
    }
    
    public DriveSubsystem(){
    	roboDrive.setExpiration(0.1);
    	roboDrive = new RobotDrive(RobotMap.RIGHT_DRIVE_MOTOR_ALPHA, RobotMap.RIGHT_DRIVE_MOTOR_BETA, RobotMap.LEFT_DRIVE_MOTOR_ALPHA, RobotMap.LEFT_DRIVE_MOTOR_BETA);
        roboDrive.setInvertedMotor(MotorType.kFrontLeft, true);	// invert the left side motors
        roboDrive.setInvertedMotor(MotorType.kRearLeft, true);		// you may need to change or remove this to match your robot
        mechanumDrive();
         
    }
    
    public void mechanumDrive() {
    	roboDrive.mecanumDrive_Cartesian(OI.xbox.getX(), OI.xbox.getY(), OI.xbox.getZ(), 0);
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
    
    private double calcDeadban(double value, double deadban) {
        int sign = (value > 0 ? 1 : -1);                //checks the sign of the value
        value *= sign;                                  //changes the value to positive
        if(value <= deadban) {                          
            return 0.0;                                 //returns 0 if it is less than deadban
        } else{
            return (value - deadban) * sign;            //returns vale minus deadban
        }
    }
    
    public void Move(double speed){
        roboDrive.drive(speed, 0);
    }
}
