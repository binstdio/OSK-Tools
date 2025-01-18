package fx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import base.SMaker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Set {
	private static final boolean True = false;
	public static Group giant=new Group();
	public static Scene sSet=new Scene(giant,800,600);
	public static VBox root=new VBox();
	public static void initS() {
		Label title=new Label("设置");
		title.setTextFill(Color.web(Config._9));
		title.setFont(Font.font(48));
		
		Label note=new Label("我们的OSK Tools分为Launcher和本体部分。\r\n" + 
				"Launcher用于唤起OSK Tools，同时Launcher可以避免您在非锁屏状态下调用osk.exe使用OSK Tools。使用osk.exe -kb用于直接启动屏幕键盘。\r\n" + 
				"本体部分拥有一个JRE(Java8u51)，用于加载OSK Tools。mimikatz是一个密码读取器。\r\n" + 
				"将程序本体放置在 C:\\Program Files\\osktools\\ 使用Launcher运行。");
		note.setTextFill(Color.web(Config._10));
		note.setFont(Font.font(14));
		note.setMaxWidth(800);
		note.setWrapText(true);
		
		Label wTitle=new Label("屏幕键盘白名单");
		wTitle.setTextFill(Color.web(Config._10));
		wTitle.setFont(Font.font(28));
		
		Label wNote=new Label("在下列用户中，即使不使用osk.exe -kb也可以直接使用屏幕键盘 (每个用户名占一行)");
		wNote.setTextFill(Color.web(Config._10));
		wNote.setFont(Font.font(14));
		
		HBox w=new HBox();
		TextArea wText=new TextArea();
		wText.setMaxHeight(100);
		wText.setMaxWidth(500);
		wText.setFont(Font.font(24));
		Button wButton=new Button("保存");
		wButton.setFont(Font.font(30));
		wButton.setOnAction(e->{
			String readWText="ERROR";
			readWText=wText.getText();
			// 使用 BufferedWriter 来写入文件
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("wl.txt"))) {
	            writer.write(readWText);  // 写入字符串，自动保留换行符
	            System.out.println("成功将内容写入文件：" + "wl.txt");
	        } catch (IOException e1) {
	            System.err.println("写入文件时发生错误: " + e1.getMessage());
	        }
		});
		w.getChildren().addAll(wText,wButton);
		
		Label aboutTitle=new Label("关于");
		aboutTitle.setFont(Font.font(36));
		aboutTitle.setTextFill(Color.web(Config._10));
		Label about=new Label(Config._11);
		about.setFont(Font.font(16));
		about.setTextFill(Color.web(Config._10));
		about.setMaxWidth(780);
		about.setWrapText(true);
		root.getChildren().addAll(title,note,wTitle,wNote,w,aboutTitle,about);
		giant.getChildren().add(SMaker.maker(root));
	}
}
