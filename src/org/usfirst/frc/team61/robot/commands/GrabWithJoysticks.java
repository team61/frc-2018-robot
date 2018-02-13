package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabWithJoysticks extends GlobalCommand {

    public GrabWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
    	requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	oi.updateToggleLift();
        if(oi.toggleOnLift){
        	// The commands here will occur if the TorqueLift toggle switch
        	// is activated. All code here will only run after the button
        	// has been toggled.
        	
        	//Toggle button to lift and lower the claw
        	oi.updateToggleBar();
            if(oi.toggleOnBar){
            	claw.liftBar();
            } else {
            	claw.lowerBar();
            }
        	
        	//Toggle button to open and close the claw
        	oi.updateToggleClaw();
            if(oi.toggleOnOpenClaw){
            	claw.openClaw();
            } else {
            	claw.closeClaw();
            }
            
            //Toggle button to lift and lower claw
        	oi.updateToggleLiftClaw();
            if(oi.toggleOnLiftClaw){
            	claw.liftClaw();
            } else {
            	claw.lowerClaw();
            }
            
        } else {
        	// The commands here will occur normally, when the TorqueLift is
        	// not activated.
        	
        	//Toggle button to open and close the claw
        	oi.updateToggleClaw();
            if(oi.toggleOnOpenClaw){
            	claw.openClaw();
            } else {
            	claw.closeClaw();
            }
            
            //Toggle button to lift and lower claw
        	oi.updateToggleLiftClaw();
            if(oi.toggleOnLiftClaw){
            	claw.liftClaw();
            } else {
            	claw.lowerClaw();
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
