package 马菜.写一个小游戏;

public class GameNode {

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public NodeState getState() {
        return state;
    }

    public void setState(NodeState state) {
        this.state = state;
    }

    public int getTarx() {
        return tarx;
    }

    public void setTarx(int tarx) {
        this.tarx = tarx;
    }

    public int getTary() {
        return tary;
    }

    public void setTary(int tary) {
        this.tary = tary;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    int x,y;//表示坐标
    String nodeName;

    NodeState state;//表示状态：

    int tarx,tary,speed;
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
