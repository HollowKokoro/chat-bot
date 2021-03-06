import akka.actor.*;
import java.util.Scanner;

public class Main
{
    private static Scanner scanner;
    private static ActorSystem system;
    private static ActorRef bot;

    public static void main(String[] args) {
        system = ActorSystem.create("ClientSystem");
        bot = system.actorOf(Props.create(SimpleBot.class));
        scanner = new Scanner(System.in);

        do {
            System.out.println("BOT: Please, ask your question");
            String question = scanner.nextLine();
            System.out.println("USER: " + question);
            bot.tell(question, ActorRef.noSender());
        } while (!scanner.nextLine().equals("n"));
        System.exit(0);
    }
}
