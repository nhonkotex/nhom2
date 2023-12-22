package baoveCSDL.model;

public class Product {
	private int id;
	private String name;
	private String category;
	private Double price;
	private String image;
	private String chitiet;
	
	public Product() {
	}

	
	public Product(int id, String name, String category, Double price, String image, String chitiet) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
		this.chitiet = chitiet;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public String getChitiet() {
		return chitiet;
	}


	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", image="
				+ image + ", chitiet=" + chitiet + "]";
	}


	
	
}