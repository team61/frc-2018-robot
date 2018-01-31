package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;
import org.usfirst.frc.team61.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team61.robot.commands.GrabWithJoysticks;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	
	// from here on out, the s prefix will determine a solonoid
	Solenoid sClawLifterA = new Solenoid(RobotMap.pcmModule, RobotMap.sClawLifterChannelA);
	Solenoid sClawLifterB = new Solenoid(RobotMap.pcmModule, RobotMap.sClawLifterChannelB);
	Solenoid sClawA = new Solenoid(RobotMap.pcmModule, RobotMap.sClawChannelA);
	Solenoid sClawB = new Solenoid(RobotMap.pcmModule, RobotMap.sClawChannelB);
	// toggle 2 and 3

    public Claw() {
    	super("Claw");
        System.out.println("Claw Initiated");
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new GrabWithJoysticks());
    }
    
    public void openClaw() {
    	sClawA.set(false);
    	sClawB.set(true);
    }
    
    public void closeClaw() {
    	sClawA.set(true);
    	sClawB.set(false);
    }
    
    public void liftClaw() {
    	sClawLifterA.set(false);
    	sClawLifterB.set(true);
    }
    
    public void lowerClaw() {
    	sClawLifterA.set(true);
    	sClawLifterB.set(false);
    }
}

