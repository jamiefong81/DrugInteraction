public class Schedule {
    public class SchedNode{
        public Patient patient;

        public MedicationList mL;

        public SchedNode next;
    }

    private SchedNode myHead;

    private int size;

    public Schedule(){
        myHead = null;
        size = 0;
    }

    public void insert(Patient patient, MedicationList mL){
        SchedNode tmp = new SchedNode();
        tmp.patient = patient;
        tmp.mL = mL;

        if(myHead == null){
            tmp.next = null;
            myHead = tmp;
            size++;
            return;
        }

        SchedNode cur = myHead;
        SchedNode prev = null;

        while(cur != null && tmp.patient.compare(cur.patient)){
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

    public void clearSched(){
        myHead = null;
        size = 0;
    }

    private String fixName(String name){
        String firstLet = name.substring(0,1);
        String rest = name.substring(1).toLowerCase();

        name = firstLet.toUpperCase() + rest;
        return name;
    }

    public int deletePatient(String first, String last){
        int count = 0;
        SchedNode cur = myHead;

        first = fixName(first);
        last = fixName(last);

        for(int i = 0; i < size; i++){
            if(cur.patient.first.equals(first) && cur.patient.last.equals(last)){
                if(cur == myHead){
                    myHead = cur.next;
                }
                else{
                    SchedNode prev;
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

    public int deletePatient(String last){
        int count = 0;
        SchedNode cur = myHead;

        last = fixName(last);

        for(int i = 0; i < size; i++){
            if(cur.patient.last.equals(last)){
                if(cur == myHead){
                    myHead = cur.next;
                }
                else{
                    SchedNode prev;
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


}
