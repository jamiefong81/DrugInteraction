public class Patient {

    public String first;
    public String last;
    public String mid;
    public String gender;

    public double weight;
    public double height;
    public int age;

    public String PhoneNum;

    public int bDay;
    public int bMonth;
    public int bYear;

    public String address;
    public String city;
    public String state;
    public String country;
    public String zip;

    public String condition;

    public int roomNum;

    public Patient(String first, String last, String mid, double weight, double height, int age, String PhoneNum, int bDay, int bMonth, int bYear, String address, String city, String state, String country, String zip, String gender, String condition, int roomNum){
        this.first = first;
        this.last = last;
        this.mid = mid;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.PhoneNum = PhoneNum;
        this.bDay = bDay;
        this.bMonth = bMonth;
        this.bYear = bYear;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.gender = gender;
        this.condition = condition;
        this.roomNum = roomNum;

        fixFirst();
        fixLast();
        fixCity();
        fixState();
        fixCondition();
    }

    private void fixFirst(){
        String firstLet = first.substring(0,1);
        String rest = first.substring(1).toLowerCase();

        first = firstLet.toUpperCase() + rest;
    }

    private void fixLast(){
        String firstLet = last.substring(0,1);
        String rest = last.substring(1).toLowerCase();

        last = firstLet.toUpperCase() + rest;
    }

    private void fixCity(){
        String firstLet = city.substring(0,1);
        String rest = city.substring(1).toLowerCase();

        city = firstLet.toUpperCase() + rest;
    }

    private void fixState(){
        String firstLet = state.substring(0,1);
        String rest = state.substring(1).toLowerCase();

        state = firstLet.toUpperCase() + rest;
    }

    private void fixCondition(){
        String firstLet = condition.substring(0,1);
        String rest = condition.substring(1).toLowerCase();

        condition = firstLet.toUpperCase() + rest;
    }

    public void changeAge(int age){
        this.age = age;
    }

    public void updatePhoneNum(String num){
        PhoneNum = num;
    }

    public void updateLoc(String add, String city, String state, String country, String zip){
        address = add;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;

        fixCity();
        fixState();
    }


    public String getFirst(){
        return first;
    }

    public String getLast(){
        return last;
    }

    public String getMid(){
        return mid.toUpperCase();
    }

    public int getAge(){
        return age;
    }

    public String getState(){
        return state;
    }

    public String getCity(){
        return city;
    }

    public String toStringName(){
        return "Name: " + first + " " + mid.toUpperCase() + " " + last;
    }

    public String toStringAddress(){
        return address + "\n" + city + ", " + state + ", " + zip + "\n" + country;
    }

    public String toStringBday(){
        return bMonth + "/" + bDay + "/" + bYear;
    }

    public String toStringPhone(){
        return "(" + PhoneNum.substring(0,3) + ") " + PhoneNum.substring(3, 6) + "-" + PhoneNum.substring(6);
    }


    /**
     * Used to compare two Patients and their place in a list if there was one.
     * First, it compares last names, seeing which one should be first alphabetically.
     * Second, it compares first names, then middle initial.
     * If all those are the same, compares age: the older person is put behind the younger person.
     * This is determined by month and day if ages are the same int.
     * @param other
     * @return true if the patient should be behind the other patient in an order. False for vice-versa.
     */
    public boolean compare(Patient other){
        if(last.compareTo(other.last) > 0){
            return true;
        }

        if(last.compareTo(other.last) < 0){
            return false;
        }

        if(first.compareTo(other.first) > 0){
            return true;
        }

        if(first.compareTo(other.first) < 0){
            return false;
        }

        if(getMid().compareTo(other.getMid()) > 0){
            return true;
        }

        if(getMid().compareTo(other.getMid()) < 0){
            return false;
        }

        if(age > other.age){
            return true;
        }

        if(age < other.age){
            return false;
        }

        if(bMonth < other.bMonth){
            return true;
        }

        if(bMonth > other.bMonth){
            return false;
        }

        if(bDay < other.bDay){
            return true;
        }

        if(bDay > other.bDay){
            return false;
        }

        return true;
    }


}
