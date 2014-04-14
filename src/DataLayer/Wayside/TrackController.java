/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataLayer.Wayside;


import DataLayer.Bundles.*;
import DataLayer.EnumTypes.*;
import DataLayer.TrackModel.*;
import java.util.*;
import java.util.concurrent.locks.*;


/**
 * <h1>TrackController</h1>
 * <p>
 * This class contains the implementation for a track controller, allowing 
 * communication between the CTC and Track and running a PLC program that will
 * make track decisions based on inputs from the track. </p>
 *
 * @author nwhachten
 * @version 1.1
 * @since 2014-04-02
 */
public class TrackController implements Runnable {
    private ArrayList<Block> blockArray;
    private Hashtable<Integer, Block> blockInfo; //change to hashmap
    private final int[] blocksInSector;
    private final Lock commandBlockLock;
    private final ArrayList<BlockInfoBundle> commandBlockQueue;
    private final Lock commandSignalLock;
    private final ArrayList<BlockSignalBundle> commandSignalQueue;
    private final Lock commandSwitchLock;
    private final ArrayList<Switch> commandSwitchQueue;
    private final int id;
    private final LineColor line;
    private PLC plcProgram;
    private ArrayList<Switch> switchArray;
    private Hashtable<Integer, Switch> switchInfo;  //change to hashmap
    
    
   /**
    * This method is the constructor for TrackController. A track controller
    * is created based on its id, line, and blocks.
    * 
    * @param id The unique id pertaining to this controller
    * @param line The track line that this controller will service
    * @param blocksInSector An array that indicates which blocks this controller will communicate with
    */
    public TrackController(int id, LineColor line, int[] blocksInSector)  {
        this.id = id;
        this.line = line;
        this.blocksInSector = blocksInSector;
        this.commandSignalQueue = new ArrayList<>();
        this.commandSwitchQueue = new ArrayList<>();
        this.commandBlockQueue = new ArrayList<>();
        this.blockInfo = new Hashtable();
        this.switchInfo = new Hashtable();
        this.blockArray = new ArrayList<>();
        this.switchArray = new ArrayList<>();
        this.commandSignalLock = new ReentrantLock();
        this.commandBlockLock = new ReentrantLock();
        this.commandSwitchLock = new ReentrantLock();
        
    }
    
    public void addBlock(Block b)
    {
        //System.out.println("We would like to add block with blockID: " + b.getBlockID());
        this.blockArray.add(b);
        this.blockInfo.put(b.getBlockID(), b);
    }
    
    public void addSwitch(Switch s)
    {
        this.switchArray.add(s);
        this.switchInfo.put(s.switchID, s);
    }
    
    public boolean containsBlock(int n)
    {
        boolean result = false;
        for (int b : this.blocksInSector)
        {
            if (b == n)
            {
                result = true;
                break;
            }
        }
        return result;
    }
    
    /*public ArrayList<Block> getBlockInfo()
    {
        return this.blockArray;
    }*/
    
    public int[] getBlockNums() {
        return blocksInSector;
    }
    
    /*public ArrayList<BlockInfoBundle> getCommandBlockQueue() {
        return commandBlockQueue;
    }*/
    
    /*public ArrayList<BlockSignalBundle> getCommandSignalQueue() {
        return commandSignalQueue;
    }*/
    
   /* public ArrayList<Switch> getCommandSwitchQueue() {
        return commandSwitchQueue;
    }*/
    
    public int getId() {
        return id;
    }
    
    public LineColor getLine() {
        return line;
    }
    
    public ArrayList<Block> getOccupiedBlocks()
    {
        ArrayList<Block> occ;
        occ = new ArrayList<>();
        
        for (Block b : this.blockArray)
        {
            if (b.isOccupied())
            {
                occ.add(b);
            }
        }
        return occ;
    }
    
    public ArrayList<Switch> getSwitchInfo()
    {
        return this.switchArray;
    }

    
    @Override
    public void run()
    {
        Commands c;// = new Commands();
        while (true)
        {
            c = this.plcProgram.runPLCProgram();
            
            commandSignalLock.lock();
            try {
            for (BlockSignalBundle b : this.commandSignalQueue)
            {
                c.pushCommand(b);
            }
            } 
            finally 
            { 
                commandSignalLock.unlock(); 
            }
            
            commandBlockLock.lock();
            try 
            {
            for (BlockInfoBundle b : this.commandBlockQueue)
            {
                c.pushCommand(b);
            }
            }
            finally 
            { 
                commandBlockLock.unlock(); 
            }
            
            commandSwitchLock.lock();
            try 
            {
            for (Switch s : this.commandSwitchQueue)
            {
                c.pushCommand(s);
            }
            }
            finally 
            { 
                commandSwitchLock.lock(); 
            }
              
            
            this.emptyCommandQueues();
            this.processCommands(c);
            
            
            
            
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrackController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }
    
    public void sendSwitchStateSignal(Switch packet)
    {
        
        this.commandSwitchQueue.add(new Switch(packet.lineID, packet.switchID, packet.approachBlock, packet.straightBlock, packet.divergentBlock, packet.straight));
    }
    
    public void sendTravelSignal(BlockSignalBundle sentPacket)
    {
        BlockSignalBundle packet = sentPacket.copy();
        int blockID = packet.BlockID;
        double speed;
        int next;
        Block currentBlock = this.blockInfo.get(packet.BlockID);
        //System.out.println("BlockSignal: " + packet.BlockID + " " + packet.Authority + " sent to tc: " + this.id + " and current block is: " + currentBlock.getBlockID());
        //System.out.println("Current block next" + currentBlock.next + " prev " + currentBlock.prev);
        
        for (int i = 0; i <= packet.Authority; i++)
        {
          // System.out.println("packet: " + packet.BlockID);
          // System.out.println("current block: " + currentBlock.getBlockID());
          // System.out.println("speed limit: " + currentBlock.getSpeedLimit());
          // System.out.println("sent speed: " + packet.Speed);
           if (packet.Speed > currentBlock.getSpeedLimit())
            {
            //packet.setSpeed(speedLimit);
                speed = currentBlock.getSpeedLimit();
            } 
           else
           {
               speed = packet.Speed;
           }
           
         // System.out.println("Adding signal to queoe on tc: " + this.id);
         // System.out.println("Signal\n\tAuthority: " + (packet.Authority -i) + "\n\tDestination: " + packet.Destination + "\n\tSpeed: " + speed + "\n\tID: " + currentBlock.getBlockID() );
            
           commandSignalLock.lock();
           try 
           {
                //System.out.println("adding signal to queue");
                this.commandSignalQueue.add(new BlockSignalBundle(packet.Authority - i, packet.Destination, speed, currentBlock.getBlockID(), LineColor.GREEN));
           }
           finally 
           { 
                commandSignalLock.unlock(); 
           }
            
            if (currentBlock.prev < 0)
            {
                next = this.switchInfo.get(-currentBlock.prev).approachBlock;
            }
            else
            {
                next = currentBlock.prev;
            }
            
           // System.out.println("About to set current block at id: " + next);
            
            if (this.containsBlock(next))
            {
                currentBlock = this.blockInfo.get(next); 
            }
            else
            {
                break;
            }
            
        }

    }
    
    public void setPLC()
    {
        if (this.id == 0)
        {
             this.plcProgram = new PLCGreenOne(id, line, this.blockInfo, this.blockArray, this.switchInfo);
        }
        else if (id == 1)
        {
            this.plcProgram = new PLCGreenTwo(id, line, this.blockInfo, this.blockArray, this.switchInfo);
        }
        else if (id == 2)
        {
            this.plcProgram = new PLCGreenThree(id, line, this.blockInfo, this.blockArray, this.switchInfo);
        }/*
        else if (id == 3)
        {
            this.plcProgram = new PLCRedOne(id, line, blockInfo);
        }
        else if (id == 4)
        {
            this.plcProgram = new PLCRedTwo(id, line, blockInfo);
        }
        else if (id == 5)
        {
            this.plcProgram = new PLCRedThree(id, line, blockInfo);
        }*/
        else
        {
            this.plcProgram = new PLCGreenOne(id, line, this.blockInfo, this.blockArray, this.switchInfo);
            //this is bad and should not happen. create exception to be thrown
        }
    }
    
    public void setTrackBlockInfo(ArrayList<Block> info)
    {
        this.blockArray = info;
        for (Block b : info)
        {
            this.blockInfo.put(b.getBlockID(), b);
        }
    }
    
    public void setSwitchInfo(ArrayList<Switch> info)
    {
        this.switchArray = info;
        for (Switch s : info)
        {
            this.switchInfo.put(s.switchID, s);
            //System.out.println("Setting switch with switch ID: " + s.switchID);
        }
    }
 
    private void emptyCommandQueues()
    {
        commandBlockLock.lock();
        try 
        {
            this.commandBlockQueue.clear();
        }
        finally 
        { 
            commandBlockLock.unlock(); 
        }
        
        commandSignalLock.lock();
        try 
        {
            this.commandSignalQueue.clear();
        }
        finally 
        { 
            commandSignalLock.unlock(); 
        }
        
        commandSwitchLock.lock();
        try 
        {
            this.commandSwitchQueue.clear();
        }
        finally 
        {   
            commandSwitchLock.unlock(); 
        }
    }
    
    private void processCommands(Commands c)
    {
        //loop through the three types of commands
        //signals - set blocks with matching speed, authority ...
        int authority;
        double speed;
        int dest;
        int blockID;
        Block block;
        for (BlockSignalBundle bsb : c.blockSignalCommands)
        {
            authority = bsb.Authority;
            speed = bsb.Speed;
            dest = bsb.Destination;
            blockID = bsb.BlockID;
            block = this.blockInfo.get(blockID);
            //System.out.println("blockID: " + blockID + " controllerID " + this.id);
            //System.out.println("In process commands. set block: " + block.getBlockID() + " with the values a,s,d: " + authority + "," + speed + "," + dest);
            
            block.setAuthority(authority);
            block.setVelocity(speed);
            block.setDestination(dest);
            
            
            
            
        }
        //info - set blocks with rrxing and light info
        LightColor lc;
        XingState xing;
        for (BlockInfoBundle bib : c.blockInfoCommands)
        {
            lc = bib.LightColor;
            xing = bib.RRXingState;
            blockID = bib.BlockID;
            block = this.blockInfo.get(blockID);
            block.setLightColor(lc);
            block.setRRXingState(xing);
        }
        //switch - change switches as needed
        boolean dir;
        //Switch switch;
        int switchID;
        Switch theSwitch;
        for (Switch s : c.switchCommands)
        {
            dir = s.straight;
            switchID = s.switchID;
            theSwitch = this.switchInfo.get(switchID);
            theSwitch.straight = dir;
            
        }
    }
    
    
    
}
