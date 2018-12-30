package Programmingnew;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {

    public static enum STATES{MENUE, PLAY} //объявление перечисления
    public static STATES state = STATES.MENUE;//переменная игры по изначльно - меню

    Timer mainTimer = new Timer(30, this);//Таймер - задает интервал обновления всех событий

    public Panel() {//конструктор
        super(); //активируем конструктор родителя
        setFocusable(true);//передаем фокус
        requestFocus();//активируем
        mainTimer.start();//Запуск Таймера
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (state.equals(STATES.MENUE)){//если пер state == MENUE

        }
    if (state.equals(STATES.PLAY)){//игра

        }

    }
}
