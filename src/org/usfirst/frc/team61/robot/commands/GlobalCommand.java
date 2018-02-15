package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.OI;
import org.usfirst.frc.team61.robot.subsystems.ChooserSwitch;
import org.usfirst.frc.team61.robot.subsystems.Claw;
import org.usfirst.frc.team61.robot.subsystems.DriveTrain;
import org.usfirst.frc.team61.robot.subsystems.Lift;
import org.usfirst.frc.team61.robot.subsystems.LimitSwitch;
import org.usfirst.frc.team61.robot.subsystems.TorqueLift;

import edu.wpi.first.wpilibj.command.Command;


public abstract class GlobalCommand extends Command {

    public static OI oi;
    
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Lift lift = new Lift();
	public static final Claw claw = new Claw();
	public static final TorqueLift torquelift = new TorqueLift();
	public static final LimitSwitch limitswitch = new LimitSwitch();
	
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.  -- lol credit to previous people
        oi = new OI();
    }
    
    public GlobalCommand(String name) {
        super(name);
    }

    public GlobalCommand() {
        super();
    }
}
