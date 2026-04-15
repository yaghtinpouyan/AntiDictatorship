package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeArm extends SubsystemBase {

    private SparkMax pooyan1 = new SparkMax(7, MotorType.kBrushless);
    private SparkMax pooyan2 = new SparkMax(8, MotorType.kBrushless);
    
    private SparkClosedLoopController pidControllerIA;
    private SparkClosedLoopController pidControllerIA2;
    private RelativeEncoder encoderIA;
    private RelativeEncoder encoderIA2;

    private static final double kP = 0.1;
    private static final double kI = 0.0;
    private static final double kD = 0.0;

    private static final double Position_Up =100.0;
    private static final double Position_Defualt =0.0;
    private double currentTarget = Position_Defualt;

    public IntakeArm() {

        encoderIA =  pooyan1.getEncoder();
        encoderIA2 = pooyan2.getEncoder();

        pidControllerIA = pooyan1.getClosedLoopController();
        pidControllerIA2 = pooyan2.getClosedLoopController();

        SparkMaxConfig config = new SparkMaxConfig();
        config.closedLoop
        .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
        .p(kP)
        .i(kI)
        .d(kD)
        .outputRange(-0.7, 0.7);

        pooyan1.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        encoderIA.setPosition(0);
        pooyan2.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        encoderIA2.setPosition(0);

    }

    private static IntakeArm intakeArm = null;

    public static IntakeArm getinstance() {
        if (intakeArm == null) {
            intakeArm = new IntakeArm();
        } 
        return intakeArm;
    }

  public void run(){
    currentTarget = Position_Up;
    pidControllerIA.setSetpoint(Position_Up, ControlType.kPosition);
    pidControllerIA2.setSetpoint(Position_Up, ControlType.kPosition);
  }

  public void down(){
    currentTarget = Position_Defualt;
    pidControllerIA.setSetpoint(Position_Defualt, ControlType.kPosition);
    pidControllerIA2.setSetpoint(Position_Defualt, ControlType.kPosition);
  }

  @Override
  public void periodic() {
        SmartDashboard.putNumber("Arm Target", currentTarget);
        SmartDashboard.putNumber("Intake Arm Position 1", encoderIA.getPosition());
        SmartDashboard.putNumber("Intake Arm Position 2", encoderIA2.getPosition());
  }


}
