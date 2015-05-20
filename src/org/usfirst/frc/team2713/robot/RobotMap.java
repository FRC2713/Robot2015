 package org.usfirst.frc.team2713.robot;

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
	
	//Competition Motor Layout
    public static final int LEFT_DRIVE_MOTOR_FRONT = 2;
    public static final int LEFT_DRIVE_MOTOR_BACK = 4;    
    public static final int RIGHT_DRIVE_MOTOR_FRONT = 3;
    public static final int RIGHT_DRIVE_MOTOR_BACK = 5;
    public static final int LIFT_MOTOR = 6;
    public static final int GRAB_MOTOR = 7;
	
	//Test Motor Layout
//    public static final int LEFT_DRIVE_MOTOR_FRONT = 6;
//    public static final int LEFT_DRIVE_MOTOR_BACK = 9;    
//    public static final int RIGHT_DRIVE_MOTOR_FRONT = 4;
//    public static final int RIGHT_DRIVE_MOTOR_BACK = 3;
//    public static final int LIFT_MOTOR = 6;
//    public static final int GRAB_MOTOR = 7;
    
    public static final int XBOX_PORT = 1;
    public static final int JOYSTICK_PORT = 2;
    
    public static final boolean INIT_DRIVE = true;
    public static final boolean INIT_LIFT = true;
    public static final boolean INIT_GRAB = true;
        
    public static final int AMMOUNT_OF_CRATES_TO_GET_IN_AUTONOMOUS = 3;
    
    public static final int TIME_TO_CLOSE_OR_OPEN = 1; 
    
    public static final int DRIVE_ENCODER_B_CHANNEL = 5;
    public static final int DRIVE_ENCODER_A_CHANNEL = 4;
    
    public static final int LIFT_ENCODER_A_CHANNEL = 8;
    public static final int LIFT_ENCODER_B_CHANNEL = 9;
        
    public static final int ARM2_LIMIT_SWITCH_NUM = 3;
    public static final int ARM_LIMIT_SWITCH_NUM = 2;
    public static final int BOTTOM_LIMIT_SWITCH_LIFT = 0;
    public static final int TOP_LIMIT_SWITCH_LIFT = 1;
    
    public static final int XBOX_OR_JOYSTICK = 2; //Two means Xbox, One means joystick

    public static double drive_Scaler = .7; 
    public static double drive_Normal_Scaler = .7; 
    public static double drive_Slow_Scaler = .30; 
    
    public static double drive_Slow_Down= .7; 
    public static double drive_Normal_Slow_Down = .7; 
    public static double drive_Slow_Slow_Down = .2; 
    
    public static final int DIPSWITCHCOUNT = 4;
    public static final int DIPSWITCHSTARTPORT = 10;   

}
