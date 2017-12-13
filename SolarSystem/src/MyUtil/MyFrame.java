package MyUtil;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MyFrame extends Frame {
	
	/**
	 * ���ش���
	 */
	public  void launchFrame(){

		//���ô��ڱ���
		setTitle("̫��ϵ����ϵͳ");
		//���ô��ڳ���
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		//���ô���λ�ã������Ͻ�Ϊԭ�㣻
		setLocation(0,0);
		
		//setBounds��setSize��setlocation���������
		//setBounds(x, y, width, height);
		
		//ʹͼ�δ��ڿɼ������м��أ�
		setVisible(true);
		
		//�����ػ�PaintThread��
		new PaintThread().start();
	
		//���ڼ���(listener)��ʵ�ִ��ڹرգ�
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		}
	
	
	/**
	 * ����һ���ػ����ڵ��ڲ��߳��ࣻ
	 * @author wenzi
	 *
	 */
	class PaintThread extends Thread {
		public void run () {
			while(true) {
				repaint();
				try {
					Thread.sleep(10);  //1s = 1000ms;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ����update(Graphics g)��������������������������Դ��http://blog.csdn.net/helloworld10086/article/details/40679055
	 */
	private Image iBuffer;  
	private Graphics gBuffer; 
	public void update(Graphics g)  
	{  
	    if(iBuffer==null)  
	    {  
	        iBuffer=createImage(this.getSize().width,this.getSize().height);  
	        gBuffer=iBuffer.getGraphics();  
	    }  
	    gBuffer.setColor(getBackground());  
	    gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);  
	    paint(gBuffer);  
	    g.drawImage(iBuffer,0,0,this);  
	}  
	
	
}

