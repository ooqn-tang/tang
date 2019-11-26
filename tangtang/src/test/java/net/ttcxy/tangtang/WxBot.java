package net.ttcxy.tangtang;


import java.awt.*;
import java.awt.event.*;

public class WxBot {

    private Frame f;
    private TextField tf;
    private Button but;






    private static class MouseHandler extends MouseAdapter{
        public void mousePressed(MouseEvent event){    //鼠标按下时调用

        }

        public void mouseClicked(MouseEvent event){   //鼠标点击时调用，点击两次则移除矩形
            System.out.println("aksdjfkldsjf");
        }
    }

    private class MouseMotionHandler implements MouseMotionListener{
        public void mouseMoved(MouseEvent event){    //鼠标移动时调用

        }

        public void mouseDragged(MouseEvent event){  //鼠标按住拖动时调用

        }
    }




}