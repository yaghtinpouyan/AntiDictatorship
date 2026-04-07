package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class Operatorinterface extends SubsystemBase{
    public static Operatorinterface oi = null;

    private Tank drive = Tank.getInstance();
    private Arm arm = Arm.getInstance();
    private Intake intake = Intake.getInstance();
    private XboxController controller1 = new XboxController(0);
    public static Operatorinterface getInstance(){ 
        if (oi == null){
            oi = new Operatorinterface();
        }
        return oi;
    }
       
    public void updateDrive(){
        drive.manualDrive(controller1.getRightX(), -controller1.getLeftY());
    }

     public void updateArm(){
        arm.setArmMotor(controller1.getAButton(), controller1.getBButton());

    }
     public void updateIntake(){
        intake.setIntakeMotor(controller1.getXButton());

    }

    @Override
    public void periodic() {
        updateDrive();
        updateArm();
        updateIntake();
    }
}