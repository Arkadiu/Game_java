package Programmingnew;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //Проверка нажатой клавиши
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();   //Получить код нажатой клавиши
        //Проверка клавиш
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
            Player.up = true;
        }
        if (key == KeyEvent.VK_S  || key == KeyEvent.VK_DOWN){
            Player.down = true;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            Player.left = true;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            Player.right = true;
        }
    }
    //Проверка отжатой клавиши
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();   //Получить код нажатой клавиши
        //Проверка клавиш
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
            Player.up = false;
        }
        if (key == KeyEvent.VK_S  || key == KeyEvent.VK_DOWN){
            Player.down = false;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            Player.left = false;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            Player.right = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
