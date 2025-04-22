package ru.job4j.oop;

public class Error {
    public boolean active;
    public int status;
    public String message;

    private Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showError() {
        System.out.print(this.active);
        System.out.print(this.status);
        System.out.print(this.message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 502, "Request rejected");
        Error error3 = new Error(false, 200, "Ok");

        error1.showError();
        error2.showError();
        error3.showError();
    }
}
