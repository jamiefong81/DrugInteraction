function Schedule() {
    this.myHead = null;
    this.size = 0;
}

function SchedNode(patient, medicationList) {
    this.patient = patient;
    this.medicationList = medicationList;
    this.next = null;
}

Schedule.prototype.insert = function (patient, medicationList) {
    const newNode = new SchedNode(patient, medicationList);

    if (this.myHead === null) {
        newNode.next = null;
        this.myHead = newNode;
    } else {
        let cur = this.myHead;
        let prev = null;

        while (cur !== null && patient.compare(cur.patient)) {
            prev = cur;
            cur = cur.next;
        }

        if (prev === null) {
            newNode.next = this.myHead;
            this.myHead = newNode;
        } else {
            newNode.next = cur;
            prev.next = newNode;
        }
    }

    this.size++;
};

Schedule.prototype.clearSched = function () {
    this.myHead = null;
    this.size = 0;
};

Schedule.prototype.deletePatient = function (first, last) {
    let count = 0;
    let cur = this.myHead;

    first = this.fixName(first);
    last = this.fixName(last);

    for (let i = 0; i < this.size; i++) {
        if (cur.patient.first === first && cur.patient.last === last) {
            if (cur === this.myHead) {
                this.myHead = cur.next;
            } else {
                let prev;
                for (prev = this.myHead; prev.next !== cur; prev = prev.next) {}
                prev.next = cur.next;
            }

            count++;
        }

        cur = cur.next;
    }

    this.size -= count;
    return count;
};

Schedule.prototype.deletePatientByLastName = function (last) {
    let count = 0;
    let cur = this.myHead;

    last = this.fixName(last);

    for (let i = 0; i < this.size; i++) {
        if (cur.patient.last === last) {
            if (cur === this.myHead) {
                this.myHead = cur.next;
            } else {
                let prev;
                for (prev = this.myHead; prev.next !== cur; prev = prev.next) {}
                prev.next = cur.next;
            }

            count++;
        }

        cur = cur.next;
    }

    this.size -= count;
    return count;
};

Schedule.prototype.fixName = function (name) {
    const firstLetter = name.charAt(0).toUpperCase() + name.slice(1).toLowerCase();
    return firstLetter;
};
