import java.io.*;
public class temp 
{
	public static void main(String[] args)
	{
		try
		{
			FileOutputStream o=new  FileOutputStream("members.ser");
			ObjectOutputStream obj=new ObjectOutputStream(o);
			member m=new member();
			playlist p=new playlist();
			p.setName("Playlist1");
			song s=new song();
			s.setName("Tum Hi Ho");
			s.setYear(2013);
			s.setId(1);
			s.setAlbum("Aashiqui 2");
			s.setArtist("Arijit Singh");
			s.setGenre("Romantic");
            p.addSong(s);
            m.setFavourite(s.getId());
			s=new song();
			s.setName("Galliyan");
			s.setYear(2014);
			s.setId(2);
			s.setAlbum("Ek Villain");
			s.setArtist("Ankit Tiwari");
			s.setGenre("Romantic");
			p.addSong(s);
			m.setFavourite(s.getId());
			s=new song();
			s.setName("Hai Dil Ye Mera");
			s.setYear(2014);
			s.setId(3);
			s.setAlbum("Hate Story 2");
			s.setArtist("Arijit Singh");
			s.setGenre("Romantic");
			p.addSong(s);
			//m.setFavourite(s.getId());
			m.username="vaibhavg";
			m.name="Vaibhav Gosain";
			m.password="1234";
			m.type=true;
			m.addPlist(p);
			
			p=new playlist();
			p.setName("Playlist2");
			s=new song();
			s.setName("Galliyan");
			s.setYear(2014);
			s.setId(2);
			s.setAlbum("Ek Villain");
			s.setArtist("Ankit Tiwari");
			s.setGenre("Romantic");
			p.addSong(s);
			s=new song();
			s.setName("Hai Dil Ye Mera");
			s.setYear(2014);
			s.setId(3);
			s.setAlbum("Hate Story 2");
			s.setArtist("Arijit Singh");
			s.setGenre("Romantic");
			p.addSong(s);
			
			m.addPlist(p);
			
			p=new playlist();
			p.setName("Playlist3");
			s=new song();
			s.setName("Tum Hi Ho");
			s.setYear(2013);
			s.setId(1);
			s.setAlbum("Aashiqui 2");
			s.setArtist("Arijit Singh");
			s.setGenre("Romantic");
            p.addSong(s);
			s=new song();
			s.setName("Galliyan");
			s.setYear(2014);
			s.setId(2);
			s.setAlbum("Ek Villain");
			s.setArtist("Ankit Tiwari");
			s.setGenre("Romantic");
			p.addSong(s);
			
			m.addPlist(p);
			
			obj.writeObject(m);
			
			
			m=new member();
			m.username="rahul";
			m.name="Rahul Sharma";
			
			m.password="123";
			m.type=true;
			
			obj.writeObject(m);
			m=new member();
			m.username="akash";
			m.name="Akashdeep Goel";
			
			m.password="12345";
			m.type=true;
			obj.writeObject(m);
			m=new member();
			m.username="vikash";
			m.name="Vikash Kumar";
			
			m.password="abcd";
			m.type=false;
			obj.writeObject(m);
			m=new member();
			m.username="shivam";
			m.name="Shivam Yadav";
			m.password="abc";
			m.type=false;
			obj.writeObject(m);
			m=new member();
			m.username="anurag";
			m.name="Anurag Sharma";
			m.password="abcde";
			m.type=false;
			obj.writeObject(m);
		obj.close();
		FileInputStream f = new FileInputStream("members.ser");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(f);
		while(f.available()>0)
		{	
			m=(member)ois.readObject() ; 
			System.out.println("name:"+m.name+"\tusername: "+m.username+"\tpassword: "+m.password);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}