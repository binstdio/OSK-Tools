package fx;

import java.io.IOException;

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
		
		Image imagebg = new Image("/res/bg.jpg");
		ImageView bg = new ImageView(imagebg);
		bg.setFitWidth(800);
		bg.setFitHeight(600);
		bg.setPreserveRatio(true);
		bg.setX(0);
		bg.setY(0);
		// ���ø�˹ģ��
		GaussianBlur gaussianBlur = new GaussianBlur();
		gaussianBlur.setRadius(5); // ģ���뾶
		bg.setEffect(gaussianBlur);

		Rectangle rect = new Rectangle(800, 600);
		rect.setFill(new Color(1, 1, 1, 0.05)); // (R, G, B, opacity)

		Image imageMenu = new Image("/res/bg.jpg");
		ImageView menu = new ImageView(imageMenu);
		Rectangle2D viewportRect = new Rectangle2D(0, 500, 800, 100);
		menu.setViewport(viewportRect);
		menu.setX(0);
		menu.setY(500);
		gaussianBlur.setRadius(20);
		menu.setEffect(gaussianBlur);
		Rectangle menuRect = new Rectangle(800, 600);
		menuRect.setFill(new Color(1, 1, 1, 0.4)); // (R, G, B, opacity)
		menuRect.setX(0);
		menuRect.setY(500);

		FadeTransition rootOut = new FadeTransition(Duration.seconds(0.1), root);
		rootOut.setFromValue(1.0); // ��ʼ��͸����
		rootOut.setToValue(0.0); // ������͸����
		rootOut.setCycleCount(1); // ѭ������
		rootOut.setAutoReverse(true); // �Ƿ��Զ���ת

		// �ײ�ͼ����ʾ

		// home
		ImageView home = new ImageView(new Image("/res/home.jpg"));
		home.setX(10);
		home.setY(505);

		home.setPreserveRatio(true);
		home.setPickOnBounds(true); // ȷ��ͼƬ͸������Ҳ����Ӧ���
		// ������С��������� home �ڵ㣩
		ScaleTransition shrinkTransitionHome = new ScaleTransition(Duration.millis(100), home);
		shrinkTransitionHome.setToX(0.85);
		shrinkTransitionHome.setToY(0.85);
		shrinkTransitionHome.setInterpolator(Interpolator.EASE_IN);

		// ���嵯�𶯻������ home �ڵ㣩
		ScaleTransition growTransitionHome = new ScaleTransition(Duration.millis(100), home);
		growTransitionHome.setToX(1.0);
		growTransitionHome.setToY(1.0);
		growTransitionHome.setInterpolator(Interpolator.EASE_OUT);

		// �����갴���¼�������
		home.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			shrinkTransitionHome.playFromStart();
			rootOut.play();
			shrinkTransitionHome.setOnFinished(eventFinished -> {
				// ������ɺ��л�����
				Man.setSence(Home.sHome);
				root.setStyle("-fx-opacity: 1.0;");
			});
		});

		// �������ͷ��¼�������
		home.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			growTransitionHome.playFromStart();
			// ��ѡ���������¼�
		});

		// ��ѡ����������˳��¼�����ֹ�����δ�ͷ�ʱ����δ�ָ�
		home.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			growTransitionHome.playFromStart();
		});

		// ��ѡ����ӵ���¼�������
		home.setOnMouseClicked(event -> {
			// ���������ӵ����ľ������

		});

		// run
		ImageView run = new ImageView(new Image("/res/run.jpg"));
		run.setX(10 + 50 + 10);
		run.setY(505);

		run.setPreserveRatio(true);
		run.setPickOnBounds(true); // ȷ��ͼƬ͸������Ҳ����Ӧ���

		// ������С��������� run �ڵ㣩
		ScaleTransition shrinkTransitionRun = new ScaleTransition(Duration.millis(100), run);
		shrinkTransitionRun.setToX(0.85);
		shrinkTransitionRun.setToY(0.85);
		shrinkTransitionRun.setInterpolator(Interpolator.EASE_IN);

		// ���嵯�𶯻������ run �ڵ㣩
		ScaleTransition growTransitionRun = new ScaleTransition(Duration.millis(100), run);
		growTransitionRun.setToX(1.0);
		growTransitionRun.setToY(1.0);
		growTransitionRun.setInterpolator(Interpolator.EASE_OUT);

		// �����갴���¼�������
		run.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			shrinkTransitionRun.playFromStart();
			shrinkTransitionRun.setOnFinished(eventFinished -> {
				// ������ɺ��л�����
				Man.setSence(Run.sRun);
			});
		});

		// �������ͷ��¼�������
		run.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			growTransitionRun.playFromStart();
			// ��ѡ���������¼�
		});

		// ��ѡ����������˳��¼�����ֹ�����δ�ͷ�ʱ����δ�ָ�
		run.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			growTransitionRun.playFromStart();
		});

		// ��ѡ����ӵ���¼�������
		run.setOnMouseClicked(event -> {
			// ���������ӵ����ľ������

		});

		// pw
		ImageView pw = new ImageView(new Image("/res/pw.jpg"));
		pw.setX(10 + 50 + 10 + 50 + 10 + 50 + 10);
		pw.setY(505);

		pw.setPreserveRatio(true);
		pw.setPickOnBounds(true); // ȷ��ͼƬ͸������Ҳ����Ӧ���

		// ������С��������� Pw �ڵ㣩
		ScaleTransition shrinkTransitionPw = new ScaleTransition(Duration.millis(100), pw);
		shrinkTransitionPw.setToX(0.85);
		shrinkTransitionPw.setToY(0.85);
		shrinkTransitionPw.setInterpolator(Interpolator.EASE_BOTH);

		// ���嵯�𶯻������ Pw �ڵ㣩
		ScaleTransition growTransitionPw = new ScaleTransition(Duration.millis(100), pw);
		growTransitionPw.setToX(1.0);
		growTransitionPw.setToY(1.0);
		growTransitionPw.setInterpolator(Interpolator.EASE_BOTH);

		// �����갴���¼�������
		pw.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			shrinkTransitionPw.playFromStart();
			rootOut.play();
			shrinkTransitionPw.setOnFinished(eventFinished -> {
				// ������ɺ��л�����
				Man.setSence(Pw.sPw);
				root.setStyle("-fx-opacity: 1.0;");
			});
		});

		// �������ͷ��¼�������
		pw.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			growTransitionPw.playFromStart();
			// ��ѡ���������¼�
		});

		// ��ѡ����������˳��¼�����ֹ�����δ�ͷ�ʱ����δ�ָ�
		pw.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			growTransitionPw.playFromStart();
		});

		// ��ѡ����ӵ���¼�������
		pw.setOnMouseClicked(event -> {
			// ���������ӵ����ľ������

		});

		// set
		ImageView set = new ImageView(new Image("/res/set.jpg"));
		set.setX(10 + 50 + 10 + 50 + 10);
		set.setY(505);

		set.setPreserveRatio(true);
		set.setPickOnBounds(true); // ȷ��ͼƬ͸������Ҳ����Ӧ���

		// ������С��������� Set �ڵ㣩
		ScaleTransition shrinkTransitionSet = new ScaleTransition(Duration.millis(100), set);
		shrinkTransitionSet.setToX(0.85);
		shrinkTransitionSet.setToY(0.85);
		shrinkTransitionSet.setInterpolator(Interpolator.EASE_BOTH);

		// ���嵯�𶯻������ Set �ڵ㣩
		ScaleTransition growTransitionSet = new ScaleTransition(Duration.millis(100), set);
		growTransitionSet.setToX(1.0);
		growTransitionSet.setToY(1.0);
		growTransitionSet.setInterpolator(Interpolator.EASE_BOTH);

		// �����갴���¼�������
		set.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			shrinkTransitionSet.playFromStart();
			rootOut.play();
			shrinkTransitionSet.setOnFinished(eventFinished -> {
				// ������ɺ��л�����
				Man.setSence(Set.sSet);
				root.setStyle("-fx-opacity: 1.0;");
			});
		});

		// �������ͷ��¼�������
		set.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			growTransitionSet.playFromStart();
			// ��ѡ���������¼�
		});

		// ��ѡ����������˳��¼�����ֹ�����δ�ͷ�ʱ����δ�ָ�
		set.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			growTransitionSet.playFromStart();
		});

		// ��ѡ����ӵ���¼�������
		set.setOnMouseClicked(event -> {
			// ���������ӵ����ľ������

		});

		giant.getChildren().addAll(bg, rect, menu, menuRect, home, run, pw, set, root);
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
