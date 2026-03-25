import java.time.Instant;

public class Main {

    public static Instant getServerTime() {return Instant.now();}

    public static void main (String[]args){

        try {

            long t0 = System.currentTimeMillis();

            Instant serverTime = getServerTime();

            Thread.sleep(100);

            long t1 = System.currentTimeMillis();

            long rtt = t1 - t0;

            long adjustedTime = serverTime.toEpochMilli() + (rtt / 2);

            System.out.println("Tempo do servidor: " + serverTime);
            System.out.println("RTT: " + rtt + " ms");
            System.out.println("Tempo ajustado do cliente: " + Instant.ofEpochMilli(adjustedTime));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("A execucao foi interrompida.");
        }
    }
}