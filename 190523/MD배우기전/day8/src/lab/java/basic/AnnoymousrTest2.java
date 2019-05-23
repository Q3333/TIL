package lab.java.basic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyFrame{
	
	public MyFrame() {
		Frame f = new Frame();
		f.setSize(100,100);
		f.setBackground(Color.black);
		f.setVisible(true);
	
	}
	public MyFrame(int w, int h) {
		Frame f = new Frame();
		f.setSize(100,100);
		f.setBackground(Color.yellow);
		f.setVisible(true);
	}
	public MyFrame(int w, int h, Color c) {
		Frame f = new Frame();
		f.setSize(w,h);
		f.setBackground(c);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() { //생성+구현을 동시에
			//@Override								익명이너클래스로만듬
												// WindowAdapter()
			
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});//괄호 안에 이벤트 감지 객체를 넣어줘야함
		
		
	}
	
}


public class AnnoymousrTest2 {

	public static void main(String[] args) {
		MyFrame f1 = new MyFrame();
		MyFrame f2 = new MyFrame(200,200);
		MyFrame f3 = new MyFrame(300,300, Color.blue);

	}

}
