// Row.java
/*
 Encapsulates the overall information for a single Frogger row.
*/

import java.util.StringTokenizer;

public class Row {
	// Row types, returned by getType()
	public static final int ROAD = 0;
	public static final int WATER = 1;
	public static final int DIRT = 2;
    
    private int type;
    private int strike;
    private double density;
    
    public Row(String arguments)
    {
        int numArgs = 3;
        String [] tokens = new String[numArgs];
        StringTokenizer str = new StringTokenizer(arguments);
        int count = 0;
        
        while ( (count < numArgs) && str.hasMoreTokens() )
        {
            tokens[count] = str.nextToken();
            count++;
        }
        
        if ( tokens[0].compareToIgnoreCase("dirt") == 0 )
            type = DIRT;
        else if (tokens[0].compareToIgnoreCase("water") == 0)
            type = WATER;
        else
            type = ROAD;
        
        if (type !=DIRT)
        {
            strike = Integer.parseInt(tokens[1]);
            density = Double.parseDouble(tokens[2]);
        }
    }
    
    public Row(int t)
    {
        type = DIRT;
    }
    
    public int getType()
    {
        return type;
    }
    
    public boolean isTurn(int round)
    {
        return ( (type != DIRT) && (round % strike == 0) );
    }
    
    public boolean isAdd()
    {
        double rand = Math.random();
        return ( (type != DIRT) && (rand < density) );
    }
    
	
}

