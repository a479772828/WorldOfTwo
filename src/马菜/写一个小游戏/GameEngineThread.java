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
                Thread.sleep(1000);
                logic();//先试用logic改变逻辑：
                showG();
                System.out.println("");
                System.out.println("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void logic() {
        for (GameNode gameNode : l1) {
                switch (gameNode.state){
                    case STAND:
                        break;
                    case SLEEP:
                        break;
                    case NAVIGATABLE:
                        doMoveNavigatable(gameNode);
                }
        }
    }

    private void doMoveNavigatable(GameNode gameNode) {
        //按照导航方向行走
        //首先在x方向上靠近，然后在y方向上靠近；
        int tarx=gameNode.getTarx();
        int tary=gameNode.getTary();
        int x=gameNode.getX();
        int y=gameNode.getY();
        if(x!=tarx){
            int dir=tarx-x;
            if(dir>0){
                x+=gameNode.speed;
            }else{
                x-=gameNode.speed;
            }
        }else if(y!=tary){
            int dir=tary-y;
            if(dir>0){
                y+=gameNode.speed;
            }else{
                y-=gameNode.speed;
            }
        }else{
            gameNode.setState(NodeState.STAND);//到了就不用动了
        }
        gameNode.setX(x);
        gameNode.setY(y);

    }

    private void doMove(GameNode gameNode) {
        //不按照导航的方向行走：
        int speed=gameNode.speed;
        speed=1;//先写死;
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
