/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataLayer.Train.TrainModel;

import java.util.Calendar;

/**
 *
 * @author drewwinfield
 */
public class PhysicsEngine implements Runnable 
{
    
    private double motorPower;
    private int passengers;
    private double mass;
    private double gradient;
    private boolean sBrakeStatus;
    private boolean eBrakeStatus;
    private long time;
    private int time_multiplier;
    private double velocity;
    private double delta_x;
    
    private final double passengerMass = 70; // avg weight of a passenger, in kg.  maybe.
    private final double trackCoeffFric = .005; // track's coefficient of friction
    private final double g = 9.8; // accel due to gravity, in m/s^2
    
    private final double maxSpeed = 19.44; // in m/s
    private final int maxPassengers = 222; // max number of persons on train
    private final double emptyMass = 40900; // in kg
    private final double fullMass = 56700; // in kg
    
    private final double twoThirdLoadMaxAccel = .5; // train's max accel at 2/3 load, in m/s^2
    private final double twoThirdLoadSBrakeAccel = 1.2; // magnitude of service brake decel at 2/3 load, in m/s^2
    private final double twoThirdLoadEBrakeAccel = 2.73; // magnitude of emergency brake decel at 2/3 load, in m/s^2
    
    private boolean engineFailure;
    private boolean signalFailure;
    private boolean  sBrakeFailure;
    private boolean  eBrakeFailure;
    
    
    public PhysicsEngine()
    {
        motorPower = 0; // in watts
        gradient = 0; // % grade
        passengers = 0;
        sBrakeStatus = false;
        eBrakeStatus = false;
        time_multiplier = 1;
        engineFailure = false;
        signalFailure = false;
        sBrakeFailure = false;
        eBrakeFailure = false;
    }
    // Velocity
    public double getVelocity()
    {
        return velocity;
    }   
    // Power
    public void setPower(double power)
    {
        if (power > 120000)
        {
            motorPower = 120000;
        }
        else if (power < 0)
        {
            motorPower = 0;
        }
        else
        {
            motorPower = power;
        }
    }
    public double getPower()
    {
        return motorPower;
    }
    
    // Service brake
    public void setServiceBrake(boolean value)
    {
        sBrakeStatus = value;
    }
    public boolean getServiceBrake()
    {
        return sBrakeStatus;
    }
    
    // Emergency brake
    public void setEmergencyBrake(boolean value)
    {
        eBrakeStatus = value;
    }
    public boolean getEmergencyBrake()
    {
        return eBrakeStatus;
    }
    
    // Time multiplier
    public void setTimeMultiplier(int newMultiplier)
    {
        time_multiplier = newMultiplier;
    }
    public int getTimeMultiplier()
    {
        return time_multiplier;
    }
    
    // passengers
    public void setPassengers(int number)
    {
        if (passengers + number < 0)
        {
            passengers = 0;
        }
        else if (passengers + number > maxPassengers)
        {
            passengers = maxPassengers;
        }
        else
        {
            passengers = passengers + number;
        }
    }
    public int getPassengers()
    {
        return passengers;
    }
    
    // gradient
    public void setGradient(double newGradient)
    {
        gradient = newGradient;
    }
    public double getGradients()
    {
        return gradient;
    }
    //public double get
    
    public void run()
    {
        simulate();
    }
    private double calcMaxEngineForce()
    {
        double twoThirdLoadMass = (fullMass - emptyMass) * (2.0/3.0) + emptyMass;
        double maxEngineForce = twoThirdLoadMass * twoThirdLoadMaxAccel;
        return maxEngineForce; 
    }
    private double calcSBrakeForce()
    {
        double twoThirdLoadMass = (fullMass - emptyMass) * (2.0/3.0) + emptyMass;
        double sBrakeForce = twoThirdLoadMass * twoThirdLoadSBrakeAccel;
        return sBrakeForce;
    }
    private double calcEBrakeForce()
    {
        double twoThirdLoadMass = (fullMass - emptyMass) * (2.0/3.0) + emptyMass;
        double eBrakeForce = twoThirdLoadMass * twoThirdLoadEBrakeAccel;
        return eBrakeForce;
    }
    public void simulate()
    {
        // F_engine + F_friction + F_mg / m = a
        // a * delta_t = v        
        double fEngine = 0;
        double fFriction;
        double fBrake = 0;
        double fGravity;
        double fTotal;
        double fTotalAbsVal;
        double fNormal;
        double trainAccel;
        //double trainDisplacement;
        double mass;
        double gravAngle;
        long currTime;
        long lastTime = Calendar.getInstance().getTimeInMillis();
        double deltaT;
        
        // used for debugging and printing information every 5 sec
        long lastPrint = 0;
        long interval = 5 * 1000;
        
        // max force possible from engine, cap fEngine at this value
        double maxEngineForce = calcMaxEngineForce();
        double sBrakeForce = calcSBrakeForce();
        double eBrakeForce = calcEBrakeForce();
        
        while (true)
        //for (int i = 0; i < 100; i++)
        {
            mass = emptyMass + passengers * passengerMass; // calc mass using passenger count 
            
            // calculate fGravity
            gravAngle = Math.atan(gradient / 100);
            fGravity = - (mass * g * Math.sin(gravAngle));
            //System.out.println("Gravity force: " + fGravity);
                    
            // calculate fFriction
            fNormal = mass * g * Math.cos(gravAngle); // calculate Normal force
            fFriction = trackCoeffFric * fNormal;
            //System.out.println("Friction force: " + fFriction);
            // calculate fEngine
            // if velocity is 0, accelerate at the max accel (on spec sheet)
            if (velocity == 0 && motorPower > 0 && !engineFailure)
            {
                //System.out.println("Velocity is 0, using max accel");
                fEngine = maxEngineForce;
            }
            // else, use P/v = F to find fEngine
            else if (!engineFailure) 
            {
                //System.out.println("Velocity is non-zero, using P = Fv");
                fEngine = motorPower / velocity;
                // cap 
                if (fEngine > maxEngineForce)
                {
                    //System.out.println("P = Fv resulted in too high accel, capping at max");
                    fEngine = maxEngineForce;
                }
            }   
            // but the brake might be on... if it is, then fEngine becomes fBrake
            // use same variable for simplicity's sake
            if (sBrakeStatus && !sBrakeFailure)
            {
                fBrake = sBrakeForce;
            }
            else if (eBrakeStatus && !eBrakeFailure)
            {
                fBrake = eBrakeForce;
            }
            else 
            {
                fBrake = 0;
            }
            //System.out.println("Engine force: " + fEngine);
            //System.out.println("Brake force: " + fBrake);
            fTotal = fEngine + fGravity; // sum engine and gravity forces
            // fFriction and fBrake impede movement.  Not so simple as a +/- relationship to 
            // the other forces
            if (velocity > 0)
            {
                fTotal = fTotal - fFriction - fBrake;

            }
            else if (velocity >= 0 && (fTotal - fFriction - fBrake > 0))
            {
                fTotal = fTotal - fFriction - fBrake;
            }
            // if the car is not moving, no external forces.
            else
            {
                velocity = 0; // correct potential small error
                fTotal = 0;
            }
            
            //System.out.println("Total force: " + fTotal);
            
            //System.out.println(fTotal);
            trainAccel = fTotal / mass;
            
            currTime = Calendar.getInstance().getTimeInMillis();
            deltaT = (currTime - lastTime) * time_multiplier; // in ms
            deltaT = deltaT  / 1000; // in s
            lastTime = currTime;
            
            velocity = velocity + trainAccel * deltaT;
            if (velocity > maxSpeed)
            {
                velocity = maxSpeed;
            }
            
            delta_x = delta_x + velocity * deltaT;
            System.out.println(delta_x);
            /*
            if (Calendar.getInstance().getTimeInMillis() > lastPrint  + interval)
            {
                System.out.println();
                System.out.println("Power: " + motorPower);
                System.out.println("fEngine: " + fEngine);
                System.out.println("Gravity force: " + fGravity);
                System.out.println("fTotal: " + fTotal);
                System.out.println("sBrake: " + sBrakeStatus);
                System.out.println("eBrake: " + eBrakeStatus);
                System.out.println("Velocity: " + velocity);
                lastPrint = Calendar.getInstance().getTimeInMillis();
                System.out.println();
            }   
            */
        }
        
        
     
        
    }
    
}