package Programmingnew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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

    // активные страницы меню
    public static boolean buttMenus = true;
    public static boolean setMenus = false;

    public static boolean easy = true;  // уровень сложности легкий
    public static boolean medium = false;  // уровень сложности средний
    public static boolean hard = false;  // уровень сложности сложный
    public static boolean aud = true;
    public static boolean control = true;   // управление по умолчанию


    public static enum STATES {
        MENUS, PLAY
    }   //объявление перечисления

    public static STATES state = STATES.MENUS;//переменная игры по изначльно - меню

    private BufferedImage image; // ссылка на объект
    private Graphics2D g; // ссылка на объект класса

    //Списки кнопок
    public ArrayList<SetMenus> buttons;

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

        buttons = new ArrayList<SetMenus>();
        buttons.add(new SetMenus(500, 65, 100, 37, "", "легко"));
        buttons.add(new SetMenus(650, 65, 100, 37, "", "средне"));
        buttons.add(new SetMenus(800, 65, 100, 37, "", "сложно"));

        buttons.add(new SetMenus(500, 210, 100, 37, "", "вкл"));
        buttons.add(new SetMenus(650, 210, 100, 37, "", "выкл"));

        buttons.add(new SetMenus(500, 365, 100, 37, "", "стандарт"));
        buttons.add(new SetMenus(650, 365, 100, 37, "", "пользоват"));

        buttons.add(new SetMenus(1200, 20, 100, 37, "", "назад"));

        addMouseListener(new Listeners());  //добавляем обработчик событий клик мыши
        addKeyListener(new Listeners());    //добавляем обработчик событий клавиатуры
        addMouseMotionListener(new Listeners());    //добавляем обработчик событий перемещений мыши
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (state.equals(STATES.MENUS)) {   //если пер state == MENUS
            back.draw(g);                   //отобразить фон

            if (buttMenus) {
                menus.draw(g);                  //отобразить меню
                menus.moveButt(menus.button1);
                menus.moveButt(menus.button2);
                menus.moveButt(menus.button3);
                menus.moveButt(menus.button4);
                menus.moveButt(menus.button5);
            }
            if (setMenus) {
                moveSettButt();
            }
            gameDraw();                     //прорисовать в панели
        }
        if (state.equals(STATES.PLAY)) {//игра
            gameUpdate();
            gameRender();
            gameDraw();
        }

    }

    public void moveSettButt() {
        for (SetMenus button : buttons) {
            button.draw(g);
            if (Panel.mouseX > button.getX() && Panel.mouseX < button.getX() + button.getW() &&
                    Panel.mouseY > button.getY() && Panel.mouseY < button.getY() + button.getH()) {
                button.s = "image/but3.png";
                if (button == buttons.get(0) && Menus.click) {
                    easy = true;
                    medium = false;
                    hard = false;
                }
                if (button == buttons.get(1) && Menus.click) {
                    easy = false;
                    medium = true;
                    hard = false;
                }
                if (button == buttons.get(2) && Menus.click) {
                    easy = false;
                    medium = false;
                    hard = true;
                }
                if (button == buttons.get(3) && Menus.click) {
                    aud = true;
                }
                if (button == buttons.get(4) && Menus.click) {
                    aud = false;
                }
                if (button == buttons.get(5) && Menus.click) {
                    control = true;
                }
                if (button == buttons.get(6) && Menus.click) {
                    control = false;
                }
                if (button == buttons.get(7) && Menus.click) {
                    setMenus = false;
                    buttMenus = true;
                }


            } else {
                button.s = "image/but4.png";
            }
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
