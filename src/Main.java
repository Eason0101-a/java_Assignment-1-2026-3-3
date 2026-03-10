import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static double computeDerivative(int model, double x, double a, double b) {
        if (model == 1) {
            // Linear model: dx/dt = -k*x
            return -a * x;
        }
        // Nonlinear logistic model: dx/dt = r*x*(1 - x/K)
        return a * x * (1 - x / b);
    }

    private static void simulate(int model, double x0, double dt, int steps, double a, double b) {
        double x = x0;

        System.out.println("\nstep\ttime\tx");
        System.out.println("------------------------");

        for (int i = 0; i <= steps; i++) {
            double time = i * dt;
            System.out.printf("%d\t%.2f\t%.6f%n", i, time, x);

            if (i == steps) {
                break;
            }

            double dxdt = computeDerivative(model, x, a, b);
            x = x + dt * dxdt;
        }

        System.out.printf("\n最終結果 x = %.6f%n", x);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.println("=== 數學模型模擬器（簡化版）===");
                System.out.println("1. 線性模型：dx/dt = -k*x");
                System.out.println("2. 非線性模型：dx/dt = r*x*(1 - x/K)");

                System.out.print("請選擇模型（1 或 2）：");
                int model = scanner.nextInt();
                if (model != 1 && model != 2) {
                    System.out.println("模型選擇錯誤，請重新執行並輸入 1 或 2。");
                    return;
                }

                System.out.print("請輸入初始值 x(0)：");
                double x = scanner.nextDouble();

                System.out.print("請輸入時間步長 dt：");
                double dt = scanner.nextDouble();

                System.out.print("請輸入迴圈次數 steps：");
                int steps = scanner.nextInt();
                if (dt <= 0 || steps < 0) {
                    System.out.println("dt 必須大於 0，steps 不能小於 0。");
                    return;
                }

                double a;
                double b = 0;

                if (model == 1) {
                    System.out.print("請輸入 k：");
                    a = scanner.nextDouble();
                } else {
                    System.out.print("請輸入 r：");
                    a = scanner.nextDouble();
                    System.out.print("請輸入 K：");
                    b = scanner.nextDouble();
                    if (b == 0) {
                        System.out.println("K 不能為 0。");
                        return;
                    }
                }

                simulate(model, x, dt, steps, a, b);
            } catch (InputMismatchException e) {
                System.out.println("輸入格式錯誤，請重新執行並輸入數字。");
            }
        }
    }
}
