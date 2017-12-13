package Solar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import MyUtil.GameUtil;

/**
 * �����࣬�������Ǽ̳���star��֮������в�����
 * @author wenzi
 *
 */

public class Planet extends Star {
	
	//���Ǽ̳���star��֮������в���,�����ǹ켣�ĳ��ᣬ���ᣬ�˶��ٶȣ�Բ�ģ����ǣ����Ƕȵȣ�
	double longAxis;   //����
	double shortAxis;  //����
	double speed;     //�����ٶ�
	double degree;     //���нǶ�
	Star center;     //Բ�ģ��Ժ���Ϊ���ģ�
	double x0,y0;    //Բ�ģ��̶���Ϊԭ�㣩
	Planet[] a;
	
	//�����жϣ�����������������
	boolean moon;
	
	public void draw(Graphics g) {
		super.draw(g);
		move();
		if (!moon){
			drawTrace(g);
		}
	}
	
	//���������귽ʽ����
	public void draw2(Graphics g) {
		super.draw(g);
		move(x0, y0);	
	}
	
	
	public void drawTrace(Graphics g) {
		//�������й켣������x,y,��Բ�Ŀ�Ⱥ͸߶�
		double ovilX,ovilY,ovilWidth,ovilHeiht;
		
		ovilWidth = longAxis*2;
		ovilHeiht = shortAxis*2;
		ovilX = (center.x + center.width/2) - longAxis;
		ovilY = (center.y + center.height/2) - shortAxis;
		
		Color c = g.getColor();
		//���û�����ɫ
		g.setColor(new Color(240, 240, 240, 100));
		//���û��ʴ�ϸ
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(1.5f));
		//�����й켣
		g2.drawOval((int)ovilX, (int)ovilY, (int)ovilWidth, (int)ovilHeiht);
		g.setColor(c);
	}
	
	
	//������Բ�켣����
	public void move() {
		x = (center.x + (center.width/3)) + longAxis*Math.cos(degree);
		y = (center.y + (center.height/4)) + shortAxis*Math.sin(degree);
		degree += speed;
	}	
	
	
	//��������������������������Բ�켣����
		public void move(double x0,double y0) {
			x = x0 + longAxis*Math.cos(degree);
			y = y0 + shortAxis*Math.sin(degree);
			degree += speed;
		}	
	
	
	
	public Planet(String imagepath, double longAxis, 
			double shortAxis, double speed, Star center) {
		
		//����star�µĸ��๹������imagepath��width,height��ʼ��
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
	
	//���캯��2
	public Planet(String imagepath, double longAxis, 
			double shortAxis, double speed, Star center,boolean moon) {
		this(imagepath, longAxis, shortAxis, speed, center);
		this.moon = moon;	
	}
	
	
	
	//���캯��3����ʯ���ڶ��ȵ�����
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
	
	
	//���캯��4�����ٴ��������ʯ����
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
