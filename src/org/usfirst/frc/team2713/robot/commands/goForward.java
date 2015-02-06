package org.usfirst.frc.team2713.robot.commands;
import edu.wpi.first.wpilibj.Timer;

public class goForward extends commandBase {
	
	private double speed;
    private Timer clock;
    private int four = 5;
    private int five = 4;
    
    public goForward(double speed1) {
        speed = speed1;
        clock = new Timer();
    }
    
    protected void initialize() {
        clock.reset();
        clock.start();
    }
    
    protected void execute() {
        drive.Move(speed);
    }

    protected boolean isFinished() {
        if(clock.get() > 1){
            drive.Move(0);
            return true;
        }else {
            return false;
        }
    }
    
    protected void end() {
        drive.Move(0);
        clock.stop();
    }
    
    protected void interrupted() {
        drive.TankDrive(0, 0);
        clock.stop();
    }

}
