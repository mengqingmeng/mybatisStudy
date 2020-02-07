package type;

public enum Enabled {
    enabled(1), //启用
    disabled(0);// 禁用


    private final int value;

    Enabled(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}