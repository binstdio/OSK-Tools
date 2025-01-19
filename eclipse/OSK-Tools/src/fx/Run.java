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
		Label title = new Label("运行");
		title.setFont(Font.font(48));
		title.setTextFill(Color.web(Config._6));
		
		Label note=new Label("运行一切你想运行的东西");
		note.setFont(Font.font(16));
		note.setTextFill(Color.web(Config._6));
		
		
		
		Label cmd=new Label("	运行cmd.exe(调用本地的cmd)");
		cmd.setFont(Font.font(18));
		cmd.setTextFill(Color.web(Config._6));
		cmd.setStyle("-fx-cursor: hand;");
		// 设置鼠标悬停时的样式（可选）
        cmd.setOnMouseEntered((MouseEvent event) -> {
            cmd.setTextFill(Color.LIGHTGREY);
        });
        
        // 设置鼠标离开时的样式（可选）
        cmd.setOnMouseExited((MouseEvent event) -> {
        	cmd.setTextFill(Color.web(Config._6));
        });
		cmd.setOnMousePressed((MouseEvent event) -> {
        	open("start");
        });
		
		Label notepad=new Label("	运行notepad.exe(调用本地的notepad)");
		notepad.setFont(Font.font(18));
		notepad.setTextFill(Color.web(Config._6));
		notepad.setStyle("-fx-cursor: hand;");
		// 设置鼠标悬停时的样式（可选）
		notepad.setOnMouseEntered((MouseEvent event) -> {
			notepad.setTextFill(Color.LIGHTGREY);
        });
        
        // 设置鼠标离开时的样式（可选）
		notepad.setOnMouseExited((MouseEvent event) -> {
			notepad.setTextFill(Color.web(Config._6));
        });
		notepad.setOnMousePressed((MouseEvent event) -> {
        	open("notepad.exe");
        });
		
		Label mspaint=new Label("	运行mspaint.exe(调用本地的mspaint)");
		mspaint.setFont(Font.font(18));
		mspaint.setTextFill(Color.web(Config._6));
		mspaint.setStyle("-fx-cursor: hand;");
		// 设置鼠标悬停时的样式（可选）
		mspaint.setOnMouseEntered((MouseEvent event) -> {
			mspaint.setTextFill(Color.LIGHTGREY);
        });
        
        // 设置鼠标离开时的样式（可选）
		mspaint.setOnMouseExited((MouseEvent event) -> {
			mspaint.setTextFill(Color.web(Config._6));
        });
		mspaint.setOnMousePressed((MouseEvent event) -> {
        	open("mspaint.exe");
        });
		

		Label osk=new Label("	运行屏幕键盘osk.exe(使用之前的osk.exe,现在的osk_bak.exe)");
		osk.setFont(Font.font(18));
		osk.setTextFill(Color.web(Config._6));
		osk.setStyle("-fx-cursor: hand;");
		// 设置鼠标悬停时的样式（可选）
		osk.setOnMouseEntered((MouseEvent event) -> {
			osk.setTextFill(Color.LIGHTGREY);
        });
        
        // 设置鼠标离开时的样式（可选）
		osk.setOnMouseExited((MouseEvent event) -> {
			osk.setTextFill(Color.web(Config._6));
        });
		osk.setOnMousePressed((MouseEvent event) -> {
        	open("osk.exe --kb");
        });
		
		Label mimikatz=new Label("	运行mimikatz.exe(运行jar目录下的mimikatz)");
		mimikatz.setFont(Font.font(18));
		mimikatz.setTextFill(Color.web(Config._6));
		mimikatz.setStyle("-fx-cursor: hand;");
		// 设置鼠标悬停时的样式（可选）
		mimikatz.setOnMouseEntered((MouseEvent event) -> {
			mimikatz.setTextFill(Color.LIGHTGREY);
        });
        
        // 设置鼠标离开时的样式（可选）
		mimikatz.setOnMouseExited((MouseEvent event) -> {
			mimikatz.setTextFill(Color.web(Config._6));
        });
		mimikatz.setOnMousePressed((MouseEvent event) -> {
        	runMimikatz();
        });
		

		Label m=new Label("	手动运行一个指定的程序");
		m.setFont(Font.font(18));
		m.setTextFill(Color.web(Config._6));
		m.setStyle("-fx-cursor: hand;");
		// 设置鼠标悬停时的样式（可选）
		m.setOnMouseEntered((MouseEvent event) -> {
			m.setTextFill(Color.LIGHTGREY);
        });
        
        // 设置鼠标离开时的样式（可选）
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
        mStage.setTitle("手动运行...");
        mStage.initOwner(owner); // 设置所有者窗口
        mStage.initModality(Modality.NONE); // 设置模态类型
        VBox v=new VBox();
        
        Label title=new Label("手动运行程序");
        title.setFont(Font.font(32));
        title.setTextFill(Color.WHITE	);
        Label note=new Label("该方法调用为直接调用下面的命令，如果是能直接在终端运行的请在前面加上start加上一个空格，如start cmd");
        note.setWrapText(true); // 启用文本换行
        title.setFont(Font.font(32));
        note.setFont(Font.font(16));
        title.setTextFill(Color.WHITE	);
        note.setTextFill(Color.WHITE	);
        TextField cmd=new TextField();
        Button run=new Button("运行");
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
