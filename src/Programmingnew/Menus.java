package Programmingnew;

import javax.swing.*;
import java.awt.*;

public class Menus {
    private int n;  //количество кнопок
    private Color color1;   //цвет
    private double x; // координата х кнопки
    private double y; // координата y кнопки
    private double w; // координата w кнопки
    private double h; // координата h кнопки

    private String img; //путь к картинке кнопки

    String[] list = new String[5];  //Список из 5и элементов типа строка - название кнопок


    public Menus() {
        x = 100;
        y = 0;
        w = 396;
        h = 100;
        n = 5;
        color1 = Color.BLACK;
        img = "image/btn.png";

        list[0] = "Новый игрок";
        list[1] = "Играть";
        list[2] = "Настройки";
        list[3] = "Правила";
        list[4] = "Выход";
    }

    public void update() {

    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < n; i++) {
            g.drawImage(new ImageIcon(img).getImage(), (int) x, (int) (y + 140) * i, null);  //отрисовываем элемент в координатах

            g.setColor(color1);//задаем цвет объекту Color
            Font font = new Font("Arial", Font.ITALIC, 60);//создаем объект класса фонт (передаем в конструктор параметры)
            g.setFont(font);//устанавливаем наш шрифт

            long length = (int) g.getFontMetrics().getStringBounds(list[i], g).getWidth(); //длинна надписи в пикселях
            g.drawString(list[i], (int) (x + w / 2) - (int) (length / 2), (int) ((y + 140) * i + (h / 3) * 2));   //рисуем строчку в центре панели
        }
    }
}
