public class Main {
    public static void main(String[] args) {
        Patient p = new Patient("kevin", "chen", "l", 180, 70, 18, "9084006586", 8, 5, 2005, "892 Block Way", "nashville", "tennessee", "United States", "07090", "male", "cancer", 120);
        System.out.println(p.toStringName());
        System.out.println(p.toStringAddress());
        System.out.println(p.getMid());
        System.out.println(p.toStringBday());
        System.out.println(p.toStringPhone());
        System.out.println(p.age);
        p.changeAge(20);
        System.out.println(p.age);
        p.updateLoc("890 Block Ave", "Houston", "Texas","United States", "07080");
        System.out.println(p.toStringAddress());

        MedicationList mL1 = new MedicationList();
        mL1.insert("Tylenol", 60);
        mL1.insert("Tylenol", 781);
        mL1.insert("Zyrtec", 430);
        mL1.insert("Rylenol", 270);
        mL1.deleteMed("Tylenol", 270);


        System.out.println(mL1.toString());
        System.out.println(mL1.getSize());
    }
}