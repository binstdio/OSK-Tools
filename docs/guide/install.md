---
prev:
    text: 什么是 OSK Tools？
    link: /docs/guide/
next: false
---

# 快速安装 OSK Tools
## 在开始之前
::: warning :notebook: 提醒
- 以下来自 GitHub 的链接，如果打不开，可以将 `.com` 改为 `.store`。镜像服务由 [GitHub Proxy](https://ghproxy.cn) 提供，请勿滥用。
- OSK Tools 提供密码提取，其服务由 [mimikatz](https://github.com/ParrotSec/mimikatz) 提供。如遇到杀毒软件 (如**火绒安全软件**、**360安全卫士**、**Windows Defender**) 拦截，请允许。
:::


## 下载和安装依赖
OSK Tools 的启动需要 [Java](https://www.java.com/en/download/help/whatis_java.html) 及 [JavaFX](https://openjfx.cn) 的支持。其中， JavaFX 只在 JDK8、JDK9、JDK10 中内置。其他版本的 JDK 需要自行安装 JavaFX。

你可以通过下载下方链接来下载 `jdk-8u202` EXE 可执行安装程序。如果你已经安装了 JDK 且确保能用 JavaFX，则无需下载。下载服务器由 [华为云](https://www.huaweicloud.com) 提供。

[JDK8u202 64位下载](http://repo.huaweicloud.com/java/jdk/8u202-b08/jdk-8u202-windows-x64.exe) &nbsp;&nbsp; [JDK8u202 32位 (i586)下载](http://repo.huaweicloud.com/java/jdk/8u202-b08/jdk-8u202-windows-i586.exe)



## 下载 OSK Tools
前往 GitHub 下载最新版的 OSK Tools：[GitHub Release](https://github.com/binstdio/OSK-Tools/releases/latest)。

如果你在 GitHub 下载的速度很慢，可使用 [GitHub Proxy](https://ghproxy.cn) 进行下载加速。

::: tip :notebook: 区别 / 比较
在 [GitHub Release](https://github.com/binstdio/OSK-Tools/releases/latest) 下载文件时你也许会无法决定下载哪个文件，在这里给出一点提示。


- `xxx_Auto.zip`：自动安装方式。下载并解压这个压缩包后，可双击 `install.exe`，安装程序会协助你完成 OSK Tools 的安装。
- `xxx_Manual.zip`：手动安装方式。下载并解压这个压缩包后，须手动将 OSK Tools 移动到 System32。
:::

## 安装 OSK Tools
OSK Tools 有两种安装方式：**自动安装** 和 **手动安装**。
::: warning :warning: 注意
**OSK Tools 的两种安装方式均需要能直接操控 `System32` 文件夹的权限**，可以去类似 PE 这种环境运行 `install.exe` 或手动替换 osk。如果你坚持要在运行中且**已进入桌面环境**的目标系统安装 OSK Tools，请将操作用户的权限**提高**：`系统盘符:\Windows\System32\osk.exe`，具体方法请自行 Google。
:::

### 自动安装
从 OSK Tools 仓库下载带 `Auto` 字样的[最新版本](https://github.com/binstdio/OSK-Tools/releases/latest)压缩包，并解压。其内部通常会带有一个 `install.exe`。双击安装程序，即可按照提示将 OSK Tools 安装到目标系统。注意：**此时仍需必要的权限，如没有请提权。**

### 手动安装
从 OSK Tools 仓库下载带 `Manual` 字样的[最新版本](https://github.com/binstdio/OSK-Tools/releases/latest)压缩包，并解压。此时的目录结构应为如下所示。

假设解压出来的 OSK Tools 文件夹名为 `OSK-Tools_Windows_Rel2501_Manual`，{下载}文件夹为 `Downloads`。

```
Downloads\OSK-Tools_Windows_Rel2501_Manual
    ├── osktools
    └── osk.exe
```


将里面的 `osktools` 文件夹整个移动到 `系统盘符:\Program Files\` 文件夹内即可。此时的目录结构应为如下所示。

假设系统盘符为 `C:`，`jre`、`mimikatz`、`osk.exe`、`osk.jar` 均在 `osktools` 文件夹内。

```
C:\Program Files\osktools
    ├── jre
    ├── mimikatz
    ├── osk.exe
    └── osk.jar
```

来到 `系统盘符:\Windows\System32\`，将 `osk.exe` 提权 (如果还没有的话)，把 `osk.exe` 重命名为 `osk_bak.exe` (不要删掉)。

回到解压压缩包的目录，此时只有在 `osktools` 文件夹外的 `osk.exe` (大约 `7 MB`) 尚未被操作，这个就是 `launcher` (启动 OSK Tools 时用的)。将这个 `osk.exe` 移动到 `系统盘符:\Windows\System32\`。此时的 System32 文件夹应有 `osk.exe` (已替换) 和 `osk_bak.exe`。其中的 `osk.exe` 就是 OSK Tools 启动器， OSK Tools 本体在 `Program Files\osktools\` 文件夹内。

---

完成后，按住 `Windows`+`R` 键，呼出**运行**窗口。输入 `osk` 并确定，如果出现的是 OSK Tools，那么说明你成功安装了 OSK Tools。🎉🎉🎉 恭喜你 🎉🎉🎉。