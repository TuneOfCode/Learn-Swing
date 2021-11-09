package BaiTapHuongDoiTuong;

public class Rectangular {
	private double width_x, width_y, height_x, height_y;

	/**
	 * @param width_x
	 * @param width_y
	 * @param height_x
	 * @param heigth_y
	 */
	public Rectangular() {
		
	}
	public Rectangular(double width_x, double width_y, double height_x, double height_y) {
		super();
		this.width_x = width_x;
		this.width_y = width_y;
		this.height_x = height_x;
		this.height_y = height_y;
	}
	public double getWidth_x() {
		return width_x;
	}
	public void setWidth_x(double width_x) {
		this.width_x = width_x;
	}
	public double getWidth_y() {
		return width_y;
	}
	public void setWidth_y(double width_y) {
		this.width_y = width_y;
	}
	public double getHeight_x() {
		return height_x;
	}
	public void setHeight_x(double height_x) {
		this.height_x = height_x;
	}
	public double getHeigth_y() {
		return height_y;
	}
	public void setHeigth_y(double height_y) {
		this.height_y = height_y;
	}
	public double calcPerimeter() {
		return 2 * Math.abs(width_x - width_y) * Math.abs(height_x - height_y);
	}
	
	public double calcArea() {
		return Math.abs(width_x - width_y) * Math.abs(height_x - height_y);
	}
	
}
