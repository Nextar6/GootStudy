package side.java.porject;

public class MusicVO {
	private int cid;
	private String title;
	private String artist;
	private String janre;
	private String year;
	
	MusicVO() {}

	public MusicVO(int cid, String title, String artist, String janre, String year) {
		this.cid = cid;
		this.title = title;
		this.artist = artist;
		this.janre = janre;
		this.year = year;
	}



	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getJanre() {
		return janre;
	}

	public void setJanre(String janre) {
		this.janre = janre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "[ 번호 = " + cid + ", 곡명 = " + title + ", 가수 = " + artist + ", 장르 = " + janre + ", 발매년도 = "
				+ year + " ]";
	}


} // end MusicVO
