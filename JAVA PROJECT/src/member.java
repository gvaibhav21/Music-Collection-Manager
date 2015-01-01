
import java.io.*;

public class member implements Serializable
{
	public String username;
	public String name;
	public String password;
	public boolean type;
	public playlist[] plist;
	public int plistcounter; 
	public int[] rating;
	public int[] favourites;
	public int favcounter;
	//public int[] searchfreq;
	static final long serialVersionUID=5129392910136272815L;
	public void copy(member m)	   
	{
		username=m.getUsername();
		name=m.getName();
		
		password=m.getPassword();
		type=m.getType();
		plistcounter=m.getPlistcounter();
		favcounter=m.getFavcounter();
		plist=new playlist[200];	
		for(int i=0;i<plistcounter;++i)
  		 plist[i]=new playlist(m.getPlist(i));
		rating=	new int[200];
		for(int i=0;i<200;++i)
			rating[i]=m.getRating(i);
		favourites=new int[200];
		for(int i=0;i<favcounter;++i)
			favourites[i]=m.getFav(i);
		//searchfreq=new int[200];
	}
	public member()		//default constructor	   
	{
		username="";
		name="";
		password="";
		type=false;
		plistcounter=0;
		favcounter=0;
		plist=new playlist[200];
		rating=	new int[200];
		favourites=new int[200];
	//	searchfreq=new int[200];
	}
	public int getFav(int i)
	{
		return favourites[i];
	}
	public String getUsername()
	{
		return username;
	}
	public String getName()
	{
		return name;
	}
	public String getPassword()
	{
		return password;
	}
	public boolean getType()
	{
		return type;
	}
	public int getPlistcounter()
	{
		return plistcounter;
	}
	public int getFavcounter()
	{
		return favcounter;
	}
	public playlist getPlist(int i)
	{
		return plist[i];
	}
	public int getRating(int id)
	{
		return rating[id];
	}
	//public int getSearchFreq(int id)
	//{
	//	return searchfreq[id];
	//}
	public void setUsername(String s)
	{
		username=s;
	}
	public void setName(String s)
	{
		name=s;
	}
	public void setPassword(String s)
	{
		password=s;
	}
	public void setType(boolean t)
	{
		type=t;			//0 for user, 1 for member
	}
	public void addPlist(playlist p)
	{
		plist[plistcounter++]=new playlist(p);
	}
	public void decrPlistCounter()
	{
		plistcounter--;
	}
	public void setPlistcounter()
	{
		plistcounter=0;
	}
	public  void setRating(int id,int r)
	{
		rating[id]=r;
	}
	public void setFavourite(int id)     
	{
		favourites[favcounter++]=id;
	}
//	public void setSearchfreq(int id,int freq)
//	{
//		searchfreq[id]=freq;
//	}
	public boolean isFav(int id)
	{
		boolean flag=false;
		for(int i=0;i<favcounter;++i)
		{
			if(favourites[i]==id)
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
/*	public void addSearchFreq(int id)
	{
		++searchfreq[id];
	}*/
}	