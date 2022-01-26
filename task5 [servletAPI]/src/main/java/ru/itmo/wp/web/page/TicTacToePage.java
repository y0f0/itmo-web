package ru.itmo.wp.web.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class TicTacToePage {
    private void action(HttpServletRequest request, Map<String, Object> view) {
        if (request.getSession().getAttribute("state") == null) {
            newGame(request, view);
        }
        view.put("state", request.getSession().getAttribute("state"));
    }

    private void newGame(HttpServletRequest request, Map<String, Object> view) {
        State state = new State();
        request.getSession().setAttribute("state", state);
        view.put("state", state);
    }

    private void onMove(HttpServletRequest request, Map<String, Object> view) {
        HttpSession session = request.getSession();
        State state = (State) session.getAttribute("state");
        int i = 0, j = 0;
        for (String parameter : request.getParameterMap().keySet()) {
            if (parameter.startsWith("cell_")) {
                i = parameter.charAt(5) - '0';
                j = parameter.charAt(6) - '0';
            }
        }

        state.setCell(i, j);
        view.put("state", state);
        session.setAttribute("state", state);
    }

    public static class State {
        private final int size = 3;
        private final String[][] cells = new String[size][size];
        private String phase = "RUNNING";
        private boolean crossesMove = true;
        private int emptyCells = size * size;

        public int getSize() {
            return size;
        }

        public String[][] getCells() {
            return cells;
        }

        public String getPhase() {
            return phase;
        }

        public boolean isCrossesMove() {
            return crossesMove;
        }

        private String getCell() {
            return crossesMove ? "X" : "O";
        }

        private boolean isOnBoard(int i, int j) {
            return i >= 0 && i < size && j >= 0 && j < size;
        }

        private boolean checkDot(int i, int j) {
            return isOnBoard(i, j) && Objects.equals(cells[i][j], getCell());
        }

        private int checkInOneLine(int startI, int startJ, int stepI, int stepJ) {
            int cnt = 0;
            int x = startI + stepI;
            int y = startJ + stepJ;
            for (int i = 0; i < size; i++) {
                if (!checkDot(x, y)) {
                    break;
                }
                cnt++;
                x += stepI;
                y += stepJ;
            }

            return cnt;
        }

        private boolean checkWin(int startI, int startJ, int dI, int dJ) {
            return checkInOneLine(startI, startJ, dI, dJ) + checkInOneLine(startI, startJ, -dI, -dJ) + 1 >= size;
        }

        public void setCell(int i, int j) {
            if (!phase.equals("RUNNING") || !isOnBoard(i, j) || cells[i][j] != null) {
                return;
            }
            cells[i][j] = getCell();
            emptyCells--;
            if (checkWin(i, j, 1, 0) ||
                checkWin(i, j, 0, 1) ||
                checkWin(i, j, 1, 1) ||
                checkWin(i, j, 1, -1)) {

                phase = "WON_" + getCell();
            }

            if (emptyCells == 0) {
                phase = "DRAW";
            }

            crossesMove = !crossesMove;
        }
    }
}