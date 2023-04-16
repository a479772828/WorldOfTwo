package 马菜.写一个小游戏;

import java.util.List;

public class GameEngineThread extends  Thread {

    char g[][];
    List<GameNode> l1;
    public GameEngineThread(char g[][],List<GameNode> nodes ){
    //希望执行的任务就是每秒
        //把所有的list填入到g里面，然后 打印出来
      this.g=g;
      this.l1=nodes;

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
                logic();//先试用logic改变逻辑：
                showG();
                System.out.println("");
                System.out.println("");
                System.out.println("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void logic() {
        for (GameNode gameNode : l1) {
            gameNode.
        }
    }

    private void showG(){
        int row=g.length;
        int col=g[0].length;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                g[i][j]=' ';
            }
            System.out.println("");
        }
        for(GameNode tmp:l1){
            g[tmp.x][tmp.y]='x';
        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                if(g[i][j]!='x') System.out.print('-');
                else System.out.print('x');
            }
            System.out.println("");
        }

    }

}
