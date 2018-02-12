package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;
import org.usfirst.frc.team61.robot.commands.NormalLiftWithJoysticks;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Lift extends Subsystem {

	CANTalon firstLiftMotor = new CANTalon(RobotMap.mLiftA);
	CANTalon secondLiftMotor = new CANTalon(RobotMap.mLiftB);
	Encoder liftEncoder = new Encoder(RobotMap.eLiftA, RobotMap.eLiftB);

	public Lift() {
		super("Lift");
		System.out.println("Lift Initiated");
		liftEncoder.setDistancePerPulse(1.0);
	}

    public void initDefaultCommand() {
		setDefaultCommand(new NormalLiftWithJoysticks());
    }
    
    public void moveLiftUp(double speed) {

		if(speed < 0) speed = 0;
		moveLiftMotorStack(speed);
    }
    
    public void moveLiftDown(double speed) {
		if(speed > 0) speed = 0;
		moveLiftMotorStack(speed);
    }
    
    public void moveLift(double speed) {
    	moveLiftMotorStack(speed);
    }
    
	@SuppressWarnings("deprecation")
	private void moveLiftMotorStack(double speed) {
		firstLiftMotor.set(speed);
		secondLiftMotor.set(speed);
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		firstLiftMotor.set(0.0);
		secondLiftMotor.set(0.0);
	}
	
	public double getLiftEncoder(){
		return liftEncoder.getDistance();
	}

	public void resetEncoder(){
		liftEncoder.reset();
	}
}

