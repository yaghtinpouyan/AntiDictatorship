package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class ArmCommand extends Command {

    private Arm arm;

    public ArmCommand(Arm arm){
        this.arm = arm;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        arm.run();
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
        arm.down();
    }
}
