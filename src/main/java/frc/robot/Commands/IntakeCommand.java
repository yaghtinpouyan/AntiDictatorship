package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends Command {

    private Intake intake;

    public IntakeCommand(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.run();
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
        intake.stop();
    }
}
