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
            //создать нового игрока
            if (Panel.mouseX > menus.getX() && Panel.mouseX < menus.getX() + menus.getW() &&
                    Panel.mouseY > (menus.getY() + 140) * 0 && Panel.mouseY < (menus.getY() + 140) * 0 + menus.getH()) {  //если курсор попал в кнопку
                menus.list[0] = "new user";
                menus.user_m = true;    //курсор на кнопке
            } else {
                menus.list[0] = String.valueOf("Новый игрок");
                menus.user_m = false;    //курсор не на кнопке
            }

            //Играть
            if (Panel.mouseX > menus.getX() && Panel.mouseX < menus.getX() + menus.getW() &&
                    Panel.mouseY > (menus.getY() + 140) * 1 && Panel.mouseY < (menus.getY() + 140) * 1 + menus.getH()) {  //если курсор попал в кнопку
                menus.list[1] = "Play";
                menus.game_m = true;    //курсор на кнопке

                if (Menus.click) {    //клик ЛКМ
                    state = STATES.PLAY;    //переход в игру
                    Menus.click = false;
                }
            } else {
                menus.list[1] = String.valueOf("Играть");
                menus.game_m = false;    //курсор не на кнопке
            }
            if (Panel.mouseX > menus.getX() && Panel.mouseX < menus.getX() + menus.getW() &&
                    Panel.mouseY > (menus.getY() + 140) * 2 && Panel.mouseY < (menus.getY() + 140) * 2 + menus.getH()) {  //если курсор попал в кнопку
                menus.list[2] = "Settings";
                //menus.user_m = true;    //курсор на кнопке
            } else {
                menus.list[2] = String.valueOf("Настройки");
                //menus.user_m = false;    //курсор не на кнопке
            }
            if (Panel.mouseX > menus.getX() && Panel.mouseX < menus.getX() + menus.getW() &&
                    Panel.mouseY > (menus.getY() + 140) * 3 && Panel.mouseY < (menus.getY() + 140) * 3 + menus.getH()) {  //если курсор попал в кнопку
                menus.list[3] = "Rules";
                //menus.user_m = true;    //курсор на кнопке
            } else {
                menus.list[3] = String.valueOf("Правила");
                //menus.user_m = false;    //курсор не на кнопке
            }

            //Выход
            if (Panel.mouseX > menus.getX() && Panel.mouseX < menus.getX() + menus.getW() &&
                    Panel.mouseY > (menus.getY() + 140) * 4 && Panel.mouseY < (menus.getY() + 140) * 4 + menus.getH()) {  //если курсор попал в кнопку
                menus.list[4] = "Exit";
                //menus.user_m = true;    //курсор на кнопке
                if (Menus.click){
                    System.exit(0);
                }
            } else {
                menus.list[4] = String.valueOf("Выход");
                //menus.user_m = false;    //курсор не на кнопке
            }

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
