import org.junit.Assert;
import org.junit.Test;

public class GameTests {
    @Test
    public void winCheckerTest() {
        try {
            Server server = new Server(true);
            int[] board1 = {1, 1, 1, -1, -1, -1, -1, -1, -1};
            Assert.assertEquals(server.checkForWin(board1), 1);

            int[] board2 = {1, 1, -1, -1, -1, -1, -1, -1, -1};
            Assert.assertEquals(server.checkForWin(board2), -1);

            int[] board3 = {1, 1, 2, -1, -1, 2, -1, -1, 2};
            Assert.assertEquals(server.checkForWin(board3), 2);
        } catch (Exception e) {

        }
    }

    @Test
    public void winCheckerForNull() {
        try {
            Server server = new Server(true);
            int[] board1 = {};
            server.checkForWin(board1);
            int[] board2 = null;
            server.checkForWin(board2);
            Assert.fail();
        } catch (Exception e) {

        }
    }
}
