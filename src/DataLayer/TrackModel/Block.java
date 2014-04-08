package DataLayer.TrackModel;

import DataLayer.EnumTypes.*;


public class Block {
    
    private int blockID;
    public int next, prev;
    private int length;
    private double speedLimit;
    private double elevation;
    private double cumElev;
    private double gradient;
    private int failureState;
    private boolean occupied;
    private int occupyingTrainID;
    private boolean closed;
    private boolean underground;
    private boolean light;
    private LightColor lightColor;
    private boolean rrxing;
    private XingState rrxingState;
    private boolean station;
    private int stationID;
    private String stationString;
    private double velocity;
    private int authority;
    private int destination;
    private boolean tswitch;
    private int tswitchID;
    private BeaconSignal beacon;
    
    public Block(int blockID, int next, int prev, int length, double speedLimit, double elevation, double cumElev,
            double gradient, boolean underground, boolean light, boolean rrxing,
            boolean station, boolean tswitch)
    {
        this.blockID = blockID;
        this.next = next;
        this.prev = prev;
        this.length = length;
        this.speedLimit = speedLimit;
        this.elevation = elevation;
        this.cumElev = cumElev;
        this.gradient = gradient;
        this.underground = underground;
        this.light = light;
        this.rrxing = rrxing;
        this.station = station;
        this.tswitch = tswitch;
        
        this.failureState = 0;
        this.closed = false;
        this.occupied = false;
        this.velocity = 0;
        this.authority = 0;
        this.destination = 0;
    }

    public int getBlockID() 
    {
        return blockID;
    }

    public int getLength() 
    {
        return length;
    }

    public double getSpeedLimit() 
    {
        return speedLimit;
    }

    public double getElevation() 
    {
        return elevation;
    }

    public double getCumElev() 
    {
        return cumElev;
    }

    public double getGradient() 
    {
        return gradient;
    }

    public int getFailureState() 
    {
        return failureState;
    }

    public void setFailureState(int failureState) 
    {
        this.failureState = failureState;
    }

    public boolean isOccupied() 
    {
        return occupied;
    }

    public void setOccupied(boolean occupied) 
    {
        this.occupied = occupied;
    }

    public int getOccupyingTrainID() 
    {
        return occupyingTrainID;
    }

    public void setOccupyingTrainID(int occupyingTrainID) 
    {
        this.occupyingTrainID = occupyingTrainID;
    }

    public boolean isClosed() 
    {
        return closed;
    }

    public void setClosed(boolean closed) 
    {
        this.closed = closed;
    }

    public boolean isUnderground() 
    {
        return underground;
    }

    public boolean hasLight() 
    {
        return light;
    }

    public LightColor getLightColor() 
    {
        return lightColor;
    }

    public void setLightColor(LightColor lightColor) 
    {
        this.lightColor = lightColor;
    }

    public boolean hasRRXing() 
    {
        return rrxing;
    }

    public XingState getRRXingState() 
    {
        return rrxingState;
    }

    public void setRRXingState(XingState rrxingState) 
    {
        this.rrxingState = rrxingState;
    }

    public boolean hasStation() 
    {
        return station;
    }

    public int getStationID() 
    {
        return stationID;
    }

    public String getStationString() {
        return stationString;
    }

    public void setStationString(String stationString) {
        this.stationString = stationString;
    }

    public void setStationID(int stationID) 
    {
        this.stationID = stationID;
    }

    public double getVelocity() 
    {
        return velocity;
    }

    public void setVelocity(double velocity) 
    {
        this.velocity = velocity;
    }

    public int getAuthority() 
    {
        return authority;
    }

    public void setAuthority(int authority) 
    {
        this.authority = authority;
    }

    public int getDestination() 
    {
        return destination;
    }

    public void setDestination(int destination) 
    {
        this.destination = destination;
    }

    public boolean hasTswitch() 
    {
        return tswitch;
    }

    public int getTswitchID() 
    {
        return tswitchID;
    }

    public void setTswitchID(int tswitchID) 
    {
        this.tswitchID = tswitchID;
    }

    public BeaconSignal getBeacon() 
    {
        return beacon;
    }

    public void setBeacon(BeaconSignal beacon) 
    {
        this.beacon = beacon;
    }
    
}
