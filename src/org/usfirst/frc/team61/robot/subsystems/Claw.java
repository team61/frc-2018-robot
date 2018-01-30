package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;
import org.usfirst.frc.team61.robot.commands.GrabWithJoysticks;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	
	// from here on out, the s prefix will determine a solonoid
	public Solenoid sClawLifterA = new Solenoid(RobotMap.pcmModule, RobotMap.sClawLifterChannelA);
	public Solenoid sClawLifterB = new Solenoid(RobotMap.pcmModule, RobotMap.sClawLifterChannelB);
	public Solenoid sClawA = new Solenoid(RobotMap.pcmModule, RobotMap.sClawChannelA);
	public Solenoid sClawB = new Solenoid(RobotMap.pcmModule, RobotMap.sClawChannelB);

    public Claw() {
    	super("Claw");
        System.out.println("Claw Initiated");
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GrabWithJoysticks());
    }
    
    public void openClaw() {
    	sClawA.set(true);
    	sClawB.set(true);
    }
    
    public void closeClaw() {
    	sClawA.set(false);
    	sClawB.set(false);
    }
}

