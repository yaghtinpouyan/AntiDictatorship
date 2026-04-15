package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmCommand extends Command {
    private IntakeArm intakeArm;

    public IntakeArmCommand(IntakeArm intakeArm){
        this.intakeArm = intakeArm;
        addRequirements(intakeArm);
    }

    @Override
    public void initialize() {
        intakeArm.run();
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intakeArm.down();
    }
}
