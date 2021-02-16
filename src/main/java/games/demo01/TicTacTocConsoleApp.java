package games.demo01;

import java.util.Scanner;

public class TicTacTocConsoleApp {

    private static int ROW = 3;
    private static int COL = 3;

    private static char[][] BOARD = new char[ROW][COL];

    private static final char EMPTY = ' ';
    private static final char COMPUTER_FLAG = '0';
    private static final char PLAYER_FLAG = 'X';
    private static final char DRAW_FLAG = 'Q';

    private static final String vSeprator = "|";
    private static final String hSeprator = "---";


    /**
     * 初始化棋盘
     */
    private static void initBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                BOARD[i][j] = EMPTY;
            }
        }
    }

    /**
     * 棋盘展示
     */
    private static void showBoard() {
        for (int i = 0; i < ROW; i++) {
            //
            for (int j = 0; j < COL; j++) {
                System.out.printf(" %c ", BOARD[i][j]);
                if (j < COL - 1) {
                    System.out.printf(vSeprator);
                }
            }
            System.out.println();
            //
            if (i < ROW - 1) {
                for (int j = 0; j < COL; j++) {
                    System.out.printf(hSeprator);
                    if (j < COL - 1) {
                        System.out.printf(vSeprator);
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * 玩家移动
     */
    private static void playerMove() {
        System.out.println("玩家移动");
        while (true) {
            System.out.printf("请输入1-3的坐标: ");
            int[] playerPos = getInputNums(2);
            if (playerPos[0] >= 1 && playerPos[0] <= ROW && playerPos[1] >= 1 && playerPos[1] <= COL) {
                if (BOARD[playerPos[0] - 1][playerPos[1] - 1] == EMPTY) {
                    BOARD[playerPos[0] - 1][playerPos[1] - 1] = PLAYER_FLAG;
                    break;
                } else {
                    System.out.println("位置已经被占用");
                }
            } else {
                System.out.println("输入错误");
            }
        }
    }


    /**
     * 电脑随机移动
     */
    private static void computerMove() {
        int computerPosX = 0;
        int computerPosY = 0;
        System.out.println("电脑移动");
        while (true) {
            computerPosX = (int) (Math.random() * 100) % ROW;
            computerPosY = (int) (Math.random() * 100) % COL;
            if (BOARD[computerPosX][computerPosY] == EMPTY) {
                BOARD[computerPosX][computerPosY] = COMPUTER_FLAG;
                break;
            }
        }
    }

    /**
     * 判断棋盘是否已满
     */
    private static boolean isFull() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (BOARD[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 检查谁胜利
     */
    private static char checkWinner() {
        // 逐行检查
        for (int i = 0; i < ROW; i++) {
//            // 仅适用于三阶
//            if (BOARD[i][0] == BOARD[i][1] && BOARD[i][1] == BOARD[i][2] && BOARD[i][0] != EMPTY) {
//                return BOARD[i][0];
//            }
            int count = 1;
            for (int j = 1; j < COL; j++) {
                if (BOARD[i][0] == BOARD[i][j]) {
                    count++;
                }
            }
            if (BOARD[i][0] != EMPTY && count == COL) {
                return BOARD[i][0];
            }
        }

        // 逐列检查
        for (int i = 0; i < COL; i++) {
//            // 仅适用于三阶
//            if (BOARD[0][i] == BOARD[1][i] && BOARD[1][i] == BOARD[2][i] && BOARD[0][i] != EMPTY) {
//                return BOARD[i][0];
//            }
            int count = 1;
            for (int j = 0; j < ROW; j++) {
                if (BOARD[0][i] == BOARD[j][i]) {
                    count++;
                }
            }
            if (BOARD[0][i] != EMPTY && count == ROW) {
                return BOARD[i][0];
            }
        }

        // 正对角线检查
//        // 仅适用于三阶
//        if (BOARD[0][0] == BOARD[1][1] && BOARD[1][1] == BOARD[2][2] && BOARD[1][1] != EMPTY) {
//            return BOARD[0][0];
//        }

        if (COL > ROW) {
            int diff = COL - ROW;
            for (int d = 0; d < diff; d++) {
                int count = 1;
                for (int i = 1; i < ROW; i++) {
                    if (BOARD[0][d] == BOARD[i][i + d]) {
                        count++;
                    }
                }
                if (BOARD[0][d] != EMPTY && count == ROW) {
                    return BOARD[0][d];
                }
            }
        } else if (ROW > COL) {
            int diff = ROW - COL;
            for (int d = 0; d < diff; d++) {
                int count = 1;
                for (int i = 1; i < COL; i++) {
                    if (BOARD[d][0] == BOARD[i + d][i]) {
                        count++;
                    }
                }
                if (BOARD[d][0] != EMPTY && count == COL) {
                    return BOARD[d][0];
                }
            }
        } else {
            int count = 1;
            for (int i = 1; i < ROW; i++) {
                if (BOARD[0][0] == BOARD[i][i]) {
                    count++;
                }
            }
            if (BOARD[0][0] != EMPTY && count == ROW) {
                return BOARD[0][0];
            }
        }


        // 副对角线检查
//        // 仅适用于三阶
//        if (BOARD[0][2] == BOARD[1][1] && BOARD[1][1] == BOARD[2][0] && BOARD[1][1] != EMPTY) {
//            return BOARD[0][2];
//        }
        if (COL > ROW) {
            int diff = COL - ROW;
            for (int d = 0; d < diff; d++) {
                int count = 1;
                for (int i = 1; i < ROW; i++) {
                    if (BOARD[0][COL - 1 + d] == BOARD[i][ROW - i - 1 + d]) {
                        count++;
                    }
                }
                if (BOARD[0][ROW - 1 - d] != EMPTY && count == ROW) {

                }
            }
        } else if (ROW > COL) {
            int diff = ROW - COL;
            for (int d = 1; d < diff; d++) {
                int count = 1;
                for (int i = 0; i < COL; i++) {
                    if (BOARD[d][COL - 1] == BOARD[i + d][COL - i - 1]) {
                        count++;
                    }
                }
                if (BOARD[d][COL - 1] != EMPTY && count == COL) {
                    return BOARD[d][COL - 1];
                }
            }
        } else {
            int count = 1;
            for (int i = 1; i < ROW; i++) {
                if (BOARD[0][ROW - 1] == BOARD[i][ROW - i - 1]) {
                    count++;
                }
            }
            if (BOARD[0][ROW - 1] != EMPTY && count == ROW) {
                return BOARD[0][ROW - 1];
            }
        }

        //判断棋盘是否已满
        if (isFull()) {
            //平局
            return DRAW_FLAG;
        }

        //谁都没有赢
        return EMPTY;
    }


    /**
     * 显示菜单
     */
    private static void menu() {
        System.out.println("*********************");
        System.out.println("*******0.exit********");
        System.out.println("*******1.play********");
        System.out.println("*********************");
    }


    // https://blog.csdn.net/ah_tao/article/details/123117653

    /**
     * 从用户输入拿到数字。
     *
     * @param inputLength 输入的长度
     * @return 输入的数字的数组
     */
    private static int[] getInputNums(int inputLength) {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[inputLength];
        for (int i = 0; i < inputLength; i++) {
            nums[i] = input.nextInt();
        }
        return nums;
    }

    private static void game() {
        initBoard();
        showBoard();
        char winner = 0;
        while (true) {
            playerMove();
            winner = checkWinner();
            showBoard();
            if (winner != EMPTY) {
                break;
            }

            computerMove();
            winner = checkWinner();
            showBoard();
            if (winner != EMPTY) {
                break;
            }
        }

        if (winner == PLAYER_FLAG) {
            System.out.println("玩家赢");
        } else if (winner == COMPUTER_FLAG) {
            System.out.println("电脑赢");
        } else {
            System.out.println("平局");
        }
    }

    public static void main(String[] args) {
        int input = 0;
        loop:
        while (true) {
            menu();
            System.out.printf("请输入你的选择：");
            input = getInputNums(1)[0];
            switch (input) {
                case 1:
                    game();
                    break;
                case 0:
                    System.out.println("游戏退出");
                    break loop;
            }
        }
    }

}
