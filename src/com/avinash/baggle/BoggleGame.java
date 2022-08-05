package com.avinash.baggle;

public class BoggleGame {
    private boolean[][] visited;
    private char[][] boogleTable;
    private TernarySearchTree tree;

    public BoggleGame(char[][] boogleTable) {
        this.boogleTable = boogleTable;
        this.tree = new TernarySearchTree();
        this.visited = new boolean[Constant.BOARD_SIZE][Constant.BOARD_SIZE];
    }

    private boolean isValid(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= Constant.BOARD_SIZE) {
            return false;
        }
        if (colIndex < 0 || colIndex >= Constant.BOARD_SIZE) {
            return false;
        }
        if (visited[rowIndex][colIndex]) {
            return false;
        }
        return true;
    }

    public void findWords() {
        for (int i = 0; i < Constant.BOARD_SIZE; i++) {
            for (int j = 0 ; j < Constant.BOARD_SIZE; j++) {
                search(i, j, "" + boogleTable[i][j]);
            }
        }
    }

    private void search(int i, int j, String str) {
        if (tree.get(str)) {
            System.out.println(str);
        }
        if (isValid(i, j)) {
            visited[i][j] = true;
            if (isValid(i - 1, j)) {
                search(i - 1, j , str + boogleTable[i-1][j] );
            }
            if (isValid(i + 1, j)) {
                search(i + 1, j , str + boogleTable[i+1][j] );
            }
            if (isValid(i, j - 1)) {
                search(i, j - 1 , str + boogleTable[i][j-1] );
            }
            if (isValid(i, j + 1)) {
                search(i, j + 1 , str + boogleTable[i][j+1] );
            }
            visited[i][j] = false;
        }
    }

    public static void main(String[] args) {
//        char[][] boggleTable = {
//                {'s', 'u', 's'},
//                {'u', 'c', 'a'},
//                {'b', 't', 'r'}
//        };

        char[][] boggleTable = {
                {'a', 'n', 'i'},
                {'u', 'a', 'm'},
                {'b', 'l', 'r'}
        };

        BoggleGame boggleGame = new BoggleGame(boggleTable);
        boggleGame.tree.insert("car");
        boggleGame.tree.insert("bus");
        boggleGame.tree.insert("animal");
        boggleGame.findWords();

    }
}
