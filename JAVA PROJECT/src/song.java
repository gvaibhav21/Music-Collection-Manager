import java.io.Serializable;

@SuppressWarnings("serial")
public class song implements Serializable
{
	private String name;
	private int year;
	private int songId;
	private String album;
	private String artist;
	private String genre;
	//private static final long serialVersionUID=4695087737278989072L;
	public song(song s)
	{
		name=s.getName();
		year=s.getYear();
		songId=s.getId();
		album=s.getAlbum();
		artist=s.getArtist();
		genre=s.getGenre();
	}
	public song()
	{
		name="";
		year=0;
		songId=0;
		album="";
		artist="";
		genre="";
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setYear(int year)
	{
		this.year=year;
	}
	public void setId(int counter)
	{
 		songId=counter;
	}
	public void setAlbum(String album)
	{
		this.album=album;
	}
	public void setArtist(String artist)
	{
		this.artist=artist;
	}
	public void setGenre(String genre)
	{
		this.genre=genre;
	}
	public String getName()
	{
		return name;
	}
	public int getYear()
	{
		return year;
	}
	public int getId()
	{
		return songId;
	}
	public String getAlbum()
	{
		return album;
	}
	public String getArtist()
	{
		return artist;
	}
	public String getGenre()
	{
		return genre;
	}
}	