package org.gmlpiton.week6.testing;

public class ExpressionResult {
    private int value;
    private String um;

    public ExpressionResult() {
    }
    public ExpressionResult(int value, String um) {
        this.value = value;
        this.um = um;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    @Override
    public String toString() {
        return "ExpressionResult{" +
                "value=" + value +
                ", um='" + um + '\'' +
                '}';
    }
}
