package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NormalLiftWithJoysticks extends GlobalCommand {
    public NormalLiftWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	boolean ready = true;
//    	if (lift.isSwitchSet()) {
//    		ready = false;
//    	} else {
//    		ready = true;
//    	}
    	oi.updateToggleLift();
        if(oi.toggleOnLift){
        	// commands to occur when torque toggle is pressed
        	// we only want the moveAllMotors command in TorqueLift to
        	// run so we will do nothing here
        	
        	if (!limitswitch.getReadyState()) {
        		lift.moveLift(oi.getLiftYSpeed());
        	}
        } else {
        	//the commands here will be what normally runs
        	if (limitswitch.getReadyState()) {
            	torquelift.sSet();
            	lift.moveLift(oi.getLiftSpeed());
        	} else {
            	lift.moveLift(oi.getLiftYSpeed());
        	}
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
