package fx;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;
import javafx.util.Duration;
import java.time.LocalTime;
import base.Info;
import base.L;
import base.SMaker;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Home {
	public static Group giant=new Group();
	public static Scene sHome=new Scene(giant,800,600);
	public static VBox root=new VBox();
	 /**
     * 根据当前时间返回相应的问候语。
     *
     * @return 对应的问候语字符串
     */
    public static String getGreeting() {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();

        if (hour >= 6 && hour < 12) {
            return "早上好";
        } else if (hour >= 12 && hour < 14) {
            return "中午好";
        } else if (hour >= 14 && hour < 18) {
            return "下午好";
        } else if (hour >= 18 && hour < 21) {
            return "晚上好";
        } else {
            return "晚上好好好好好——啊，该睡觉了哦";
        }
    }
	public static void initS() {
		Label welcome=new Label("Welcome to OSK Tools!");
		welcome.setFont(Font.font(48));
		welcome.setTextFill(Color.web(Config._4));
		Label user=new Label(Info.tab+"● "+System.getProperty("user.name")+" , "+getGreeting());
		user.setFont(Font.font(24));
		user.setTextFill(Color.web(Config._5));
		Label infos = new Label(getInfos());
		infos.setWrapText(true); // 启用自动换行
        infos.setPadding(new Insets(10)); // 设置内边距
		//infos.setFont(Font.font(16));
		infos.setStyle("-fx-font-size: 14px; -fx-max-width: 800px; -fx-min-width: 200px;");
		infos.setTextFill(Color.web(Config._5));
		root.getChildren().addAll(welcome,user,infos);
		
        
		giant.getChildren().add(SMaker.maker(root));
	}
	/**
	 * 获取关于电脑的信息
	 * @return 电脑信息
	 */
	static String getInfos() {
		String infos;
		String osName = System.getProperty("os.name");
		osName=Info.tab+"√ "+"操作系统："+osName+"\n";
		String cpuName = null;
        if (osName.toLowerCase().contains("windows")) {
            cpuName = getCPUNameWindows();
        } else {
            cpuName = "未知或在非WIndows系统下运行";
        }
        cpuName=Info.tab+"√ "+"CPU："+cpuName+"\n";
        String model = null;
        try {
			model=getWindowsModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        model=Info.tab+"√ 型号："+model+"\n";
        
        String ip=Info.tab+"√ ipv4&ipv6地址：\n";
        List<NetworkInterfaceInfo> networkList = getNetworkInterfacesInfo();
        for (NetworkInterfaceInfo info : networkList) {
            ip=ip+info;
        }
        ip=ip+"\n";
        
        String tips=Info.tab+"⚠ 确保当前账户具有管理员权限\n";
		infos=osName+cpuName+model+ip+tips;
		return infos;
		
	}
	
	// 定义命令字符串为常量
    private static final String WMIC_COMMAND = "wmic cpu get name";
    private static final String POWERSHELL_COMMAND = "powershell -Command \"Get-CimInstance -ClassName Win32_Processor | Select-Object -ExpandProperty Name\"";

    private static String getCPUNameWindows() {
        String cpuName = "";

        // 尝试使用 wmic
        cpuName = executeCommand(WMIC_COMMAND);
        if (!cpuName.isEmpty()) {
            L.l.info("成功使用 wmic 获取到CPU名称: " + cpuName);
            return cpuName;
        } else {
            L.l.warning("无法使用 wmic 获取CPU名称，尝试使用 PowerShell...");
        }

        // 如果 wmic 失败，尝试使用 PowerShell
        cpuName = executeCommand(POWERSHELL_COMMAND);
        if (!cpuName.isEmpty()) {
            L.l.info("成功使用 PowerShell 获取到CPU名称: " + cpuName);
            return cpuName;
        } else {
            L.l.severe("无法使用 PowerShell 获取CPU名称");
        }

        // 如果所有尝试都失败，返回默认值
        L.l.warning("无法获取CPU名称，返回默认值");
        return "未知";
    }

    /**
     * 执行给定的命令并返回输出结果。
     *
     * @param command 要执行的命令字符串
     * @return 命令的输出结果，如果失败则返回空字符串
     */
    private static String executeCommand(String command) {
        try {
            ProcessBuilder pb = new ProcessBuilder(command.split(" "));
            Process process = pb.start();

            // 使用 try-with-resources 确保资源被关闭
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                StringBuilder output = new StringBuilder();
                String line;
                // 读取所有输出行
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                // 解析输出
                String outputStr = output.toString();
                Pattern pattern = Pattern.compile("^Name\\s*\\r?\\n(.*)$", Pattern.MULTILINE);
                Matcher matcher = pattern.matcher(outputStr);
                if (matcher.find()) {
                    return matcher.group(1).trim();
                }

                // 如果正则匹配失败，尝试使用简单的分割
                String[] lines = outputStr.split("\n");
                for (String l : lines) {
                    if (!l.trim().isEmpty() && !l.toLowerCase().contains("name")) {
                        return l.trim();
                    }
                }
            }
        } catch (IOException e) {
            L.l.warning("执行命令失败: " + command + "，错误信息: " + e.getMessage());
        }
        return "";
    }
	private static String getWindowsModel() {
        String model = "";

        // 尝试使用 wmic
        try {
            ProcessBuilder pb = new ProcessBuilder("wmic", "csproduct", "get", "name");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.toLowerCase().contains("name")) {
                    model = line.trim();
                    break;
                }
            }
            reader.close();
            // 如果成功获取到型号，直接返回
            if (!model.isEmpty()) {
                L.l.info("成功使用 wmic 获取到电脑型号: " + model);
                return model;
            }
        } catch (Exception e) {
            L.l.warning("无法使用 wmic 获取电脑型号，尝试使用 PowerShell...");
        }

        // 如果 wmic 失败，尝试使用 PowerShell
        try {
            // 使用 PowerShell 命令获取电脑型号
            ProcessBuilder pb = new ProcessBuilder("powershell", "-Command", "Get-CimInstance -ClassName Win32_ComputerSystem | Select-Object -ExpandProperty Model");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    model = line.trim();
                    break;
                }
            }
            reader.close();
            // 如果成功获取到型号，返回
            if (!model.isEmpty()) {
                L.l.info("成功使用 PowerShell 获取到电脑型号: " + model);
                return model;
            }
        } catch (Exception e) {
            L.l.severe("无法使用 PowerShell 获取电脑型号: " + e.getMessage());
        }

        // 如果所有尝试都失败，返回默认值
        L.l.warning("无法获取电脑型号，返回默认值");
        return "未知";
    }
	/**
     * 获取所有网络接口的IPv4和IPv6地址
     *
     * @return 一个包含每个网络接口及其对应IP地址的列表
     */
    public static List<NetworkInterfaceInfo> getNetworkInterfacesInfo() {
        List<NetworkInterfaceInfo> networkList = new ArrayList<>();

        try {
            // 获取所有网络接口
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();

                // 过滤掉无效的网络接口
                if (ni.isUp() && !ni.isLoopback()) {
                    NetworkInterfaceInfo info = new NetworkInterfaceInfo();
                    info.setName(ni.getName());
                    info.setDisplayName(ni.getDisplayName());

                    // 获取IPv4地址
                    Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress ia = inetAddresses.nextElement();
                        if (ia.getAddress().length == 4) { // IPv4地址长度为4字节
                            info.getIpv4Addresses().add(ia.getHostAddress());
                        }
                    }

                    // 获取IPv6地址
                    inetAddresses = ni.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress ia = inetAddresses.nextElement();
                        if (ia.getAddress().length == 16) { // IPv6地址长度为16字节
                            info.getIpv6Addresses().add(ia.getHostAddress());
                        }
                    }

                    networkList.add(info);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return networkList;
    }
    public static class NetworkInterfaceInfo {
        private String name;
        private String displayName;
        private List<String> ipv4Addresses = new ArrayList<>();
        private List<String> ipv6Addresses = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public List<String> getIpv4Addresses() {
            return ipv4Addresses;
        }

        public List<String> getIpv6Addresses() {
            return ipv6Addresses;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            //sb.append("网络接口名称: ").append(name).append(";");
            sb.append(Info.tab).append("适配器名称: ").append(displayName).append("\n");
            sb.append(Info.tab).append("IPv4 地址: ").append(ipv4Addresses).append("\n");
            sb.append(Info.tab).append("IPv6 地址: ").append(ipv6Addresses).append("\n");
            return sb.toString();
        }
    }

}
