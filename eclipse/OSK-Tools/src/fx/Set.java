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
		Label title=new Label("����");
		title.setTextFill(Color.web(Config._9));
		title.setFont(Font.font(48));
		
		Label note=new Label("���ǵ�OSK Tools��ΪLauncher�ͱ��岿�֡�\r\n" + 
				"Launcher���ڻ���OSK Tools��ͬʱLauncher���Ա������ڷ�����״̬�µ���osk.exeʹ��OSK Tools��ʹ��osk.exe -kb����ֱ��������Ļ���̡�\r\n" + 
				"���岿��ӵ��һ��JRE(Java8u51)�����ڼ���OSK Tools��mimikatz��һ�������ȡ����\r\n" + 
				"������������� C:\\Program Files\\osktools\\ ʹ��Launcher���С�");
		note.setTextFill(Color.web(Config._10));
		note.setFont(Font.font(14));
		note.setMaxWidth(800);
		note.setWrapText(true);
		
		Label wTitle=new Label("��Ļ���̰�����");
		wTitle.setTextFill(Color.web(Config._10));
		wTitle.setFont(Font.font(28));
		
		Label wNote=new Label("�������û��У���ʹ��ʹ��osk.exe -kbҲ����ֱ��ʹ����Ļ���� (ÿ���û���ռһ��)");
		wNote.setTextFill(Color.web(Config._10));
		wNote.setFont(Font.font(14));
		
		HBox w=new HBox();
		TextArea wText=new TextArea();
		wText.setMaxHeight(100);
		wText.setMaxWidth(500);
		wText.setFont(Font.font(24));
		Button wButton=new Button("����");
		wButton.setFont(Font.font(30));
		wButton.setOnAction(e->{
			String readWText="ERROR";
			readWText=wText.getText();
			// ʹ�� BufferedWriter ��д���ļ�
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("wl.txt"))) {
	            writer.write(readWText);  // д���ַ������Զ��������з�
	            System.out.println("�ɹ�������д���ļ���" + "wl.txt");
	        } catch (IOException e1) {
	            System.err.println("д���ļ�ʱ��������: " + e1.getMessage());
	        }
		});
		w.getChildren().addAll(wText,wButton);
		
		Label aboutTitle=new Label("����");
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
