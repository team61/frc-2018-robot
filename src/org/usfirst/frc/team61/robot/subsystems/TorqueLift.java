package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TorqueLift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    CANTalon firstMotor = new CANTalon(RobotMap.leftMotorA); 
    CANTalon secondMotor = new CANTalon(RobotMap.leftMotorB);
    CANTalon thirdMotor = new CANTalon(RobotMap.rightMotorA);
    CANTalon fourthMotor = new CANTalon(RobotMap.rightMotorB);
	CANTalon fifthMotor = new CANTalon(RobotMap.liftMotorA);
	CANTalon sixthMotor = new CANTalon(RobotMap.liftMotorB);
	
    public TorqueLift() {
    	super("TorqueLift");
        System.out.println("TorqueLift Initiated");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void moveAllMotors(double speed) {
    	firstMotor.set(-speed);
    	secondMotor.set(-speed);
    	thirdMotor.set(speed);
    	fourthMotor.set(speed);
    	fifthMotor.set(speed);
    	sixthMotor.set(speed);
    }
}

