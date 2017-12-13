package MyUtil;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * ��Ϸ�����г����Ĺ����ࣨ�磺ͼƬ���صȣ���
 * @author wenzi
 *
 */
public class GameUtil {
	
	//������ͨ�������췽��˽�У�
	private GameUtil(){}
	
	
	public static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	
	}

}
