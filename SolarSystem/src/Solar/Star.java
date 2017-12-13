package Solar;

/**
 * һ����ϵ�࣬�������Ǻ�̫�������в�����
 */

import java.awt.Graphics;
import java.awt.Image;

import MyUtil.GameUtil;

public class Star {
	//̫�������ǵ�ͼ�α���image��λ�ñ���x,y;
	Image image;
	double x,y;
	//starͼ�εĿ�Ⱥ͸߶�
	int width,height;
	
	public void draw(Graphics g){
		//��������ͼ��λ��
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	
	public Star() {
		
	}
	
	public Star(Image image){
		this.image =image;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		
		
	}
	
	
	//���ù��췽����������ͼ��
	public Star (Image image,double x,double y) {
		this(image);
		this.x = x;
		this.y = y;
		
	}
	
	public Star (String imagepath,double x,double y) {
		//ͨ��this����������һ����������ʼ��
		this(GameUtil.getImage(imagepath),x,y); 
	}

}
