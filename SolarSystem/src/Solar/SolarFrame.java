package Solar;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import MyUtil.Constant;
import MyUtil.GameUtil;
import MyUtil.MyFrame;

/**
 * ̫��ϵ����ϵͳ����
 * @author wenzi
 *
 */

public class SolarFrame extends MyFrame {
	Image bg = GameUtil.getImage("Images/solarBackGround.jpg");                                                     //���ر���
	Star sun = new Star("Images/sun_48px.png", Constant.GAME_WIDTH/2-48/2, Constant.GAME_HEIGHT/2-48/2);           //̫��
	Planet mercury = new Planet("Images/mercury_64px.png", 150, 130, 0.01, sun);                                  //ˮ��
	Planet venus = new Planet("Images/venus_64px.png", 200, 180, 0.0083, sun);                                   //ľ��
	Planet earth = new Planet("Images/earth_64px.png", 260, 250, 0.0075, sun);                                  //����
	Planet moon = new Planet("Images/moon_32px.png", 60, 40, 0.032, earth,true);                               //����
	Planet mars = new Planet("Images/mars_64px.png", 310, 300, 0.0058, sun);                                  //����
	Planet jupiter  = new Planet("Images/jupiter_96px.png", 380, 360, 0.0041, sun);                          //ľ��
	Planet saturn  = new Planet("Images/saturn_72px(1).png", 460, 440, 0.0037, sun);                        //����
	Planet uranus  = new Planet("Images/uranus_64px.png", 510, 500, 0.0025, sun);                          //������
	Planet neptune  = new Planet("Images/neptune_64px.png", 560, 540, 0.0018, sun);                       //������
	Planet blackhole = new Planet("Images/blackhole_256px.png", 50, 50, 0.0025, 1600, 800);              //�ڶ�   
	Planet thanatos = new Planet("Images/thanatos_256px.png", 600, 480, 0.0015, 2100, -100);            //����
	//ʹ̫��������
	Planet sun1 = new Planet("Images/sun_128px.png", 5, 2, 0.015, Constant.GAME_WIDTH/2-128/2, Constant.GAME_HEIGHT/2-128/2);
	//��ʯȺ1
	Planet[] asteroid1 = new Planet[20];
	Planet asteroid_1 = new Planet(asteroid1, "Images/asteroid_32px.png", 100000, 1000, 0.0008, 1920, 1080);
	//��ʯȺ2
	Planet[] asteroid2 = new Planet[20];
	Planet asteroid_2 = new Planet(asteroid2, "Images/asteroid_48px.png", 100, 200000, 0.0156, 1920, 1080);
	//��ʯȺ3
	Planet[] asteroid3 = new Planet[20];
	Planet asteroid_3 = new Planet(asteroid3, "Images/asteroid_64px.png", 400000, 200, 0.0276, 1920, 1080);
	//��ʯȺ4
	Planet[] asteroid4 = new Planet[20];
	Planet asteroid_4 = new Planet(asteroid4, "Images/asteroid_72px.png", 600000, 20, 0.009266, 1920, 1080);
	//��ʯȺ5
	Planet[] asteroid5 = new Planet[20];
	Planet asteroid_5 = new Planet(asteroid5, "Images/asteroid_16px.png", 1000, 20, 0.0031, 1920, 1080);
	//��ʯȺ6
	Planet[] asteroid6 = new Planet[20];
	Planet asteroid_6 = new Planet(asteroid6, "Images/asteroid_24px.png", 160, 400, 0.005, 1920, 1080);
	//��ʯȺ7
	Planet[] asteroid7 = new Planet[20];
	Planet asteroid_7 = new Planet(asteroid7, "Images/asteroid_32px.png", 150, 180, 0.0042, 1920, 1080);
	//��ʯȺ8
	Planet[] asteroid8 = new Planet[20];
	Planet asteroid_8 = new Planet(asteroid8, "Images/asteroid_256px.png", 1000000, 40, 0.00012, 1920, 1080);


	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		mercury.draw(g);
		venus.draw(g);
		earth.draw(g);
		mars.draw(g);
		jupiter.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		neptune.draw(g);
		moon.draw(g);
		blackhole.draw2(g);
		thanatos.draw2(g);
		sun1.draw2(g);
		//��ʯȺ����
	    for (int i = 0; i < 20; i++){
	    	asteroid1[i].draw2(g);
	    	asteroid2[i].draw2(g);
	    	asteroid3[i].draw2(g);
	    	asteroid4[i].draw2(g);
	    	asteroid5[i].draw2(g);
	    	asteroid6[i].draw2(g);
	    	asteroid7[i].draw2(g);
	    	asteroid8[i].draw2(g);
	    }
		
	}
	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}

}





