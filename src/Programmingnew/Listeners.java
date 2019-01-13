package Programmingnew;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {

    @Override
    public void keyTyped(KeyEvent e) {
        char sim = e.getKeyChar();  //получим символ клавиши
        if (Panel.c_menus.button_up.zamen){     // присвоим надписи символ как строка
            Panel.c_menus.button_up.f = String.valueOf(sim);
            Panel.c_menus.button_up.zamen = false;
        }
        if (Panel.c_menus.button_d.zamen){     // присвоим надписи символ как строка
            Panel.c_menus.button_d.f = String.valueOf(sim);
            Panel.c_menus.button_d.zamen = false;
        }
        if (Panel.c_menus.button_l.zamen){     // присвоим надписи символ как строка
            Panel.c_menus.button_l.f = String.valueOf(sim);
            Panel.c_menus.button_l.zamen = false;
        }
        if (Panel.c_menus.button_r.zamen){     // присвоим надписи символ как строка
            Panel.c_menus.button_r.f = String.valueOf(sim);
            Panel.c_menus.button_r.zamen = false;
        }
        if (Panel.c_menus.button_f.zamen){     // присвоим надписи символ как строка
            Panel.c_menus.button_f.f = String.valueOf(sim);
            Panel.c_menus.button_f.zamen = false;
        }

    }

    //Проверка нажатой клавиши
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();   //Получить код нажатой клавиши
        //Проверка клавиш
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            Player.right = true;
        }
    }

    //Проверка отжатой клавиши
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();   //Получить код нажатой клавиши
        //Проверка клавиш
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            Player.right = false;
        }
        if (key == KeyEvent.VK_ESCAPE){
            if (Panel.state == Panel.STATES.PLAY)
                Panel.state = Panel.STATES.MENUS;   //переход в меню игры
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
