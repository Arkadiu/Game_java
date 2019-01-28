package Programmingnew;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {

    @Override
    public void keyTyped(KeyEvent e) {
        char sim = e.getKeyChar();  //получим символ клавиши
        if (Panel.c_menus.button_up.zamen) {     // присвоим надписи символ как строка
            Panel.c_menus.button_up.f = String.valueOf(sim);
            Panel.c_menus.button_up.zamen = false;
        }
        if (Panel.c_menus.button_down.zamen) {     // присвоим надписи символ как строка
            Panel.c_menus.button_down.f = String.valueOf(sim);
            Panel.c_menus.button_down.zamen = false;
        }
        if (Panel.c_menus.button_left.zamen) {     // присвоим надписи символ как строка
            Panel.c_menus.button_left.f = String.valueOf(sim);
            Panel.c_menus.button_left.zamen = false;
        }
        if (Panel.c_menus.button_right.zamen) {     // присвоим надписи символ как строка
            Panel.c_menus.button_right.f = String.valueOf(sim);
            Panel.c_menus.button_right.zamen = false;
        }
        if (Panel.c_menus.button_fight.zamen) {     // присвоим надписи символ как строка
            Panel.c_menus.button_fight.f = String.valueOf(sim);
            Panel.c_menus.button_fight.zamen = false;
        }

    }

    //Проверка нажатой клавиши
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();   //Получить код нажатой клавиши
        //Проверка клавиш
        if (key == Panel.c_menus.button_up.ch_code) {
            Player.up = true;
        }
        if (key == Panel.c_menus.button_down.ch_code) {
            Player.down = true;
        }
        if (key == Panel.c_menus.button_left.ch_code) {
            Player.left = true;
        }
        if (key == Panel.c_menus.button_right.ch_code) {
            Player.right = true;
        }

        if (key == KeyEvent.VK_ESCAPE) {
            if (Panel.state == Panel.STATES.PLAY)
                Panel.state = Panel.STATES.MENUS;   //переход в меню игры
        }

        if (Panel.c_menus.button_up.zamen){
            Panel.c_menus.button_up.ch_code = e.getKeyCode();
        }
        if (Panel.c_menus.button_down.zamen){
            Panel.c_menus.button_down.ch_code = e.getKeyCode();
        }
        if (Panel.c_menus.button_left.zamen){
            Panel.c_menus.button_left.ch_code = e.getKeyCode();
        }
        if (Panel.c_menus.button_right.zamen){
            Panel.c_menus.button_right.ch_code = e.getKeyCode();
        }

        if (Panel.c_menus.button_fight.zamen){
            Panel.c_menus.button_fight.ch_code = e.getKeyCode();
        }



    }

    //Проверка отжатой клавиши
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();   //Получить код нажатой клавиши

        //Проверка клавиш
        if (key == Panel.c_menus.button_up.ch_code) {
            Player.up = false;
        }
        if (key == Panel.c_menus.button_down.ch_code) {
            Player.down = false;
        }
        if (key == Panel.c_menus.button_left.ch_code) {
            Player.left = false;
        }
        if (key == Panel.c_menus.button_right.ch_code) {
            Player.right = false;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENUS) {
                Menus.click = true; //нажатие ЛКМ в меню
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENUS) {
                Menus.click = false; //нажатие ЛКМ в меню
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX();    //получить координату x при перемещении мышки
        Panel.mouseY = e.getY();    //получить координату y при перемещении мышки

    }
}
