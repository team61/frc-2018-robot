package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.subsystems.ChooserSwitch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGroup extends CommandGroup {
	public ChooserSwitch chooserswitch = new ChooserSwitch();
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

    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameData.charAt(0) == 'L')
    	{
    		if (chooserswitch.getChooserSwitch()) {
    			addSequential(new AutoLeftA());
    		} else {
    			addSequential(new AutoLeftB());
    		}
    	} else {
    		if (chooserswitch.getChooserSwitch()) {
    			addSequential(new AutoRightA());
    		} else {
    			addSequential(new AutoRightB());
    		}
    	}
    	
    	//left short switch
//    	addSequential(new DriveForDistance((110), .6));
//    	addSequential(new DriveForDistance((17), .2));
//    	addSequential(new TurnForDegrees(90, .2));
//    	addSequential(new DriveForDistance(28, .6));
//    	addSequential(new lowerClaw());
//    	addSequential(new openClaw());
//    	addSequential(new liftClaw());
//    	addSequential(new closeClaw());
    	
//    	addSequential(new DriveForDistance(299, .6));

//    	System.out.println("AUTONOMOUS - DONE");
    }
}
