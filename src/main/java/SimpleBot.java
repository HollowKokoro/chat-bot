import akka.actor.*;
import java.util.*;

public class SimpleBot extends UntypedAbstractActor
{
    private static Map<String, String> messages = new TreeMap<>();
    private static String bot = "BOT: ";

    @Override
    public void onReceive(Object message) throws InterruptedException {
        if (message instanceof String) {
            if (messages.containsKey(message)) {
                System.out.println(bot + messages.get(message));
                System.out.println(bot + "Ask next question? (y/n)");
                return;
            }
            System.out.println(bot + "Question accepted, searching knowledge base");
            Thread.sleep(1000);
            System.out.println(bot + "You asked \"" + message + "\" but I don't know, our programmers working on it...");
        }
        System.out.println(bot + "Ask next question? (y/n)");
        unhandled(message);
    }
}
