package Programmingnew;

import javax.swing.*;
import java.awt.*;

/**
 * Конструктор для игр
 */

public class Window {
    public static void main(String[] args) {
        JFrame startFrame = new JFrame("game"); // создаем окно с названием
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна при клике крестика
        startFrame.setLocation(0, 0);//изменяем местоположение фрейма
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//получаем размер экрана
        startFrame.getSize(screenSize);//устанавлим его
        startFrame.setSize(1366,800); //размер окна
        startFrame.add(new Panel());

        Panel panel = new Panel(); //создаем объект панель
        startFrame.setContentPane(panel); //перенос в фрейм панели с Panel

        panel.mainTimer.start();//Запуск Таймера
        //окно видемо
        startFrame.setVisible(true);
    }
}
