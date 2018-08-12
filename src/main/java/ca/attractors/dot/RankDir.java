package ca.attractors.dot;

public enum RankDir {
    TOP_TO_BOTTOM("TB"), LEFT_TO_RIGHT("LR"), BOTTOM_TO_TOP("BT"), RIGHT_TO_LEFT("RL"), NULL("");

    private String code;

    RankDir(String aCode) {
        code = aCode;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return getCode();
    }

    public String toDotString() {
        if (this == NULL)
            return "";
        return "rankDir=" + getCode() + "\n";
    }

}