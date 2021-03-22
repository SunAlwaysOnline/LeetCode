package leetcode.medium.phase4;

import method.WaitForComplete;

/**
 * @author qcy
 * @create 2021/03/22 09:15:20
 */
@WaitForComplete
public class Number353 {

    class SnakeGame {
        //蛇头的坐标
        int x;
        int y;
        //得分
        int score;

        /**
         * Initialize your data structure here.
         *
         * @param width  - screen width
         * @param height - screen height
         * @param food   - A list of food positions
         *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        public SnakeGame(int width, int height, int[][] food) {

        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            return -1;
        }
    }

}
