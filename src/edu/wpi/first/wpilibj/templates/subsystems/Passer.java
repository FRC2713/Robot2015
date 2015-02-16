package edu.wpi.first.wpilibj.templates.subsystems;
public class Passer {
	
	static int driverStation = 1;
    public static void setNum(int num) {
        driverStation = num;
    }
    public static int getNum() {
        return driverStation;
    }
}
