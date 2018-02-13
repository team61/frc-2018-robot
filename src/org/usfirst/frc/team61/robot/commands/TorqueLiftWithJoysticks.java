package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TorqueLiftWithJoysticks extends GlobalCommand {

    public TorqueLiftWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(torquelift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	oi.updateToggleLift();
        if(oi.toggleOnLift && limitswitch.getReadyState()){
        	// The commands here will occur if the TorqueLift toggle switch
        	// is activated. All code here will only run after the button
        	// has been toggled.
    		if(lift.getLiftEncoder() < RobotMap.liftMaxHeight) {
            	torquelift.swap();
            	torquelift.moveAllMotors(oi.getLiftSpeed());
            	if (lift.getLiftEncoder() < -500) {
            		if (oi.getLiftSpeed() < 0) {
            			torquelift.moveAllMotors(oi.getLiftSpeed());
            		} else {
            			torquelift.moveAllMotors(oi.getLiftSpeed()/3);
            		}
            	}
    		} else {
    			torquelift.moveAllMotors(oi.getLiftYDownSpeed());
    		}
        } else {
        	// The commands here will occur normally, when the TorqueLift is
        	// not activated.
        	return;
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
