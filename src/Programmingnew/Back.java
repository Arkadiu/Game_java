package Programmingnew;

import javax.swing.*;
import java.awt.*;

/**
 * Задний фон игровой панели
 */

public class Back {
    Image img = new ImageIcon("image/fon1.jpg").getImage(); //загрузка картинки

    public void draw(Graphics2D g){ // прорисовка в Graphics2D
        g.drawImage(img, (int) 0, (int) 0, null);//отрисовываем элемент в координатах
    }
}
