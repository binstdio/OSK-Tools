package base;

import fx.Home;
import fx.Man;
import fx.Pw;
import fx.Run;
import fx.Set;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SMaker {
	public static Group maker(VBox root) {
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
        rootOut.setToValue(0.0);   // ������͸����
        rootOut.setCycleCount(1);  // ѭ������
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
			rootOut.play();
			shrinkTransitionRun.setOnFinished(eventFinished -> {
		        // ������ɺ��л�����
		        Man.setSence(Run.sRun);
		        root.setStyle("-fx-opacity: 1.0;");
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
		Group giant=new Group();
		giant.getChildren().addAll(bg, rect, menu, menuRect, home, run, pw, set, root);
		return giant;
	}
}
