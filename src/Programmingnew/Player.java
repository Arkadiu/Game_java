package Programmingnew;

import javax.swing.*;
import java.awt.*;

public class Player {
    // нач координаты и размер объекта
    private double x;   //координата х героя
    private double y;   //координата у героя
    private double w;   //ширина объекта
    private double h;   //высота объекта

    private int speed;  //скорость

    //клавиши перемещения

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    Image img = new ImageIcon("image/Player.png").getImage();   //загрузка картинки героя

    //Constructor

    public Player() {
        //нач координаты героя
        x = 400;
        y = 500;
        //размеры картинки героя
        w = 142;
        h = 229;

        //нач значения клавиш
        up = false;
        down = false;
        left = false;
        right = false;
    }

    //геттеры
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    //обновления

    public void update() {
        speed = Panel.medium ? 4 : Panel.hard ? 2 : 10;
        // смещение героя
        if (up && y > 20) {
            y -= speed;
        }
        if (down && y < Panel.HEIGHT - h) {
            y += speed;
        }
        if (left && x > 0) {
            x -= speed;
        }
        if (right && x < Panel.WIDTH - w) {
            x += speed;
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(img, (int) x, (int) y, null);  //здесь рисуем картинку
    }
}
