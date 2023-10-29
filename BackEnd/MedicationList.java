public class MedicationList {
    public class Node{
        public String medName;

        public int time;

        public Node next;

    }

    private Node myHead;

    private int size;

    public MedicationList(){
        myHead = null;
        size = 0;
    }

    public void insert(String med, int time){

        med = fixMedication(med);
        time = fixTime(time);

        Node tmp = new Node();
        tmp.medName = med;
        tmp.time = time;

        if(myHead == null){
            tmp.next = null;
            myHead = tmp;
            size++;
            return;
        }
        Node cur = myHead;
        Node prev = null;

        while(cur != null && tmp.medName.compareTo(cur.medName) >= 0 && tmp.time >= cur.time){
            prev = cur;
            cur = cur.next;
        }

        if(prev == null){
            tmp.next = myHead;
            myHead = tmp;
            size++;
            return;
        }

        tmp.next = cur;
        prev.next = tmp;

        size++;
    }

    public void clearMed(){
        myHead = null;
        size = 0;
    }

    private String fixMedication(String med){
        String firstLet = med.substring(0,1);
        String rest = med.substring(1).toLowerCase();

        med = firstLet.toUpperCase() + rest;
        return med;
    }

    private int fixTime(int time){
        if(time >= 1440){
            time = time % 1440;
        }

        return time;
    }

    public int deleteMed(String med, int time){
        int count = 0;
        Node cur = myHead;

        med = fixMedication(med);
        time = fixTime(time);

        for (int i = 0; i < size; i++){
            if(cur.medName.equals(med) && cur.time == time){
                if(cur == myHead){
                    myHead = cur.next;
                }

                else{
                    Node prev;
                    for(prev = myHead; prev.next != cur; prev = prev.next){
                    }
                    prev.next = cur.next;
                }

                count++;
            }
            cur = cur.next;
        }

        size -= count;
        return count;
    }

    public int deleteMed(String med){
        int count = 0;
        Node cur = myHead;

        for (int i = 0; i < size; i++){
            if(cur.medName.equals(med)){
                if(cur == myHead){
                    myHead = cur.next;
                }

                else{
                    Node prev;
                    for(prev = myHead; prev.next != cur; prev = prev.next){
                    }
                    prev.next = cur.next;
                }

                count++;
            }
            cur = cur.next;
        }

        size -= count;
        return count;
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        String output = "";
        Node cur = myHead;
        for(int i = 1; i <= size; i++){

            if(cur.time > 720){
                cur.time -= 720;
                if(cur.time % 60 == 0){
                    output = output + "Medication: " + cur.medName + "\t Time: " + cur.time/60 + ":00 pm\n";
                }

                else{
                    int hours = cur.time / 60;
                    int minutes = cur.time % 60;
                    if(minutes < 10){
                        output = output + "Medication: " + cur.medName + "\t Time: " + hours + ":0" + minutes + " pm\n";
                    }
                    else{
                        output = output + "Medication: " + cur.medName + "\t Time: " + hours + ":" + minutes + " pm\n";
                    }
                }
            }

            else if(cur.time == 0){
                output = output + "Medication: " + cur.medName + "\t Time: 12:00am\n";
            }

            else if(cur.time == 720){
                output = output + "Medication: " + cur.medName + "\t Time: 12:00pm\n";
            }

            else{
                if(cur.time % 60 == 0){
                    output = output + "Medication: " + cur.medName + "\t Time: " + cur.time/60 + ":00 am\n";
                }

                else{
                    int hours = cur.time / 60;
                    int minutes = cur.time % 60;
                    if(minutes < 10){
                        output = output + "Medication: " + cur.medName + "\t Time: " + hours + ":0" + minutes + " am\n";
                    }

                    else{
                        output = output + "Medication: " + cur.medName + "\t Time: " + hours + ":" + minutes + " pm\n";
                    }
                }

            }

            cur = cur.next;
        }

        return output;
    }


}
