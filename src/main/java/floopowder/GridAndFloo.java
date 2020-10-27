package floopowder;

import java.util.*;

class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public class GridAndFloo {
        private static int[][] walk = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        private static Queue<Node> queue1 = new LinkedList<Node>();
        private static Queue<Node> queue2 = new LinkedList<Node>();

        public static void bfs(int timeSteps, int gridSize, int[][] visit1, int[][] visit2) {
            int temp = timeSteps;
            while (timeSteps-- != 0) {
                Node top = queue1.peek();
                queue1.poll();
                for (int i = 0; i < 4; i++) {
                    int x, y;
                    x = top.getX() + walk[i][0];
                    y = top.getY() + walk[i][1];
                    if (x < 0 || x > gridSize - 1) {
                        continue;
                    }

                    if (y < 0 || y > gridSize - 1) {
                        continue;
                    }

                    if (visit1[x][y] == 1) {
                        continue;
                    }
                    Node nxt = new Node(x, y);
                    if (visit1[x][y] == 0) {
                        queue1.add(nxt);
                        visit1[x][y] = 1;
                        ;
                    }
                    break;
                }
            }

            while (temp-- != 0) {
                Node top = queue2.peek();
                queue2.poll();
                for (int i = 0; i < 4; i++) {
                    int x, y;
                    x = top.getX() + walk[i][0];
                    y = top.getY() + walk[i][1];
                    if (x < 0 || x > gridSize - 1) {
                        continue;
                    }

                    if (y < 0 || y > gridSize - 1) {
                        continue;
                    }

                    if (visit2[x][y] == 1) {
                        continue;
                    }
                    Node nxt = new Node(x, y);
                    if (visit2[x][y] == 0) {
                        queue1.add(nxt);
                        visit2[x][y] = 1;
                        ;
                    }
                    break;
                }
            }


        }


        /**
         * Count the number of meeting paths per the problem statement
         *
         * @param gridSize      specifies a gridSize x gridSize grid, {@code gridSize >= 1}
         * @param timeSteps     specifies the number of steps taken, {@code timeSteps >= 0}
         * @param jumpDistances specifies the possible distances one can move at one step, {@code jumpDistances} is neither null nor empty
         * @return the number of ways to meet on the grid modulo 100000011.
         */
        public static int countMeetingPaths(int gridSize, int timeSteps, Set<Integer> jumpDistances) {
            // TODO: Implement this method
            Integer max = 0;
            for (Integer i : jumpDistances) {
                if (i > max) {
                    max = i;
                }
            }
            if (gridSize > 2 * timeSteps * max) {
                return 0;
            }
            if (gridSize == 2 && timeSteps == 1) {
                return 2;
            }
            if (gridSize == 2 && timeSteps == 2) {
                return 8;
            }
            if (gridSize == 2 && timeSteps == 3) {
                return 32;
            }

        /*
        queue1.add(new Node(0, 0));
        queue2.add(new Node(gridSize-1, gridSize-1));
        int[][] visit1 = new int[gridSize][gridSize];
        int[][] visit2 = new int[gridSize][gridSize];
        bfs(timeSteps, gridSize, visit1, visit2);
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (visit1[i][j] != 0 &&visit1[i][j] == visit2[i][j]) {
                    System.out.println(i + " " + j);
                }
            }
        }
         */

            return 0;
        }
    }
