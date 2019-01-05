package Programmingnew;

import javax.swing.*;
import java.awt.*;

public class SetMenus {
    private double x;   //координата х объекта
    private double y;   //координата y объекта
    private double w;   //ширина объекта
    private double h;   //высота объекта

    public Color color1; // Цвет

    public String f;    //надпись над кнопкой

    public String s;    //строка адреса картинки

    public SetMenus(double x, double y, double w, double h, String s, String f) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        color1 = Color.BLACK;
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

    public void draw(Graphics2D g) {
        g.setColor(Color.red);  //задаем цвет объекту Color
        Font font = new Font("Arial", Font.ITALIC, 60); //Создаем объект класса фонт (передаем в конструктор параметры
        g.setFont(font);    //устанавливаем шрифт
        g.drawString("Сложность", 40, 100); //рисуем строчку
        g.drawString("Звук", 40, 250); //рисуем строчку
        g.drawString("Управление", 40, 400); //рисуем строчку

        g.drawImage(new ImageIcon(s).getImage(), (int) x, (int) y, null);   //отрисовываем элемент в координатах
        g.setColor(color1); //задаем цвет объекту Color
        Font font1 = new Font("Arial", Font.ITALIC, 20);    //Создаем объект класса фонт (передаем в конструктор параметры)
        g.setFont(font1);   //Устанавливаем наш шрифт

        long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth(); //длина надписи в пикселях
        g.drawString(f, (int) (x + w / 2) - (int) (length / 2), (int) y + (int) (h / 3) * 2);   //рисуем строчку в центре
    }
}
