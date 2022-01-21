package com.sist.game;
import javax.swing.*;
import java.awt.*;
import java.awt.Event;

// 윈도우
public class GameMain extends JFrame{
	JMenuItem startItem=new JMenuItem("출발");
	JMenuItem endItem=new JMenuItem("종료");
	GameView g=new GameView();
	public GameMain()
	{
		JMenu menu=new JMenu("게임");
		menu.add(startItem);
		menu.addSeparator();
		menu.add(endItem);
		JMenuBar bar=new JMenuBar();
		bar.add(menu);
		setJMenuBar(bar);	// 윈도우 위에 menu의 바가 생김
		
		// 게임을 추가
		add("center",g);
		
		// 크기결정
		setSize(1000,750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x를 클릭시 메모리 해제
		
		startItem.addActionListener((e)->{
			g.start();
		});
		endItem.addActionListener((e)->{
			g.end();
		});
	}
	public static void main(String[] args) {
		// 호출
		new GameMain(); // 생성자 호출시 반드시 new 생성자()
	}
}
