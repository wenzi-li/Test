package Solar;

/**
 * 一个星系类，包含行星和太阳的运行参数；
 */

import java.awt.Graphics;
import java.awt.Image;

import MyUtil.GameUtil;

public class Star {
	//太阳和行星的图形变量image，位置变量x,y;
	Image image;
	double x,y;
	//star图形的宽度和高度
	int width,height;
	
	public void draw(Graphics g){
		//传递行星图和位置
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	
	public Star() {
		
	}
	
	public Star(Image image){
		this.image =image;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		
		
	}
	
	
	//调用构造方法传递行星图；
	public Star (Image image,double x,double y) {
		this(image);
		this.x = x;
		this.y = y;
		
	}
	
	public Star (String imagepath,double x,double y) {
		//通过this方法调用另一个构造器初始化
		this(GameUtil.getImage(imagepath),x,y); 
	}

}
