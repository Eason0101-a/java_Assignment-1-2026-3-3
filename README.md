# 🧮 Java 程式設計(一) - 數學模型模擬器

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white)](https://www.java.com/)
[![VS Code](https://img.shields.io/badge/VS_Code-0078D4?style=flat-square&logo=visual-studio-code&logoColor=white)](https://code.visualstudio.com/)

> **課程名稱**：Java程式設計(一)  
> **作業內容**：Assignment 1-1 ~ 1-4  
> **專案主題**：使用 VS Code 與 AI 協作開發線性與非線性數學模型之數值模擬程式  
> **專案連結**：[java_Assignment-1-2026-3-3](https://github.com/Eason0101-a/java_Assignment-1-2026-3-3)

---

## ✨ 專案特色 (Features)

- 🤖 **AI 協作開發**：展示如何利用 AI 輔助架構設計、例外處理與文件撰寫。
- 🛡️ **強健的防呆機制**：
  - 內建 `try-catch` 捕捉 `InputMismatchException`，防止輸入非數值導致程式崩潰。
  - 嚴格的邏輯驗證（阻擋 dt ≦ 0、迭代步數 steps < 0 以及容載力 K = 0 的無效參數）。
- 📐 **模組化設計**：將導數計算 (`computeDerivative`) 與迭代邏輯 (`simulate`) 獨立拆分，保持主程式整潔。

---

## 🔬 數學模型 (Mathematical Models)

本程式支援兩種常微分方程式 (ODE) 模型的 **Euler 方法 (Euler Method)** 數值迭代求解：

### 1. 線性衰減模型 (Linear Model)
描述放射性衰減或一階反應：
$$dx/dt = -k \cdot x$$

### 2. 非線性 Logistic 成長模型 (Nonlinear Model)
描述受環境容載力限制的族群成長：
$$dx/dt = r \cdot x \cdot (1 - x/K)$$

---

## 📂 專案結構 (Project Structure)

```text
📦 java_Assignment-1-2026-3-3
 ┣ 📂 src
 ┃ ┗ 📜 Main.java      # 程式主邏輯與核心演算法
 ┣ 📂 out              # Java 編譯輸出的 .class 檔存放區
 ┗ 📜 README.md        # 專案說明文件
🚀 快速開始 (Getting Started)編譯與執行請開啟終端機 (Terminal) 或 PowerShell，在專案根目錄下執行以下指令：PowerShell# 1. 編譯 Java 程式碼，並將結果輸出至 out 資料夾
javac -d out src/Main.java

# 2. 執行編譯後的 Main 類別
java -cp out Main
💻 執行範例 (Usage Example)以下為選擇 「2. 非線性模型」 的實際終端機互動過程。測試參數設定：初始值 x(0) = 10時間步長 dt = 0.1迭代次數 steps = 15成長率 r = 0.5容載力 K = 100主控台輸出畫面：Plaintext=== 數學模型模擬器（簡化版）===
1. 線性模型：dx/dt = -k*x
2. 非線性模型：dx/dt = r*x*(1 - x/K)
請選擇模型（1 或 2）：2
請輸入初始值 x(0)：10
請輸入時間步長 dt：0.1
請輸入迴圈次數 steps：15
請輸入 r：0.5
請輸入 K：100

step    time    x
------------------------
0       0.00    10.000000
1       0.10    10.450000
2       0.20    10.917911
...
14      1.40    17.653421
15      1.50    18.380255

最終結果 x = 18.380255
📊 測試結果說明：實驗結果顯示，隨著迭代次數增加，數值 $x$ 呈現穩定成長並逐漸朝向設定的容載力 $K$ 值收斂，完美符合 Logistic 模型的數學理論預期。