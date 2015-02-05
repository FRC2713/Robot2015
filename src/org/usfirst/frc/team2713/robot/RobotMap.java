package org.usfirst.frc.team2713.robot;

import edu.wpi.first.wpilibj.Preferences;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
    public static final int LEFT_DRIVE_MOTOR_FRONT = 2;
    public static final int LEFT_DRIVE_MOTOR_BACK = 4;    
    public static final int RIGHT_DRIVE_MOTOR_FRONT = 3;
    public static final int RIGHT_DRIVE_MOTOR_BACK = 5;
    public static final int ARM_MOTOR = 6;
    public static final int GRAB_MOTOR = 7;
    
    public static final int XBOX_PORT = 1;
    
    public static final double GRAB_VOLTAGE_LIMIT = 11;
    public static final double GRAB_RAW_LIMIT = 200;
    
    public static final int AMMOUNT_OF_LIMIT_SWITCHES = 0;
    
    public static final boolean INIT_DRIVE = true;
    public static final boolean INIT_LIFT = false;
    public static final boolean INIT_GRAB = false;
        
    public static final int AMMOUNT_OF_CRATES_TO_GET_IN_AUTONOMOUS = 1;
    
    public static final int ENCODER_B_CHANNEL = 1;
    public static final int ENCODER_A_CHANNEL = 1;




}
