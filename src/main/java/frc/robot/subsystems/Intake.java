package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private SparkMax intakeMotor = new SparkMax(6, MotorType.kBrushless);
    private static Intake intake = null;
  
    public static Intake getInstance(){
        if (intake == null){
            intake = new Intake();
        }
        return intake;
    }

    public Intake(){
    
    }

    public void run() {
        intakeMotor.set(0.7);
    }

    public void stop() {
        intakeMotor.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("we are intaking", intakeMotor.get() != 0);
    }
}