function Patient(first, last, mid, weight, height, age, phoneNum, bDay, bMonth, bYear, address, city, state, country, zip, gender, condition, roomNum) {
    this.first = first;
    this.last = last;
    this.mid = mid;
    this.weight = weight;
    this.height = height;
    this.age = age;
    this.phoneNum = phoneNum;
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

    this.fixFirst();
    this.fixLast();
    this.fixCity();
    this.fixState();
    this.fixCondition();
}

Patient.prototype.fixFirst = function () {
    this.first = this.first.charAt(0).toUpperCase() + this.first.slice(1).toLowerCase();
};

Patient.prototype.fixLast = function () {
    this.last = this.last.charAt(0).toUpperCase() + this.last.slice(1).toLowerCase();
};

Patient.prototype.fixCity = function () {
    this.city = this.city.charAt(0).toUpperCase() + this.city.slice(1).toLowerCase();
};

Patient.prototype.fixState = function () {
    this.state = this.state.charAt(0).toUpperCase() + this.state.slice(1).toLowerCase();
};

Patient.prototype.fixCondition = function () {
    this.condition = this.condition.charAt(0).toUpperCase() + this.condition.slice(1).toLowerCase();
};

Patient.prototype.changeAge = function (age) {
    this.age = age;
};

Patient.prototype.updatePhoneNum = function (num) {
    this.phoneNum = num;
};

Patient.prototype.updateLoc = function (add, city, state, country, zip) {
    this.address = add;
    this.city = city;
    this.state = state;
    this.country = country;
    this.zip = zip;
    this.fixCity();
    this.fixState();
};

Patient.prototype.getFirst = function () {
    return this.first;
};

Patient.prototype.getLast = function () {
    return this.last;
};

Patient.prototype.getMid = function () {
    return this.mid.toUpperCase();
};

Patient.prototype.getAge = function () {
    return this.age;
};

Patient.prototype.getState = function () {
    return this.state;
};

Patient.prototype.getCity = function () {
    return this.city;
};

Patient.prototype.toStringName = function () {
    return "Name: " + this.first + " " + this.getMid() + " " + this.last;
};

Patient.prototype.toStringAddress = function () {
    return this.address + "\n" + this.city + ", " + this.state + ", " + this.zip + "\n" + this.country;
};

Patient.prototype.toStringBday = function () {
    return this.bMonth + "/" + this.bDay + "/" + this.bYear;
};

Patient.prototype.toStringPhone = function () {
    return "(" + this.phoneNum.substring(0, 3) + ") " + this.phoneNum.substring(3, 6) + "-" + this.phoneNum.substring(6);
};

Patient.prototype.compare = function (other) {
    if (this.last.localeCompare(other.last) > 0) {
        return true;
    } else if (this.last.localeCompare(other.last) < 0) {
        return false;
    }

    if (this.first.localeCompare(other.first) > 0) {
        return true;
    } else if (this.first.localeCompare(other.first) < 0) {
        return false;
    }

    if (this.getMid().localeCompare(other.getMid()) > 0) {
        return true;
    } else if (this.getMid().localeCompare(other.getMid()) < 0) {
        return false;
    }

    if (this.age > other.age) {
        return true;
    } else if (this.age < other.age) {
        return false;
    }

    if (this.bMonth < other.bMonth) {
        return true;
    } else if (this.bMonth > other.bMonth) {
        return false;
    }

    if (this.bDay < other.bDay) {
        return true;
    } else if (this.bDay > other.bDay) {
        return false;
    }

    return true;
};
