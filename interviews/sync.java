import java.util.regex.*;
import java.util.*; 
import java.util.stream.*; 
import java.util.concurrent.*;

public class sync extends Thread
{
    public record order(Boolean side, String prov, int count, int price) {};


    static private ArrayList<order> orderbook = new ArrayList<order>(); 
    // По-нормальному нужно какую-нибудь synchronizedCollection сразу, но это тестовое задание, поэтому обходимся небезопасной коллекцией. А то одну коллекцию добавил, и больше нигде не надо synchronized писать)

    public void generateRecord() {
        // Никаких проблем с одинаковым рандомом!
        ThreadLocalRandom r = ThreadLocalRandom.current();
        int provider = r.nextInt(3);
        String prov;
        switch(provider) {
            case 0:
                prov = "SBER";
                break;
            case 1:
                prov = "GMKN";
                break;
            case 2: 
                prov = "GAZP";
                break;
            default:
                prov = "GMKN";
        }
        int price;
        switch(provider) {
            case 0:
                price = 270 + r.nextInt(30) + 1;
                break;
            case 1:
                price = 17000 + r.nextInt(500) + 1; 
                break;
            case 2: 
                price = 150 + r.nextInt(30) + 1; 
                break;
           default:
                price = 0;
        }
        int count = r.nextInt(100) + 1;
        Boolean sellOrBuy = r.nextBoolean();
        order o = new order(sellOrBuy, prov, count, price);
        System.out.println(String.format("T: %s   %s %s %d@%d" , Thread.currentThread().getName(), o.side ? "SELL" : "BUY", o.prov, o.count, o.price));
        addRecord(o);
    }

    public void addRecord(order rec)
    {
        synchronized (orderbook) {
        orderbook.add(rec);
        }
        return;
    }

    public static void printRecords() {
        ArrayList<order> copy = new ArrayList<order>();
        synchronized (orderbook) {
            for (order o : orderbook) {
                copy.add(new order(o.side, o.prov, o.count, o.price));
            }
            // Так я должен скопировать String и Boolean, а не ссылки на них и точно не будет проблем с потоками
            // Сортировки скорее всего долгие, поэтому вначале копируем, потом сортируем свою копию
        }
//        Comparator<order> comp = Comparator.comparing(order::price, Comparator.reverseOrder());
        System.out.println("  BUY  SBER  SELL");
        System.out.println("-----------------");
        printTable(copy, "SBER", 270, 300);
        System.out.println();
        System.out.println("  BUY  GMKN  SELL");
        System.out.println("-----------------");
        printTable(copy, "GMKN", 17000, 17500);
        System.out.println();
        System.out.println("  BUY  GAZP  SELL");
        System.out.println("-----------------");
        printTable(copy, "GAZP", 150, 180);
        System.out.println();
    }
    public static void printTable(ArrayList<order> ord, String provider, int rangeBot, int rangeTop) {
        // У нас есть незалоченная копия, можно веселиться
        Map<Integer, Map<Boolean, Integer>> mappy = 
        ord.stream()
            .filter(o -> o.prov == provider)
            .collect(Collectors.groupingBy(order::price, Collectors.groupingBy(order::side, Collectors.summingInt(order::count))));   
        for (int i = rangeTop; i >= rangeBot; i--) {
            if (mappy.containsKey(i)) {
                int buy = 0;
                int sell = 0;
                if (mappy.get(i).containsKey(false))
                    buy = mappy.get(i).get(false);
                if (mappy.get(i).containsKey(true))
                    sell = mappy.get(i).get(true);
                System.out.println(String.format("%5d %5d %5d", buy, i, sell));
            }
        }
        // 560 запросов каждое нажатие, но так проще написать красивое SELL справа и BUY слева, как в задании. Всё равно потокам ждать не надо, у нас копия.
    }


    public void run ()
    {
        while (true) {
            generateRecord();
            ThreadLocalRandom r = ThreadLocalRandom.current();
            try {
                Thread.sleep(r.nextInt(9000) + 1001);
            }
            catch (Exception e) {
                System.out.println("Sleep failure in thread " + Thread.currentThread().getName());
            }
        }
    }

    public static void main (String[]args)
    {
        Thread tlist[] = new Thread[5];
        for (int i = 0; i<5; i++) {
         Thread th = new sync();
         th.setName(Integer.toString(i));
         tlist[i] = th;
         th.start();
        }
        Scanner scannner = new Scanner(System.in);
        try {
            while (true) {
                scannner.nextLine();
                printRecords();
            }
        }
        catch (Exception e) {
         System.out.println("Scanner failure!");
         return;
        }
    }
}
