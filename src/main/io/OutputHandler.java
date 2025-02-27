package io;

public class OutputHandler {

    static final String SEPARATOR = "======================================\n";

    public void printCalcResult(String msg) {
        System.out.println("***********************");
        System.out.println("연산 결과: " + msg);
        System.out.println("***********************");
    }

    public void printCustomMsg(String tag, String msg) {
        System.out.printf("[%s] %s\n", tag, msg);
    }

    public void printError(String msg) {
        System.out.println("[ERROR] " + msg);
    }

    public void printSeparator() {
        System.out.println(SEPARATOR);
    }

}
