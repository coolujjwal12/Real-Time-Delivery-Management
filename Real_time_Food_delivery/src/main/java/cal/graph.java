package cal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class graph {
	int size;
	HashMap<String,ArrayList<pair>> adj=new HashMap<String,ArrayList<pair>>();// Store graph
	HashMap<String,String> delExe=new HashMap<String,String>();//Store position of Delivery executive
	HashMap<String,String> parent=new HashMap<String,String>();// Used to create path
	graph()
	{
		size=0;
		/*Initializing the initial position of delivery executive */
		delExe.put("H1","D1");
		delExe.put("H3","D2");
	}
	public void addEdges(String s,String n,int dis)//Adding edges in graph
	{
		if(!adj.containsKey(s))
		{
			adj.put(s,new ArrayList<pair>());
			size++;
		}
		adj.get(s).add(new pair(n,dis));
		if(!adj.containsKey(n))
		{
			adj.put(n,new ArrayList<pair>());
			size++;
		}
		adj.get(n).add(new pair(s,dis));
	}
	public String minDistnace(HashSet<String> vis,HashMap<String,Integer> distance)
	{
		int min=Integer.MAX_VALUE;
		String ms="";
		for(String tem:adj.keySet())
		{
			if(!vis.contains(tem)&&distance.get(tem)<min)
			{
				min=distance.get(tem);
				ms=tem;
			}
		}
		return ms;
	}
	public HashMap<String,Integer> disjktra(String startnode)//Applying  Dijkstra's to find the distance of all the delivery executive 
	{
		HashSet<String> vis=new HashSet<String>();
		HashMap<String,Integer> distance=new HashMap<String,Integer>();
		for(String tem :adj.keySet())
		{
			distance.put(tem,Integer.MAX_VALUE);//Initializing the distance of each vertices to infinity
		}
		parent.put(startnode,null);
		distance.replace(startnode,0);//Initializing the distance to source vertices to 0.
		for(int i=0;i<size-1;i++)
		{
			String ms=minDistnace(vis,distance);
			vis.add(ms);
			ArrayList<pair> temp=new ArrayList<pair>();
			temp=adj.get(ms);
			for(pair p : temp)
			{
				if(distance.get(ms)+p.getSecond()<distance.get(p.getfirst()))
				{
					if(parent.containsKey(p.getfirst()))
					{
						parent.replace(p.getfirst(),ms);
					}
					else
					{
					    parent.put(p.getfirst(),ms);
					}
					distance.replace(p.getfirst(),distance.get(ms)+p.getSecond());
				}
			}
		}
		return distance;
	}
	public ArrayList<String> getReal(String picup,String drop)
	{
		HashMap<String,Integer> distance=new HashMap<String,Integer>();
		distance=disjktra(picup);
		String ms=" ";
		int min=Integer.MAX_VALUE;
		for(String tem : distance.keySet())//Finding the nearest delivery executive for the order
		{
			if(distance.get(tem)<min&& delExe.containsKey(tem))
			{
				ms=tem;
				min=distance.get(tem);
			}
		}
		String d=delExe.get(ms);
		delExe.remove(ms);
		delExe.put(drop, d);//  
		ArrayList<String> output=new ArrayList<String>();
		String o="";
		while(true)//Tracing path taken by the delivery executive from its initial position  to restaurant
		{
			o=o+" "+ms;
			ms=parent.get(ms);
			if(ms==null)
			{
				break;
			}
		}
		String oo="";
		while(true)// Tracing path taken by the delivery executive from restaurant to house
		{
			oo=drop+" "+oo;
			drop=parent.get(drop);
			if(parent.get(drop)==null)
			{
				break;
			}
		}
		output.add(d);
		output.add(o);
		output.add(oo);
		return output;
	}
	public void makeGraph()//Build a graph 
	{
		addEdges("R1","H3",3);
		addEdges("R1","H5",7);
		addEdges("R2","H1",5);
		addEdges("R2","H3",6);
		addEdges("R2","H4",10);
		addEdges("R3","H2",8);
		addEdges("R3","H3",6);
	}
}

