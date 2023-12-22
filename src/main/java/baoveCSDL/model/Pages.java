package baoveCSDL.model;

public class Pages {
	private int id;
	private String tenNV;
	private String tieude;
	private String gioithieu;
	private String noidung;
	private String socmt;
	private String date;
	private String image;
	public Pages() {
	}

	public Pages(int id, String tenNV, String tieude, String gioithieu, String noidung, String socmt, String date, String image) {
		this.id = id;
		this.tenNV = tenNV;
		this.tieude = tieude;
		this.gioithieu = gioithieu;
		this.noidung = noidung;
		this.socmt = socmt;
		this.date = date;
		this.image = image;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getGioithieu() {
		return gioithieu;
	}

	public void setGioithieu(String gioithieu) {
		this.gioithieu = gioithieu;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getSocmt() {
		return socmt;
	}

	public void setSocmt(String socmt) {
		this.socmt = socmt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Pages [id=" + id + ", tenNV=" + tenNV + ", tieude=" + tieude + ", gioithieu=" + gioithieu + ", noidung="
				+ noidung + ", socmt=" + socmt + ", date=" + date + ", image=" + image + "]";
	}

	
	
}
