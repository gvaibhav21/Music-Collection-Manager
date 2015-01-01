import java.io.Serializable;


public class playlist implements Serializable
{
	public song songs[];
	public String name;
	public int counter;
	private static final long serialVersionUID=4695087737278989072L;
	
	public playlist()
	{
		songs=new song[200];
		name="";
		counter=0;
	}
	
	public playlist(playlist p)
	{
	 songs=new song[200];
	 for(int i=0;i<p.getCounter();++i)
		 songs[i]=new song(p.getSong(i));
	 name=p.getName();
	 counter=p.getCounter();
	}
	public void copy(playlist p)
	{
		songs=new song[200];
		 for(int i=0;i<p.getCounter();++i)
			 songs[i]=new song(p.getSong(i));
		 name=p.getName();
		 counter=p.getCounter();
	}
	public void setName(String s)
	{
		name=s;
	}
	public String getName()
	{
		return name;
	}
	public int getCounter()
	{
		 return counter;
	}
	public void addSong(song s)
	{
		songs[counter++]=s;
	}
	public song getSong(int i)
	{
		return songs[i];
	}
	
}

