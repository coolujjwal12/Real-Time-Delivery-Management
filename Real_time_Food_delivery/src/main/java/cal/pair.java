package cal;

public class pair {
	 String node;
	 int dis;
    public pair(String node,int dis)
    {
   	 this.node=node;
   	 this.dis=dis;
    }
	String getfirst()
    {
   	 return node;
    }
    int  getSecond()
    {
   	 return dis;
    }
}
