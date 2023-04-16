package 马菜.写一个小游戏;

public enum NodeState {

    STAND(0),
    NAVIGATABLE(1),
    SLEEP(2);

    int state;
    private NodeState(int x){
        this.state=x;
    }
    public int getState(){
        return this.state;
    }
}
