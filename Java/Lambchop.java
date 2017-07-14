/*
Question:

You're so close to destroying the LAMBCHOP doomsday device you can taste it! But in order to do so, you need to deploy special self-replicating bombs designed for you by the brightest scientists on Bunny Planet. There are two types: Mach bombs (M) and Facula bombs (F). The bombs, once released into the LAMBCHOP's inner workings, will automatically deploy to all the strategic points you've identified and destroy them at the same time. 

But there's a few catches. First, the bombs self-replicate via one of two distinct processes: 
Every Mach bomb retrieves a sync unit from a Facula bomb; for every Mach bomb, a Facula bomb is created;
Every Facula bomb spontaneously creates a Mach bomb.

For example, if you had 3 Mach bombs and 2 Facula bombs, they could either produce 3 Mach bombs and 5 Facula bombs, or 5 Mach bombs and 2 Facula bombs. The replication process can be changed each cycle. 

Second, you need to ensure that you have exactly the right number of Mach and Facula bombs to destroy the LAMBCHOP device. Too few, and the device might survive. Too many, and you might overload the mass capacitors and create a singularity at the heart of the space station - not good! 

And finally, you were only able to smuggle one of each type of bomb - one Mach, one Facula - aboard the ship when you arrived, so that's all you have to start with. (Thus it may be impossible to deploy the bombs to destroy the LAMBCHOP, but that's not going to stop you from trying!) 

You need to know how many replication cycles (generations) it will take to generate the correct amount of bombs to destroy the LAMBCHOP. Write a function answer(M, F) where M and F are the number of Mach and Facula bombs needed. Return the fewest number of generations (as a string) that need to pass before you'll have the exact number of bombs necessary to destroy the LAMBCHOP, or the string "impossible" if this can't be done! M and F will be string representations of positive integers. For example, if M = "2" and F = "1", one generation would need to pass, so the answer would be "1". However, if M = "2" and F = "4", it would not be possible.

Test cases
==========

Inputs:
    (string) M = "2"
    (string) F = "1"
Output:
    (string) "1"

Inputs:
    (string) M = "4"
    (string) F = "7"
Output:
    (string) "4"
*/


package lambchop_destroy;

import java.util.Scanner;

public class Lambchop {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the required number of Mach & Facula bombs to destroy Lambchop device");
		String m = scan.next();
		String f = scan.next();
		
		//System.out.println("M="+m+" F="+f);
		String iteration = answer(m,f);
		System.out.println("No of iteration required are :"+iteration);
	}
	
	public static String answer(String m,String f)
	{
		int mm = Integer.parseInt(m);
		int ff = Integer.parseInt(f);
		int large,small,initialmm=1,initialff=1,count=0,flag=0;
		String iteration="";
				
		if(mm>ff){		
			large = mm;
			small = ff;
		}
		else{
			large = ff;
			small = mm;
		}
		
		if((mm%2==0 && ff%2==0) || (mm==ff))	// Both are even or both are equal
		{
			iteration = "Impossible";
		}
		else if(mm==1 || ff==1)
		{
			iteration = String.valueOf(Math.abs(mm-ff));
		}
		else if((Math.abs(mm-ff)<small))	//if subtraction is less than smaller value between the required one
		{
			flag=0;
			if(mm>ff)
			{
				while(initialmm!=Math.abs(mm-ff))
				{
					initialmm++;
					count++;
				}
				while(initialff<ff)
				{
					count++;
					initialff+=initialmm;
				}
				if(initialff!=ff)
				{
					iteration = "Impossible";
					flag=1;
				}
					
				else
				{
					count++;
					initialmm+=initialff;
				}
				
			}
			else
			{
				//copy the above code & swap the variable names
				while(initialff!=Math.abs(mm-ff))
				{
					initialff++;
					count++;
				}
				while(initialmm<mm)
				{
					count++;
					initialmm+=initialff;
				}
				if(initialmm!=mm)
				{
					iteration = "Impossible";
					flag=1;
				}
				else
				{
					count++;
					initialff+=initialmm;
				}				
			}
			if(flag!=1)
			iteration = String.valueOf(count);
		}
		else		//if subtraction is greater than smaller value between the required one
		{
			flag=0;
			if(mm<ff)
			{
				while(initialmm!=mm)
				{
					initialmm++;
					count++;
				}
				while(initialff<ff)
				{
					initialff+=initialmm;
					count++;
				}
				if(initialff!=ff)
				{
					iteration = "Impossible";
					flag=1;
				}
			}
			else
			{
				//Copy the above code and swap the names
				while(initialff!=ff)
				{
					initialff++;
					count++;
				}
				while(initialmm<mm)
				{
					initialmm+=initialff;
					count++;
				}
				if(initialmm!=mm)
				{
					iteration = "Impossible";
					flag=1;
				}
			}
			if(flag!=1)
				iteration = String.valueOf(count);
		}
		return iteration;
	}

}
