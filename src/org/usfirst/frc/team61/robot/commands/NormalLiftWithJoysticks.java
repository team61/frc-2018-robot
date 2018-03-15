package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NormalLiftWithJoysticks extends GlobalCommand {
    public NormalLiftWithJoysticks() {
        requires(lift);
    }

    protected void initialize() {
        lift.resetEncoder(); // this will have to be removed so that the encoder does not reset after autonomous is complete
    }

    protected void execute() {
    	oi.updateToggleLift();
        if(oi.toggleOnLift){
        	// The commands here will occur if the TorqueLift toggle switch
        	// is activated. All code here will only run after the button
        	// has been toggled.
        } else {
        	// The commands here will occur normally, when the TorqueLift is
        	// not activated.
        	if (limitswitch.getReadyState()) {
            	torquelift.sSet();
            	lift.moveLift(oi.getLiftSpeed());
    		} else {
    			lift.moveLift(oi.getLiftYUpSpeed());
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
