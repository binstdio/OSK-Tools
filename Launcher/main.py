import os
import subprocess
import argparse

def run_osk_bak():
    """运行 osk_bak.exe"""
    print("正在运行 osk_bak.exe...")
    try:
        subprocess.run(["osk_bak.exe"], check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        print("osk_bak.exe 运行成功！")
    except subprocess.CalledProcessError as e:
        print(f"运行 osk_bak.exe 时发生错误: {e}")

def run_osk_jar():
    """运行 osk.jar"""
    print("正在启动 osk.jar...")
    try:
        # 设置具体的路径
        osktools_dir = "C:/Program Files/osktools"
        jar_path = os.path.join(osktools_dir, "osk.jar")
        java_exe_path = os.path.join(osktools_dir, "jre", "bin", "java.exe")
        
        print(f"osk.jar 路径: {jar_path}")
        print(f"Java 路径: {java_exe_path}")
        
        # 使用指定的 java 启动 osk.jar
        subprocess.run([java_exe_path, "-jar", jar_path], check=True, cwd=osktools_dir, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        print("osk.jar 启动成功！")
    except subprocess.CalledProcessError as e:
        print(f"运行 osk.jar 时发生错误: {e}")
    except FileNotFoundError as e:
        print(f"找不到文件或路径错误: {e}")

def check_user_in_file(file_path, user_name):
    """检查用户是否在文件中"""
    print(f"正在检查用户 {user_name} 是否在文件 {file_path} 中...")
    try:
        with open(file_path, "r", encoding="utf-8") as file:
            users = file.readlines()
        users = [user.strip() for user in users]
        
        if user_name in users:
            print(f"用户 {user_name} 在列表中。")
            return True
        else:
            print(f"用户 {user_name} 不在列表中。")
            return False
    except FileNotFoundError:
        print(f"文件 {file_path} 未找到。")
        return False

def main():
    # 使用 argparse 解析命令行参数
    parser = argparse.ArgumentParser(description="控制程序运行 osk_bak.exe 或 osk.jar")
    parser.add_argument('--kb', action='store_true', help='运行 osk_bak.exe')
    parser.add_argument('--tools', action='store_true', help='运行 osk.jar')

    args = parser.parse_args()

    # 判断命令行参数的优先级
    if args.kb and args.tools:
        print("检测到 --kb 和 --tools 参数，视为不带参数，默认运行 osk.jar")
        run_osk_jar()
    elif args.kb:
        print("检测到 --kb 参数，运行 osk_bak.exe")
        run_osk_bak()
    elif args.tools:
        print("检测到 --tools 参数，运行 osk.jar")
        run_osk_jar()
    else:
        print("未指定 --kb 或 --tools 参数，开始检查用户信息...")

        # 获取当前用户名
        user_name = os.getlogin()  
        file_path = "C:/Program Files/osktools/wl.txt"
        
        # 检查用户是否在 wl.txt 中
        if os.path.exists(file_path):
            if check_user_in_file(file_path, user_name):
                run_osk_bak()
            else:
                run_osk_jar()
        else:
            print(f"文件 {file_path} 不存在，默认运行 osk.jar")
            run_osk_jar()

if __name__ == "__main__":
    main()
