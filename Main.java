public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long[] results1 = new long[52];
        long[] results2 = new long[52];
        long times = 15000000000L;
        for(long i = 0; i < times; i++) {
            results1[claimPack()-1]++;
            results2[claimReset()-1]++;
            if(i % 1000000 == 0) {
                long currentTime = System.nanoTime();
                long totalTime= currentTime - startTime;
                System.out.println(i + " : " + totalTime/1000000000 + "s");
            }
        }
        System.out.println("Per pack number generation:");
        for(int i = 0; i < results1.length; i++) {
            System.out.println((i+1) + ": " + results1[i]);
        }
        System.out.println("==============");
        System.out.println("Per odds reset number generation:");
        for(int i = 0; i < results2.length; i++) {
            System.out.println((i+1) + ": " + results2[i]);
        }
        long endTime= System.nanoTime();
        long totalTime= endTime - startTime;
        System.out.println(totalTime/1000000000 + "s");
    }

    public static int claimPack() {
        double[] chances = {2,5,10,20,40,60,100};
        int sum = 0;
        int claims = 45;
        for(int i = 0; i < claims; i++) {
            int lim = 7;
            if((claims-i) < 7) {
                lim = claims - i;
            }
            for (int j = 0; j < lim; j++) {
                int ran = (int) (Math.random() * 99) + 1;
                if (ran <= chances[j]) {
                    sum++;
                    i += j;
                    break;
                }
            }
        }
        return sum+7;
    }

    public static int claimReset() {
        double[] chances = {2,5,10,20,40,60,100};
        int sum = 0;
        int claims = 45;
        for(int i = 0; i < claims; i++) {
            int ran = (int) (Math.random() * 99) + 1;
            int lim = 7;
            if((claims-i) < 7) {
                lim = claims - i;
            }
            for (int j = 0; j < lim; j++) {
                if (ran <= chances[j]) {
                    sum++;
                    i += j;
                    break;
                }
            }
        }
        return sum+7;
    }

}
