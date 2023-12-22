package baoveCSDL.model;

public class Nhanvien {
	private int id;
	private String nameNV;
	private String emailNV;
	private String passwordNV;
	private String sdt;
	private String Luong;
	private String chucvu;
	private String diachi;
	private String image;
	
	public Nhanvien() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameNV() {
		return nameNV;
	}

	public void setNameNV(String nameNV) {
		this.nameNV = nameNV;
	}

	public String getEmailNV() {
		return emailNV;
	}

	public void setEmailNV(String emailNV) {
		this.emailNV = emailNV;
	}

	public String getPasswordNV() {
		return passwordNV;
	}

	public void setPasswordNV(String passwordNV) {
		this.passwordNV = passwordNV;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getLuong() {
		return Luong;
	}

	public void setLuong(String luong) {
		Luong = luong;
	}

	public String getChucvu() {
		return chucvu;
	}

	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Nhanvien [id=" + id + ", nameNV=" + nameNV + ", emailNV=" + emailNV + ", passwordNV=" + passwordNV
				+ ", sdt=" + sdt + ", Luong=" + Luong + ", chucvu=" + chucvu + ", diachi=" + diachi + ", image=" + image
				+ "]";
	}

	
	
	
	
}

