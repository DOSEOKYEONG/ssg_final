package com.ll.exam;

import java.util.Scanner;

public class App {
    private static String mode = "prod";

    public static String getMode() {
        return mode;
    }

    public static void setMode(String mode) {
        App.mode = mode;
    }

    public static String getDataBaseDir(){
        return mode + "_data";
    }
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;

    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        FamousSayingController famousSayingController = new FamousSayingController(sc);

        outer:
        while (true) {

            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    famousSayingController.write(rq);
                    break;
                case "삭제":
                    famousSayingController.remove(rq);
                    break;
                case "목록":
                    famousSayingController.listing(rq);
                    break;
                case "수정":
                    famousSayingController.update(rq);
                    break;
                case "빌드":
                    famousSayingController.build(rq);
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }

}