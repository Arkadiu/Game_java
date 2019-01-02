package Programmingnew;

import javax.swing.*;
import java.awt.*;

/**
 * Задний фон игровой панели
 */

public class Back {
    Image img = new ImageIcon("image/fon1.jpg").getImage(); //загрузка картинки

    public void draw(Graphics2D g) { // прорисовка в Graphics2D
        Color backColor = new Color(37, 255, 38);   //Создать объект клаасса цвет
        g.setColor(backColor);  //передаем цвет граф объекту

        if (Panel.state.equals(Panel.STATES.MENUS)) {
            g.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT); //рисуем прямоугольную область
        }
        if (Panel.state.equals(Panel.STATES.PLAY)) {
            g.drawImage(img, (int) 0, (int) 0, null);//отрисовываем элемент в координатах
        }
    }
}
