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
		// 设置高斯模糊
		GaussianBlur gaussianBlur = new GaussianBlur();
		gaussianBlur.setRadius(5); // 模糊半径
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
        rootOut.setFromValue(1.0); // 起始不透明度
        rootOut.setToValue(0.0);   // 结束不透明度
        rootOut.setCycleCount(1);  // 循环次数
        rootOut.setAutoReverse(true); // 是否自动反转
		
		// 底部图标显示

		// home
		ImageView home = new ImageView(new Image("/res/home.jpg"));
		home.setX(10);
		home.setY(505);

		home.setPreserveRatio(true);
		home.setPickOnBounds(true); // 确保图片透明部分也能响应点击
		// 定义缩小动画（针对 home 节点）
		ScaleTransition shrinkTransitionHome = new ScaleTransition(Duration.millis(100), home);
		shrinkTransitionHome.setToX(0.85);
		shrinkTransitionHome.setToY(0.85);
		shrinkTransitionHome.setInterpolator(Interpolator.EASE_IN);

		// 定义弹起动画（针对 home 节点）
		ScaleTransition growTransitionHome = new ScaleTransition(Duration.millis(100), home);
		growTransitionHome.setToX(1.0);
		growTransitionHome.setToY(1.0);
		growTransitionHome.setInterpolator(Interpolator.EASE_OUT);

		// 添加鼠标按下事件监听器
		home.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			shrinkTransitionHome.playFromStart();
			rootOut.play();
			shrinkTransitionHome.setOnFinished(eventFinished -> {
		        // 动画完成后切换场景
		        Man.setSence(Home.sHome);
		        root.setStyle("-fx-opacity: 1.0;");
		    });
		});

		// 添加鼠标释放事件监听器
		home.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			growTransitionHome.playFromStart();
			// 可选：处理点击事件
		});

		// 可选：处理鼠标退出事件，防止在鼠标未释放时动画未恢复
		home.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			growTransitionHome.playFromStart();
		});

		// 可选：添加点击事件处理器
		home.setOnMouseClicked(event -> {
			// 这里可以添加点击后的具体操作

		});

		// run
		ImageView run = new ImageView(new Image("/res/run.jpg"));
		run.setX(10 + 50 + 10);
		run.setY(505);

		run.setPreserveRatio(true);
		run.setPickOnBounds(true); // 确保图片透明部分也能响应点击

		// 定义缩小动画（针对 run 节点）
		ScaleTransition shrinkTransitionRun = new ScaleTransition(Duration.millis(100), run);
		shrinkTransitionRun.setToX(0.85);
		shrinkTransitionRun.setToY(0.85);
		shrinkTransitionRun.setInterpolator(Interpolator.EASE_IN);

		// 定义弹起动画（针对 run 节点）
		ScaleTransition growTransitionRun = new ScaleTransition(Duration.millis(100), run);
		growTransitionRun.setToX(1.0);
		growTransitionRun.setToY(1.0);
		growTransitionRun.setInterpolator(Interpolator.EASE_OUT);

		// 添加鼠标按下事件监听器
		run.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			shrinkTransitionRun.playFromStart();
			rootOut.play();
			shrinkTransitionRun.setOnFinished(eventFinished -> {
		        // 动画完成后切换场景
		        Man.setSence(Run.sRun);
		        root.setStyle("-fx-opacity: 1.0;");
		    });
		});

		// 添加鼠标释放事件监听器
		run.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			growTransitionRun.playFromStart();
			// 可选：处理点击事件
		});

		// 可选：处理鼠标退出事件，防止在鼠标未释放时动画未恢复
		run.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			growTransitionRun.playFromStart();
		});

		// 可选：添加点击事件处理器
		run.setOnMouseClicked(event -> {
			// 这里可以添加点击后的具体操作

		});

		// pw
		ImageView pw = new ImageView(new Image("/res/pw.jpg"));
		pw.setX(10 + 50 + 10 + 50 + 10 + 50 + 10);
		pw.setY(505);

		pw.setPreserveRatio(true);
		pw.setPickOnBounds(true); // 确保图片透明部分也能响应点击

		// 定义缩小动画（针对 Pw 节点）
		ScaleTransition shrinkTransitionPw = new ScaleTransition(Duration.millis(100), pw);
		shrinkTransitionPw.setToX(0.85);
		shrinkTransitionPw.setToY(0.85);
		shrinkTransitionPw.setInterpolator(Interpolator.EASE_BOTH);

		// 定义弹起动画（针对 Pw 节点）
		ScaleTransition growTransitionPw = new ScaleTransition(Duration.millis(100), pw);
		growTransitionPw.setToX(1.0);
		growTransitionPw.setToY(1.0);
		growTransitionPw.setInterpolator(Interpolator.EASE_BOTH);

		// 添加鼠标按下事件监听器
		pw.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			shrinkTransitionPw.playFromStart();
			rootOut.play();
			shrinkTransitionPw.setOnFinished(eventFinished -> {
		        // 动画完成后切换场景
		        Man.setSence(Pw.sPw);
		        root.setStyle("-fx-opacity: 1.0;");
		    });
		});

		// 添加鼠标释放事件监听器
		pw.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			growTransitionPw.playFromStart();
			// 可选：处理点击事件
		});

		// 可选：处理鼠标退出事件，防止在鼠标未释放时动画未恢复
		pw.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			growTransitionPw.playFromStart();
		});

		// 可选：添加点击事件处理器
		pw.setOnMouseClicked(event -> {
			// 这里可以添加点击后的具体操作

		});

		// set
		ImageView set = new ImageView(new Image("/res/set.jpg"));
		set.setX(10 + 50 + 10 + 50 + 10);
		set.setY(505);

		set.setPreserveRatio(true);
		set.setPickOnBounds(true); // 确保图片透明部分也能响应点击

		// 定义缩小动画（针对 Set 节点）
		ScaleTransition shrinkTransitionSet = new ScaleTransition(Duration.millis(100), set);
		shrinkTransitionSet.setToX(0.85);
		shrinkTransitionSet.setToY(0.85);
		shrinkTransitionSet.setInterpolator(Interpolator.EASE_BOTH);

		// 定义弹起动画（针对 Set 节点）
		ScaleTransition growTransitionSet = new ScaleTransition(Duration.millis(100), set);
		growTransitionSet.setToX(1.0);
		growTransitionSet.setToY(1.0);
		growTransitionSet.setInterpolator(Interpolator.EASE_BOTH);

		// 添加鼠标按下事件监听器
		set.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			shrinkTransitionSet.playFromStart();
			rootOut.play();
			shrinkTransitionSet.setOnFinished(eventFinished -> {
		        // 动画完成后切换场景
		        Man.setSence(Set.sSet);
		        root.setStyle("-fx-opacity: 1.0;");
		    });
		});

		// 添加鼠标释放事件监听器
		set.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			growTransitionSet.playFromStart();
			// 可选：处理点击事件
		});

		// 可选：处理鼠标退出事件，防止在鼠标未释放时动画未恢复
		set.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			growTransitionSet.playFromStart();
		});

		// 可选：添加点击事件处理器
		set.setOnMouseClicked(event -> {
			// 这里可以添加点击后的具体操作

		});
		Group giant=new Group();
		giant.getChildren().addAll(bg, rect, menu, menuRect, home, run, pw, set, root);
		return giant;
	}
}
