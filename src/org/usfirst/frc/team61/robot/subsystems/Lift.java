package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;
import org.usfirst.frc.team61.robot.commands.LiftBase;
import org.usfirst.frc.team61.robot.commands.NormalLiftWithJoysticks;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Lift extends Subsystem {

	CANTalon firstLiftMotor = new CANTalon(RobotMap.liftMotorA);
	CANTalon secondLiftMotor = new CANTalon(RobotMap.liftMotorB);
//	Encoder liftEncoder = new Encoder(RobotMap.liftEncoderA, RobotMap.liftEncoderB);

	public Lift() {
		super("Lift");
		System.out.println("Lift Initiated");
	}

    public void initDefaultCommand() {
		setDefaultCommand(new NormalLiftWithJoysticks());
    }
    
    public void moveLiftUp(double speed) { // we need something to determine if the pully has reached its max
//		if(getLiftEncoder() >= RobotMap.encoderLiftMax && speed > 0) stop();
		if(speed < 0) speed = 0;
		moveLiftMotorStack(speed);
    }
    
    public void moveLiftDown(double speed) { // we need something to determine if the pully has reached its max
//		if(getLiftEncoder() >= RobotMap.encoderLiftMax && speed > 0) stop();
		if(speed > 0) speed = 0;
		moveLiftMotorStack(speed);
    }
    
    public void moveLift(double speed) {
    	moveLiftMotorStack(speed);
    }
    
	private void moveLiftMotorStack(double speed) {
		firstLiftMotor.set(speed);
		secondLiftMotor.set(speed);
	}

	public void stop() {
		firstLiftMotor.set(0.0);
		secondLiftMotor.set(0.0);
	}

//	public double getLiftEncoder(){
//		return liftEncoder.getDistance();
//	}
//	
//	public void resetEncoder(){
//		liftEncoder.reset();
//	}
}

