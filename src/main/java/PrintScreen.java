import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PrintScreen {
    public static void main(String[] args) {
        findImageForScreen();
    }

    public static void findImageForScreen() {

        try {

            //获取屏幕宽和高
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int w = (int) screenSize.getWidth();
			int h = (int) screenSize.getHeight();

            //自定义截图的大小
//            int w = 1920;
//            int h = 1080;

            Robot robot = new Robot();
            //全屏截图
            BufferedImage screenImg = robot.createScreenCapture(new Rectangle(0, 0, w, h));
            OutputStream out = new FileOutputStream("D:/screenImg.png");
            ImageIO.write(screenImg, "png", out);//将截到的BufferedImage写到本地

            InputStream inputStream = new FileInputStream("D:/navigation.png");
            BufferedImage searchImg = ImageIO.read(inputStream);//将要查找的本地图读到BufferedImage

//            //图片识别工具类
//            ImageCognitionUtil ic = new ImageCognitionUtil();
//
//            List<ImageXyBean> list = ic.imageSearch(screenImg, searchImg, ImageCognitionUtil.SIM_ACCURATE_VERY);
//
//            if( list.size() > 0 ) {
//                for (ImageXyBean imgXy : list) {
//                    System.out.println("查找完毕---坐标是" + imgXy.x + "," + imgXy.y);
//
//                    //把找到的图标记一下
//                    Graphics g = screenImg.getGraphics();
//                    g.setColor(Color.red);
//                    g.drawRect(imgXy.x, imgXy.y, searchImg.getWidth(), searchImg.getHeight());
//                    g.setFont(new Font("微软雅黑", Font.BOLD, 16));
//                    g.drawString("←找到的图片在这里", imgXy.x + searchImg.getWidth() + 10,
//                            imgXy.y + searchImg.getHeight() / 2 + 10);
//                    out = new FileOutputStream("image/resultImg.png");
//                    ImageIO.write(screenImg, "png", out);
//
//                }
//            }else {
//                System.out.println("没找到");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
