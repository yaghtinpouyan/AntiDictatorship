package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Tank;

public class TankCommand extends Command {

    private final Tank tank;
    private final DoubleSupplier turnSupplier;
    private final DoubleSupplier forwardSupplier;

    public TankCommand(Tank tank, DoubleSupplier turnSupplier, DoubleSupplier forwardSupplier){
        this.tank = tank;
        this.turnSupplier = turnSupplier;
        this.forwardSupplier = forwardSupplier;
        addRequirements(tank);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        tank.manualDrive(turnSupplier.getAsDouble(), forwardSupplier.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
