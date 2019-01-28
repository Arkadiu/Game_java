package Programmingnew;

import javax.swing.*;
import java.awt.*;

public class ControlMenus {
    public final static String BUTTON4 = "image/but4.png";
    public final static String BUTTON3 = "image/but3.png";

    // Объявление кнопок
    ButtControl button_up = new ButtControl(550, 10, 100, 37, "курс вверх", BUTTON4, 38);
    ButtControl button_down = new ButtControl(550, 110, 100, 37, "курс вниз", BUTTON4, 40);
    ButtControl button_left = new ButtControl(550, 210, 100, 37, "курс влево", BUTTON4, 37);
    ButtControl button_right = new ButtControl(550, 310, 100, 37, "курс вправо", BUTTON4, 39);
    ButtControl button_fight = new ButtControl(550, 410, 100, 37, "Space", BUTTON4, 32);
    ButtControl button_k = new ButtControl(50, 20, 100, 37, "назад", BUTTON4, 8);

    // вызов метода для прорисовки кнопки
    public void draw(Graphics2D g) {
        button_up.draw(g);
        button_down.draw(g);
        button_left.draw(g);
        button_right.draw(g);
        button_fight.draw(g);
        button_k.draw(g);
    }

    //попадание курсора на кнопку меню
    public void moveContr(ButtControl b) {
        if (Panel.mouseX > b.getX() && Panel.mouseX < b.getX() + b.getW() &&
                Panel.mouseY > b.getY() && Panel.mouseY < b.getY() + b.getH()) { //если курсор попал в кнопку
            b.s = BUTTON3;
            if (b.equals(button_up)) {
                editContr(b);   // метод активации кнопки для замены клавиши управления
            }
            if (b.equals(button_down)) {
                editContr(b);   // метод активации кнопки для замены клавиши управления
            }
            if (b.equals(button_left)) {
                editContr(b);   // метод активации кнопки для замены клавиши управления
            }
            if (b.equals(button_right)) {
                editContr(b);   // метод активации кнопки для замены клавиши управления
            }
            if (b.equals(button_fight)) {
                editContr(b);   // метод активации кнопки для замены клавиши управления
            }
            if (b.equals(button_k) && Menus.click) {
                Panel.buttMenus = false;    //основное меню не активно
                Panel.controlMenus = false; //меню кнопок не активно
                Panel.setMenus = true;  //меню настройки активно
            }

        } else {
            b.s = BUTTON4;  // адрес картинки не активной кнопки
            b.zamen = false;    // замена запрещена
        }
    }

    //попадание курсора на кнопку меню
    public void editContr(ButtControl b) {
        if (Menus.click) {
            b.f = "";   //надпись на кнопке стерта
            b.zamen = true; // замена разрешена
        }
    }

    class ButtControl {
        private double x;   //координата х объекта
        private double y;   //координата y объекта
        private double w;   //ширина объекта
        private double h;   //высота объекта

        public Color color1;    //цвет объекта

        public String f;    //надпись над кнопкой
        public String s;    // строка адреса картинки
        public int ch_code; //код символа кнопки
        public boolean zamen = false;   //разрешение на замену клавиши

        public ButtControl(double x, double y, double w, double h, String f, String s, int ch_code) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.f = f;
            this.s = s;
            this.ch_code = ch_code;
            color1 = Color.BLACK;
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

        //отрисовка объекта

        public void draw(Graphics2D g) {
            g.drawImage(new ImageIcon(s).getImage(), (int) x, (int) y, null);   //отрисовываем элемент в координатах
            g.setColor(color1); //задаем цвет объекту Color
            Font font = new Font("Arial", Font.ITALIC, 18); //Создаем объект класса фонт передаем в конструктор параметры
            g.setFont(font);    //устанавливаем наш шрифт

            long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth(); //длина надписи в пикселях
            g.drawString(f, (int) (x + w / 2) - (int) (length / 2), (int) y + (int) (h / 3) * 2);//рисуем строчку в центре панели

            g.setColor(Color.red);      //задаем цвет объекту Color
            Font font1 = new Font("Arial", Font.ITALIC, 20);    //Создаем объект класса фонт
            g.setFont(font1);
            g.drawString("движение вверх", 750, 40);    //рисуем строчку
            g.drawString("движение вниз", 750, 140);    //рисуем строчку
            g.drawString("движение влево", 750, 240);    //рисуем строчку
            g.drawString("движение вправо", 750, 340);    //рисуем строчку
            g.drawString("удар", 750, 440);    //рисуем строчку

        }
    }
}
