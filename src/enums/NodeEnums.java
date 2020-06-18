package enums;

public enum  NodeEnums {
    /**
     * 顾客结点
     */
    CUSTOMER(1),
    /**
     *  配送中心
     */
    DEPOT(2);

    private int type;

    NodeEnums(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
