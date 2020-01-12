package type;

public enum Enabled {
    enable(1), //启用
    disable(0);// 禁用

    private final int value;

    Enabled(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
