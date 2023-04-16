package 马菜.写一个小游戏;

import java.util.ArrayList;
import java.util.List;

public class GameMain {

    char g[][]=new char[50][100];

    List<GameNode> l1=new ArrayList<>();
    public static void main(String[] args) {

        GameMain gameMain = new GameMain();

        gameMain.l1.add(new GameNode(12,12,"农民",NodeState.STAND));
        gameMain.l1.add(new GameNode(40,50,"农民2",NodeState.STAND));
        gameMain.l1.get(0).setState(NodeState.NAVIGATABLE);
        gameMain.l1.get(0).setTarx(30);
        gameMain.l1.get(0).setTary(30);
        gameMain.l1.get(0).setSpeed(1);
        new GameEngineThread(gameMain.g,gameMain.l1).start();

        //首先定义一个数组， 每秒打印数组里面的内容
    }
}
