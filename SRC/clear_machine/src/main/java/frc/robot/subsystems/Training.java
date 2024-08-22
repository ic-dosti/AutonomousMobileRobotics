package frc.robot.subsystems;

//WPI imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

//Vendor imports
import com.kauailabs.navx.frc.AHRS;
import com.studica.frc.TitanQuad;
import com.studica.frc.TitanQuadEncoder;
import com.studica.frc.Cobra;
import com.studica.frc.ServoContinuous;

public class Training extends SubsystemBase
{

    /**
     * Motors
     */
    private TitanQuad motorRight;
    private TitanQuad motorLeft;
    private TitanQuad motorBack;
    private TitanQuad motorLift;

    /**
     * Encoders
     */
    // private TitanQuadEncoder motorRightEncoder;
    // private TitanQuadEncoder motorLeftEncoder;
    // private TitanQuadEncoder motorBackEncoder;
    // private TitanQuadEncoder motorLiftEncoder;

    private ServoContinuous servo;
    // private ServoContinuous servoLift;

    /**
     * Sensors
     */
    private Cobra cobra;
    // private Ultrasonic sonicLeft;
    // private AnalogInput sharpLeft;
    // private Ultrasonic sonicRight;
    // private AnalogInput sharpRight;
    private AHRS gyro;

   /**
     * Buttons
     */


     private DigitalInput start;
     private DigitalInput stop;
     private DigitalInput reset;
     private DigitalInput EMS;

   /**
     * Leds
     */

     private DigitalOutput stopped;
     private DigitalOutput running;


    /**
     * Shuffleboard
     */
    // private ShuffleboardTab tab = Shuffleboard.getTab("Training");
    // private NetworkTableEntry sharpRightSB = tab.add("Sharp Right", 0)
    //                                         .getEntry();
    // private NetworkTableEntry sonicRightSB = tab.add("Ultrasonic Right", 0)
    //                                         .getEntry();
    // private NetworkTableEntry sharpLeftSB = tab.add("Sharp Left", 0)
    //                                         .getEntry();
    // private NetworkTableEntry sonicLeftSB = tab.add("Ultrasonic Left", 0)
    //                                         .getEntry();
    // private NetworkTableEntry cobraRawSB = tab.add("Cobra Raw", 0)
    //                                         .getEntry();
    // private NetworkTableEntry cobraVoltageSB = tab.add("Cobra Voltage", 0)
    //                                         .getEntry();
    // private NetworkTableEntry navXSB = tab.add("NavX Yaw", 0)
    //                                         .getEntry();
    // public NetworkTableEntry DPadSB = tab.add("DPad", 0)
    //                                         .getEntry();

    // public NetworkTableEntry startSB = tab.add("Start", true)
    //                                         .getEntry();
    // public NetworkTableEntry stopSB = tab.add("Stop", true)
    //                                         .getEntry();
    // public NetworkTableEntry resetSB = tab.add("Reset", true)
    //                                         .getEntry();
    // public NetworkTableEntry EMSSB = tab.add("EMS", true)
    //                                         .getEntry();
    // public NetworkTableEntry StoppedSB = tab.add("Stopped", true)
    //                                         .getEntry();
    // public NetworkTableEntry RunningSB = tab.add("Running", true)
    //                                         .getEntry();
    // public NetworkTableEntry CaseSB = tab.add("Current Case", 0)
    //                                         .getEntry();
    // public NetworkTableEntry EncoderRightSB = tab.add("Encoder Right", 0) 
    //                                         .getEntry();
    // public NetworkTableEntry EncoderLeftSB = tab.add("Encoder Left", 0)
    //                                         .getEntry();
    // public NetworkTableEntry EncoderBackSB = tab.add("Encoder Back", 0)
    //                                         .getEntry();
    // public NetworkTableEntry EncoderLiftSB = tab.add("Encoder Lift", 0)
    //                                         .getEntry();

    public Training()
    {
        //Motors
        motorRight = new TitanQuad(Constants.TITAN_ID, Constants.RIGHT_MOTOR);
        // motorRight.setInverted(true);
        motorLeft = new TitanQuad(Constants.TITAN_ID, Constants.LEFT_MOTOR);
        // motorLeft.setInverted(true);
        motorBack = new TitanQuad(Constants.TITAN_ID, Constants.BACK_MOTOR);
        // motorBack.setInverted(true);
        motorLift = new TitanQuad(Constants.TITAN_ID, Constants.LIFT_MOTOR);
        // motorLift.setInverted(true);

        //Encoder
        // motorRightEncoder = new TitanQuadEncoder(motorRight, Constants.RIGHT_MOTOR, 0.128);
        // motorLeftEncoder = new TitanQuadEncoder(motorLeft, Constants.LEFT_MOTOR, 0.128);
        // motorBackEncoder = new TitanQuadEncoder(motorBack, Constants.BACK_MOTOR, 0.128);
        // motorLiftEncoder = new TitanQuadEncoder(motorLift, Constants.LIFT_MOTOR, 0.128);

        servo = new ServoContinuous(Constants.HVAT_SERVO);
        // servoLift = new ServoContinuous(Constants.LIFT_SERVO);
        //Sensors
        cobra = new Cobra();
        // sharpLeft = new AnalogInput(Constants.LEFT_SHARP);
        // sonicLeft = new Ultrasonic(Constants.LEFT_SONIC_TRIGG, Constants.LEFT_SONIC_ECHO);
        // sharpRight = new AnalogInput(Constants.RIGHT_SHARP);
        // sonicRight = new Ultrasonic(Constants.RIGHT_SONIC_TRIGG, Constants.RIGHT_SONIC_ECHO);
        gyro = new AHRS(SPI.Port.kMXP);




    }

    public int getCobraRawValue(int channel)
    {
        return cobra.getRawValue(channel);
    }

    public double getCobraVoltage(int channel)
    {
        return cobra.getVoltage(channel);
    }


    // public double getSharpLeft()
    // {
    //     return Math.pow(sharpLeft.getAverageVoltage(), -1.2045) * 27.726;
    // }


    // public double getSonicLeft()
    // {
    //     sonicLeft.ping();
    //     Timer.delay(0.005);
    //         return sonicLeft.getRangeMM() / 10;

    // }


    // public double getSharpRight()
    // {
    //     return Math.pow(sharpRight.getAverageVoltage(), -1.2045) * 27.726;
    // }


    // public double getSonicRight()
    // {
    //     sonicRight.ping();
    //     Timer.delay(0.005);
    //     return sonicRight.getRangeMM() / 10;
    // }

    public double getYaw()
    {
        return gyro.getYaw();
    }


    public void resetGyro()
    {
        gyro.zeroYaw();
    }



    public void setServoHvat(double degrees)
    {
        servo.setSpeed(degrees);
    }


    // public void setServoSpeed(double speed)
    // {
    //     servoLift.set(speed);
    // }


    public void setRightMotorSpeed(double speed)
    {
        motorRight.set(speed);
    }

    // public double getRightMotorDistance()
    // {
    //     return motorRightEncoder.getEncoderDistance();
    // }

    // public double getLeftMotorDistance()
    // {
    //     return motorLeftEncoder.getEncoderDistance();
    // }
    // public double getBackMotorDistance()
    // {
    //     return motorBackEncoder.getEncoderDistance();
    // }
    // public double getLiftMotorDistance()
    // {
    //     return motorLiftEncoder.getEncoderDistance();
    // }


 
    public void setLeftMotorSpeed(double speed)
    {
        motorLeft.set(speed);
    }


    public void setBackMotorSpeed(double speed)
    {
        motorBack.set(speed);
    }

    public void setLiftMotorSpeed(double speed)
    {
        motorLift.set(speed);
    }


    //Buttons

    public boolean getStart() 
    {
        return !start.get();
    }

    public boolean getStop() 
    {
        return !stop.get();
    }

    public boolean getReset() 
    {
        return !reset.get();
    }

    public boolean getEMS() 
    {
        return !EMS.get();
    }


    //LEDs

    public void setStopped(boolean value)
    {
        stopped.set(value);
    }

    public void setRunning(boolean value)
    {
        running.set(value);
    }



    @Override
    public void periodic()
    {

        // startSB.setBoolean(getStart());
        // stopSB.setBoolean(getStop());
        // resetSB.setBoolean(getReset());
        // EMSSB.setBoolean(getEMS());

        // // setStopped(StoppedSB.getBoolean(false));
        // // setRunning(RunningSB.getBoolean(false));

        // sharpRightSB.setDouble(getSharpRight());
        // sonicRightSB.setDouble(getSonicRight()); //set to true because we want metric
        // sharpLeftSB.setDouble(getSharpLeft());
        // sonicLeftSB.setDouble(getSonicLeft()); //set to true because we want metric
        // cobraRawSB.setDouble(getCobraRawValue(0)); //Just going to use channel 0 for demo
        // cobraVoltageSB.setDouble(getCobraVoltage(0));
        // navXSB.setDouble(getYaw());

        // EncoderRightSB.setDouble(getRightMotorDistance());
        // EncoderLeftSB.setDouble(getLeftMotorDistance());
        // EncoderBackSB.setDouble(getBackMotorDistance());
        // EncoderLiftSB.setDouble(getLiftMotorDistance());

    }

	public void serServoHvat(double i) {
      
	}

	public void setServoSpeed(double d) {
      
	}
}