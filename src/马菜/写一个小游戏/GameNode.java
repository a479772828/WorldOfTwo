package 马菜.写一个小游戏;

public class GameNode {


    int x,y;//表示坐标
    String nodeName;

    NodeState state;//表示状态：


    public GameNode(){

    }
    public GameNode(int x, int y,String name,NodeState nt) {
        this.x=x;
        this.y=y;
        this.nodeName=name;
        this.state=nt;//这是一个状态;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
