package Solar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import MyUtil.GameUtil;

/**
 * 行星类，保存行星继承于star类之外的运行参数；
 * @author wenzi
 *
 */

public class Planet extends Star {
	
	//行星继承于star类之外的运行参数,如行星轨迹的长轴，短轴，运动速度，圆心（恒星），角度等；
	double longAxis;   //长轴
	double shortAxis;  //短轴
	double speed;     //运行速度
	double degree;     //运行角度
	Star center;     //圆心（以恒星为中心）
	double x0,y0;    //圆心（固定点为原点）
	Planet[] a;
	
	//增加判断，对卫星作单独处理；
	boolean moon;
	
	public void draw(Graphics g) {
		super.draw(g);
		move();
		if (!moon){
			drawTrace(g);
		}
	}
	
	//以输入坐标方式运行
	public void draw2(Graphics g) {
		super.draw(g);
		move(x0, y0);	
	}
	
	
	public void drawTrace(Graphics g) {
		//定义运行轨迹的坐标x,y,椭圆的宽度和高度
		double ovilX,ovilY,ovilWidth,ovilHeiht;
		
		ovilWidth = longAxis*2;
		ovilHeiht = shortAxis*2;
		ovilX = (center.x + center.width/2) - longAxis;
		ovilY = (center.y + center.height/2) - shortAxis;
		
		Color c = g.getColor();
		//设置画笔颜色
		g.setColor(new Color(240, 240, 240, 100));
		//设置画笔粗细
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(1.5f));
		//画运行轨迹
		g2.drawOval((int)ovilX, (int)ovilY, (int)ovilWidth, (int)ovilHeiht);
		g.setColor(c);
	}
	
	
	//沿着椭圆轨迹运行
	public void move() {
		x = (center.x + (center.width/3)) + longAxis*Math.cos(degree);
		y = (center.y + (center.height/4)) + shortAxis*Math.sin(degree);
		degree += speed;
	}	
	
	
	//除行星外的星体以输入点沿着椭圆轨迹运行
		public void move(double x0,double y0) {
			x = x0 + longAxis*Math.cos(degree);
			y = y0 + shortAxis*Math.sin(degree);
			degree += speed;
		}	
	
	
	
	public Planet(String imagepath, double longAxis, 
			double shortAxis, double speed, Star center) {
		
		//调用star下的父类构造器给imagepath，width,height初始化
		super(GameUtil.getImage(imagepath));
		
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
		
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		
	}
	
	//构造函数2
	public Planet(String imagepath, double longAxis, 
			double shortAxis, double speed, Star center,boolean moon) {
		this(imagepath, longAxis, shortAxis, speed, center);
		this.moon = moon;	
	}
	
	
	
	//构造函数3，陨石，黑洞等的运行
	public Planet(String imagepath, double longAxis, 
			double shortAxis, double speed, double x0,double y0) {
		
		super(GameUtil.getImage(imagepath));
		
		super.x = x;
		super.y = y;
		this.x0 = x0;
		this.y0 = y0;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;	
		
	}
	
	
	//构造函数4，快速创建多个陨石运行
	public Planet(Planet[] a,String imagepath, double longAxis, 
			double shortAxis, double speed, double x0,double y0) {

			this(imagepath, longAxis,  shortAxis,  speed,  x0, y0);
			
			for(int i = 0; i < 20; i++) {
				a[i] = new Planet(imagepath, Math.random()*longAxis, Math.random()*shortAxis, Math.random()*speed, Math.random()*x0, Math.random()*y0);
				System.out.println(a[i]);
			}
	}
	
	
	
	public Planet(Image image, double x, double y) {
		super(image, x, y);
	}
	public Planet(String imagepath, double x, double y) {
		super(imagepath, x, y);
	}

}
