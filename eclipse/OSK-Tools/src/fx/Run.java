package fx;

import java.io.IOException;

import base.SMaker;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Run {
	public static Group giant = new Group();
	public static Scene sRun = new Scene(giant, 800, 600);
	public static VBox root = new VBox();

	public static void initS() {
		Label title = new Label("����");
		title.setFont(Font.font(48));
		title.setTextFill(Color.web(Config._6));
		
		Label note=new Label("����һ���������еĶ���");
		note.setFont(Font.font(16));
		note.setTextFill(Color.web(Config._6));
		
		
		
		Label cmd=new Label("	����cmd.exe(���ñ��ص�cmd)");
		cmd.setFont(Font.font(18));
		cmd.setTextFill(Color.web(Config._6));
		cmd.setStyle("-fx-cursor: hand;");
		// ���������ͣʱ����ʽ����ѡ��
        cmd.setOnMouseEntered((MouseEvent event) -> {
            cmd.setTextFill(Color.LIGHTGREY);
        });
        
        // ��������뿪ʱ����ʽ����ѡ��
        cmd.setOnMouseExited((MouseEvent event) -> {
        	cmd.setTextFill(Color.web(Config._6));
        });
		cmd.setOnMousePressed((MouseEvent event) -> {
        	open("start");
        });
		
		Label notepad=new Label("	����notepad.exe(���ñ��ص�notepad)");
		notepad.setFont(Font.font(18));
		notepad.setTextFill(Color.web(Config._6));
		notepad.setStyle("-fx-cursor: hand;");
		// ���������ͣʱ����ʽ����ѡ��
		notepad.setOnMouseEntered((MouseEvent event) -> {
			notepad.setTextFill(Color.LIGHTGREY);
        });
        
        // ��������뿪ʱ����ʽ����ѡ��
		notepad.setOnMouseExited((MouseEvent event) -> {
			notepad.setTextFill(Color.web(Config._6));
        });
		notepad.setOnMousePressed((MouseEvent event) -> {
        	open("notepad.exe");
        });
		
		Label mspaint=new Label("	����mspaint.exe(���ñ��ص�mspaint)");
		mspaint.setFont(Font.font(18));
		mspaint.setTextFill(Color.web(Config._6));
		mspaint.setStyle("-fx-cursor: hand;");
		// ���������ͣʱ����ʽ����ѡ��
		mspaint.setOnMouseEntered((MouseEvent event) -> {
			mspaint.setTextFill(Color.LIGHTGREY);
        });
        
        // ��������뿪ʱ����ʽ����ѡ��
		mspaint.setOnMouseExited((MouseEvent event) -> {
			mspaint.setTextFill(Color.web(Config._6));
        });
		mspaint.setOnMousePressed((MouseEvent event) -> {
        	open("mspaint.exe");
        });
		

		Label osk=new Label("	������Ļ����osk.exe(ʹ��֮ǰ��osk.exe,���ڵ�osk_bak.exe)");
		osk.setFont(Font.font(18));
		osk.setTextFill(Color.web(Config._6));
		osk.setStyle("-fx-cursor: hand;");
		// ���������ͣʱ����ʽ����ѡ��
		osk.setOnMouseEntered((MouseEvent event) -> {
			osk.setTextFill(Color.LIGHTGREY);
        });
        
        // ��������뿪ʱ����ʽ����ѡ��
		osk.setOnMouseExited((MouseEvent event) -> {
			osk.setTextFill(Color.web(Config._6));
        });
		osk.setOnMousePressed((MouseEvent event) -> {
        	open("osk.exe --kb");
        });
		
		Label mimikatz=new Label("	����mimikatz.exe(����jarĿ¼�µ�mimikatz)");
		mimikatz.setFont(Font.font(18));
		mimikatz.setTextFill(Color.web(Config._6));
		mimikatz.setStyle("-fx-cursor: hand;");
		// ���������ͣʱ����ʽ����ѡ��
		mimikatz.setOnMouseEntered((MouseEvent event) -> {
			mimikatz.setTextFill(Color.LIGHTGREY);
        });
        
        // ��������뿪ʱ����ʽ����ѡ��
		mimikatz.setOnMouseExited((MouseEvent event) -> {
			mimikatz.setTextFill(Color.web(Config._6));
        });
		mimikatz.setOnMousePressed((MouseEvent event) -> {
        	runMimikatz();
        });
		

		Label m=new Label("	�ֶ�����һ��ָ���ĳ���");
		m.setFont(Font.font(18));
		m.setTextFill(Color.web(Config._6));
		m.setStyle("-fx-cursor: hand;");
		// ���������ͣʱ����ʽ����ѡ��
		m.setOnMouseEntered((MouseEvent event) -> {
			m.setTextFill(Color.LIGHTGREY);
        });
        
        // ��������뿪ʱ����ʽ����ѡ��
		m.setOnMouseExited((MouseEvent event) -> {
			m.setTextFill(Color.web(Config._6));
        });
		m.setOnMousePressed((MouseEvent event) -> {
        	openM(Root.stage);
        });
		
		root.getChildren().addAll(title,note,cmd,notepad,mspaint,osk,mimikatz,m);
		
		giant.getChildren().add(SMaker.maker(root));
	}
	private static void open(String appName) {
	    ProcessBuilder processBuilder = new ProcessBuilder();
	    
	    //if (appName.contains("\\") || appName.contains("/")) {
	        processBuilder.command(appName);
	   // } else {
	        processBuilder.command("cmd.exe", "/c", appName);
	    //}
	    
	    try {
	        Process process = processBuilder.start();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public static void runMimikatz() {
		open("start mimikatz/x64/mimikatz.exe");
	}
	
	private static void openM(Stage owner) {
        Stage mStage = new Stage();
        mStage.setTitle("�ֶ�����...");
        mStage.initOwner(owner); // ���������ߴ���
        mStage.initModality(Modality.NONE); // ����ģ̬����
        VBox v=new VBox();
        
        Label title=new Label("�ֶ����г���");
        title.setFont(Font.font(32));
        title.setTextFill(Color.WHITE	);
        Label note=new Label("�÷�������Ϊֱ�ӵ������������������ֱ�����ն����е�����ǰ�����start����һ���ո���start cmd");
        note.setWrapText(true); // �����ı�����
        title.setFont(Font.font(32));
        note.setFont(Font.font(16));
        title.setTextFill(Color.WHITE	);
        note.setTextFill(Color.WHITE	);
        TextField cmd=new TextField();
        Button run=new Button("����");
        run.setOnAction(e -> {
            open(cmd.getText());
        });
        v.getChildren().addAll(title,note,cmd,run);
        Scene s=new Scene(v,700,200);
        v.setStyle("-fx-background-color: black;");
        mStage.setScene(s);
        mStage.show();
    }
}
