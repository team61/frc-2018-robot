package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;
import org.usfirst.frc.team61.robot.commands.DriveWithJoysticks;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;


/**
 * The DriveTrain Subsystem
 */
public class DriveTrain extends Subsystem {
//	private Encoder driveEncoder = new Encoder(RobotMap.driveEncoderA, RobotMap.driveEncoderB);

	private AnalogGyro mainGyro = new AnalogGyro(RobotMap.mainGyro);
	
    CANTalon firstLeftMotor = new CANTalon(RobotMap.mLeftA); 
    CANTalon secondLeftMotor = new CANTalon(RobotMap.mLeftB);
    CANTalon firstRightMotor = new CANTalon(RobotMap.mRightA);
    CANTalon secondRightMotor = new CANTalon(RobotMap.mRightB);
    
    // Initialize the subsystem
    public DriveTrain() {
    	super("DriveTrain");
        System.out.println("DriveTrain Initiated");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    /**
     * Tank-drive controls.
     * @author Team 61 Programming
     * @param left Left motor value or motor stack value
     * @param right Right motor value or motor stack value
     */
    public void tankDrive(double left, double right) {
        moveLeftMotorStack(left);
        moveRightMotorStack(right);
    }
    
    /**
     * Reversed tank-drive controls.
     * @author Team 61 Programming
     * @param left Left motor value or motor stack value
     * @param right Right motor value or motor stack value
     */
    public void reverseTankDrive(double right, double left) {
        moveRightMotorStack(right);
        moveLeftMotorStack(left);
    }
    
    /**
     * Moves the multiple motors on the left side.
     * @author Team 61 Programming
     * @param speed 
     */
    private void moveLeftMotorStack(double speed)
    {
//      speed = speed*-1.0;
        firstLeftMotor.set(speed);
        secondLeftMotor.set(speed);
    }
    
    /**
     * Moves the multiple motors on the right side.
     * @author Team 61 Programming
     * @param speed 
     */
    private void moveRightMotorStack(double speed)
    {
    // negative to go in forward direction
        firstRightMotor.set(-speed);
        secondRightMotor.set(-speed);
    }
    
    /**
     * Stops the left and right motor stacks.
     * @author Team 61 Programming
     * @param speed 
     */
    public void stop() {
    	moveLeftMotorStack(0.0);
    	moveRightMotorStack(0.0);
    }
    
    /**
     * Resets Gyro to 0
     */
    public void resetGyro(){
        mainGyro.reset();
    }
    
    /**
     * Get Gyro Angle
     * Positive is clockwise
     * @return scaled angle in degrees
     */
    public double getGyroAngle(){
        return mainGyro.getAngle();
    }
    
    public double getGyroRate(){
        return mainGyro.getRate();
    }
   
}

