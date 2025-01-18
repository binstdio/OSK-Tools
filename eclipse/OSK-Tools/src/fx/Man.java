package fx;
import base.Info;
import base.L;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Man extends Application{
    public static void setSence(Scene scene) {
    	L.l.info("ÇÐ»»Scene");
    	Root.stage.setScene(scene);
    }
    public static void startHome() {
		Application.launch(Man.class,Info.args);
	}
    @Override
    public void init() {
    	Config.initConfig();
    	Run.initS();
    	Pw.initS();
    	Set.initS();
    }
    
	@Override
	public void start(Stage s) throws Exception {
		// TODO Auto-generated method stub
		Root.stage.setResizable(false);
		Root.stage.setTitle(Info.title);
		Root.stage.setWidth(Info.w);
		Root.stage.setHeight(Info.h);
		Home.initS();
		setSence(Home.sHome);
		Root.stage.show();
	}
}
