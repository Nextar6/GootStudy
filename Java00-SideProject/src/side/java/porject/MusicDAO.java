package side.java.porject;

import java.util.ArrayList;


public interface MusicDAO {
	public abstract int insert(MusicVO vo);
	
	
	public abstract ArrayList<MusicVO> select();
	

	public abstract MusicVO select(int index);
	
	
	public abstract int update(int index, MusicVO vo);
	
	
	public abstract int delete(int index);
	
	
	public abstract ArrayList<MusicVO> selectKategorieArtist(String artist);
	
	public abstract ArrayList<MusicVO> selectKategorieJanre(String janre);
	
	public abstract ArrayList<MusicVO> selectKategorieYear(String year);
} // MusicDAO
