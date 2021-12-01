package processing;

import javax.swing.*;

import gameutil.text.Console;
import graphics.Panel;

import java.util.ArrayList;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args)
    {

        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setTitle("5D Diplomacy With Multiverse Time Travel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p=new Panel(frame);
        Game game = new Game();
        game.displayGraphics(p);
        frame.setVisible(true);
        frame.add(p);
        p.setDoubleBuffered(true);
        p.start();
        

        while (true)
        {
        	game.displayText();
        	game.displayGraphics(p);
            Console.s.println("\nEnter orders:");
            String order = Console.s.readLine();
            ArrayList<String> orders = new ArrayList<>();
            while (!order.equals("r"))
            {
                orders.add(order);
                order = Console.s.readLine();
            }
            ArrayList<Order> parsedOrders = game.parseOrders(orders);
            game.resolveOrders(parsedOrders, false);
            
            game.displayGraphics(p);
            if (game.isRetreatNeeded())
            {
                System.out.println("\nEnter retreats:");
                String retreat = Console.s.readLine();
                ArrayList<String> retreats = new ArrayList<>();
                while (!retreat.equals("r"))
                {
                    retreats.add(retreat);
                    retreat = Console.s.readLine();
                }
                ArrayList<Retreat> parsedRetreats = game.parseRetreats(retreats);
                game.resolveRetreats(parsedRetreats);
                
                
            }
            
        }
    }
}
