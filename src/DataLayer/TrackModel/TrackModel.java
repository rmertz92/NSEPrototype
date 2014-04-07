package DataLayer.TrackModel;

import DataLayer.Bundles.*;
import java.util.*;
import DataLayer.EnumTypes.*;

public class TrackModel 
{
    public final ArrayList<Line> theLines;
    private LineColor lineColor;
    
    
    public TrackModel()
    {
        
        theLines = new ArrayList<>();
        
    }
    
    public void setBlockInfo(BlockInfoBundle b)
    {
        int line = 0;
        lineColor = b.LineID;
        switch (lineColor)
        {
            case GREEN:
                line = 0;
            case RED:
                line = 1;
        }
        int block = b.BlockID;
        theLines.get(line).theBlocks.get(block).setRRXingState(b.RRXingState);
        theLines.get(line).theBlocks.get(block).setLightColor(b.LightColor);
    }
    
    public BlockInfoBundle getBlockInfoBundle(LineColor line, int block)
    {
        int lineNum = 0;
        switch (line)
        {
            case GREEN:
                lineNum = 0;
            case RED:
                lineNum = 1;
        }
        XingState s = theLines.get(lineNum).theBlocks.get(block).getRRXingState();
        LightColor l = theLines.get(lineNum).theBlocks.get(block).getLightColor();
        boolean c = theLines.get(lineNum).theBlocks.get(block).isClosed();
        BlockInfoBundle b = new BlockInfoBundle(l, s, block, line, c);
        return b;
    }
    
    public void setBlockSignal(BlockSignalBundle b)
    {
        int line = 0;
        lineColor = b.LineID;
        switch (lineColor)
        {
            case GREEN:
                line = 0;
            case RED:
                line = 1;
        }
        int block = b.BlockID;
        theLines.get(line).theBlocks.get(block).setAuthority(b.Authority);
        theLines.get(line).theBlocks.get(block).setDestination(b.Destination);
        theLines.get(line).theBlocks.get(block).setVelocity(b.Speed);
    }
    
    public BlockSignalBundle getBlockSignalBundle(LineColor line, int block) 
    {
        int lineNum = 0;
        switch (line)
        {
            case GREEN:
                lineNum = 0;
            case RED:
                lineNum = 1;
        }
        int a = theLines.get(lineNum).theBlocks.get(block).getAuthority();
        int d = theLines.get(lineNum).theBlocks.get(block).getDestination();
        double s = theLines.get(lineNum).theBlocks.get(block).getVelocity();
        boolean c = theLines.get(lineNum).theBlocks.get(block).isClosed();
        BlockSignalBundle b = new BlockSignalBundle(a, d, s, block, line, c);
        return b;
    }
    
    
}
