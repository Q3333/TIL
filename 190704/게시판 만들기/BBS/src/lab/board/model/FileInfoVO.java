package lab.board.model;


public class FileInfoVO {
	
	private String filename;
	private String filetype;
	private int fid;
	private int rbid;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getRbid() {
		return rbid;
	}
	public void setRbid(int rbid) {
		this.rbid = rbid;
	}
	@Override
	public String toString() {
		return "FileInfoVO [filename=" + filename + ", filetype=" + filetype + ", fid=" + fid + ", rbid=" + rbid + "]";
	}
	
	
}