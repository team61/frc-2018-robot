package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGroup extends CommandGroup {

    public AutoGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.

//    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
//    	if(gameData.charAt(0) == 'L')
//    	{
//    		if (switch = true) {
//    			addSequential(new AutoLeftA());
//    		} else {
//    			addSequential(new AutoRightA());
//    		}
//    	} else {
//    		if (switch = false) {
//    			addSequential(new AutoLeftB());
//    		} else {
//    			addSequential(new AutoRightB());
//    		}
//    	}
    	
    	addSequential(new DriveForDistance(251.28, .2)); // currently this goes in reverse
    	addSequential(new TurnForDegrees(-90, .3)); // moves to the right 90 degrees
    	System.out.println("AUTONOMOUS - DONE");
    }
}
