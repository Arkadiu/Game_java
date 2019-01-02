package Programmingnew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Панель игры
 */
public class Panel extends JPanel implements ActionListener {
    //размер панели
    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    //координаты мышки
    public static int mouseX;
    public static int mouseY;

    public static enum STATES {
        MENUS, PLAY
    } //объявление перечисления

    public static STATES state = STATES.MENUS;//переменная игры по изначльно - меню

    private BufferedImage image; // ссылка на объект
    private Graphics2D g; // ссылка на объект класса

    Timer mainTimer = new Timer(30, this);//Таймер - задает интервал обновления всех событий

    Back back = new Back();
    Player player = new Player();
    Menus menus = new Menus();

    public Panel() {//конструктор
        super(); //активируем конструктор родителя
        setFocusable(true);//передаем фокус
        requestFocus();//активируем

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); //создаем объект буфера для хранения картинок
        g = (Graphics2D) image.createGraphics();//граф. объекту присвоим элемент из буфера - картинка Graphics2D применив метод getGraphics()

        addMouseListener(new Listeners());  //добавляем обработчик событий клик мыши
        addKeyListener(new Listeners());    //добавляем обработчик событий клавиатуры
        addMouseMotionListener(new Listeners());    //добавляем обработчик событий перемещений мыши
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (state.equals(STATES.MENUS)) {   //если пер state == MENUS
            back.draw(g);                   //отобразить фон
            menus.draw(g);                  //отобразить меню
            gameDraw();                     //прорисовать в панели
        }
        if (state.equals(STATES.PLAY)) {//игра
            gameUpdate();
            gameRender();
            gameDraw();
        }

    }

    //Рисуем в виртуальном окне
    public void gameRender() {
        back.draw(g);
        player.draw(g);
    }

    public void gameUpdate() {   //обновления
        player.update();
    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics(); // переопределение Graphics2D на Graphics
        g2.drawImage(image, 0, 0, null); //рисуем
        g2.dispose();//команда для уборщика мусора
    }

}
