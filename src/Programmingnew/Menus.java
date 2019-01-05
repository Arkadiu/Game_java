package Programmingnew;

import javax.swing.*;
import java.awt.*;

public class Menus {

    public static boolean click = false;    //клик мышкой в режиме меню

    ButtMenus button1 = new ButtMenus(10, 10, 396, 100, "image/but1.png", "Новый игрок");
    ButtMenus button2 = new ButtMenus(10, 150, 396, 100, "image/but1.png", "Играть");
    ButtMenus button3 = new ButtMenus(10, 300, 396, 100, "image/but1.png", "Настройки");
    ButtMenus button4 = new ButtMenus(10, 450, 396, 100, "image/but1.png", "Правила");
    ButtMenus button5 = new ButtMenus(10, 600, 396, 100, "image/but1.png", "Выход");

    public void draw(Graphics2D g) {
        button1.draw(g);
        button2.draw(g);
        button3.draw(g);
        button4.draw(g);
        button5.draw(g);
    }

    class ButtMenus {
        // нач координаты и размер объекта
        private double x; //координата x героя
        private double y; //координата x героя
        private double w; //координата x героя
        private double h; //координата x героя

        public Color color1; //цвет

        public String f; //надпись над кнопкой

        public String s; //строка адреса картинки

        public ButtMenus(double x, double y, double w, double h, String s, String f) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.color1 = Color.WHITE;
            this.f = f;
            this.s = s;
        }

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

        //отрисовка героя
        public void draw(Graphics2D g) {
            g.drawImage(new ImageIcon(s).getImage(), (int) x, (int) y, null);   //отрисовываем элемент в координатах
            g.setColor(color1); //задаем цвет объекту Color
            Font font = new Font("Arial", Font.ITALIC, 60); //Создаем объект класса фонт
            g.setFont(font);

            long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth(); //длина надписи в пикселях
            g.drawString(f, (int) (x + w / 2) - (int) (length / 2), (int) y + (int) (h / 3) * 2);//рисуем строчку в центре панели
        }
    }
}
