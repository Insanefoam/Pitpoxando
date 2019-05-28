public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start on: ");
        System.out.println("1. Server");
        System.out.println("2. Second player");
        System.out.println("3. Test");
        int mode = -1;
        String menuIp = "";
        Menu menu = new Menu();

        while (menu.mode == -1) {
            Thread.sleep(500);
        }
        mode = menu.mode;
        menuIp = menu.ip;
        switch (mode) {
            case 1:
                new PlayerOneThread().start();
                Thread.sleep(200);
                new Server().start();
                break;
            case 2:
                PlayerTwoForLocal playerTwo = new PlayerTwoForLocal();
                playerTwo.ip = menuIp;
                playerTwo.start();
                break;
            case 3:
                new PlayerOneThread().start();
                Thread.sleep(200);
                new PlayerTwoForTest().start();
                new Server().start();
                break;
            default:
                throw new NumberFormatException();
        }

    }
}
