import java.util.ArrayList;
import java.util.Random;

public class Arl {
    static class Data{
        int id;
        String name;
        boolean available;

        public Data(int id, String name, boolean available) {
            this.id = id;
            this.name = name;
            this.available = available;
        }


        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", available=" + available +
                    '}';
        }

    }
    public static void dataSearch(ArrayList<Data> arl, Data data){
        boolean found = false;
        if (arl.size() < data.id){
            System.out.println("ID does not exist");
        }

        for (Data i:arl){
            if (i.name.equals(data.name)){
                System.out.println("Found name: " + i);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("It does not exist");
        }
    }

    public static void dataDelete(ArrayList<Data> arl, Data data){
        Data temp = null;
        boolean found = false;
        for (Data i: arl){
            if (i.id == data.id) {
                temp = i;
                found = true;
                break;
            }
        }
        if (found){
            arl.remove(temp);
            System.out.println("Data removed: " + temp);
        }
        else {
            System.out.println("Data does not exist");
        }
    }
    public static void main(String[] args){
        long totalstartime = System.nanoTime();
        Runtime rt = Runtime.getRuntime();

        long startime = System.nanoTime();
        ArrayList<Data> arl = new ArrayList<>();
        int numData = 1000000;
        Data data;
        for (int i = 0; i < numData; i++){
            Random random = new Random();
            int avail = random.nextInt(2);
            if (avail == 1){
                data = new Data(i,"item " + i,true);
            }else {
                data = new Data(i,"item " + i,false);
            }
            arl.add(data);
        }
        System.out.println("********************************");
        long endtime = System.nanoTime();
        long addingtime = endtime - startime;
        System.out.println("Adding time: " + addingtime );

        System.out.println("********************************");
        startime = System.nanoTime();
        System.out.println(arl);
        endtime = System.nanoTime();
        long printingtime = endtime - startime;
        System.out.println("Printing time: " + printingtime );
        System.out.println("********************************");


        startime = System.nanoTime();
        dataSearch(arl,new Data(110001,"item 77",false));
        endtime = System.nanoTime();
        long searchingtime = endtime - startime;
        System.out.println("Searching time: " + searchingtime);
        System.out.println("********************************");

        startime = System.nanoTime();
        dataDelete(arl, new Data(550000,"item 77",false));
        endtime = System.nanoTime();
        long deletetime = endtime - startime;
        System.out.println("Deleting time: " + deletetime);
        System.out.println("********************************");

        startime = System.nanoTime();
        arl.set(450000, new Data(705,"item 77",false));
        endtime = System.nanoTime();
        long insertiontime = endtime - startime;
        System.out.println("Insertion time: " + insertiontime);


        System.out.println("********************************");
        long totalMem = rt.totalMemory();
        long freeMem = rt.freeMemory();
        long usedMem = totalMem - freeMem;
        System.out.println("Used memory: " + usedMem + " bytes");

        System.out.println("********************************");
        endtime = System.nanoTime();
        long runtime = endtime - totalstartime;
        System.out.println("Runtime: " + runtime);
        System.out.println("********************************");
    }
}

