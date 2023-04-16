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
    int timeCount=0;
    int hour=1;//20s一个小时：
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);// thread是帧率的的 那么怎么感受一下时间； Thread去维护一个时间函数吧；
                timeCount++;
                if(timeCount%20==0){
                    hour++;
                    if(hour==13){
                        hour=1;// thread维护时间流速;
                    }
                }
                System.out.println("当前的时间是"+hour);
                timelogic();
                logic();//先试用logic改变逻辑：
                showG();
                System.out.println("");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void timelogic() {
        //根据角色心思 周期性改变；20次为一个小时 周期的改变状态;
        for (GameNode tmp:l1){
            //只执行时间相关的策略 即状态的改变：
            if(tmp.getNodeName().equals("农民")){
                if(hour==4){
                    tmp.setState(NodeState.NAVIGATABLE);//4点的时候 让他往农场走; 农民到了目的地应该开始劳作;
                    tmp.setTarx(30);
                    tmp.setTary(30);
                    tmp.setSpeed(1);
                }else if(hour==9){
                    //9点的时候 开始往回走：4
                    tmp.setState(NodeState.NAVIGATABLE);//4点的时候 让他往农场走;
                    tmp.setTarx(0);
                    tmp.setTary(0);
                    tmp.setSpeed(1);
                }
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
