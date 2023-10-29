class MedicationList {
  constructor() {
    this.myHead = null;
    this.size = 0;
  }

  insert(med, time) {
    med = this.fixMedication(med);
    time = this.fixTime(time);

    const newNode = {
      medName: med,
      time: time,
      next: null,
    };

    if (this.myHead === null) {
      this.myHead = newNode;
    } else {
      let cur = this.myHead;
      let prev = null;

      while (
        cur !== null &&
        newNode.medName.localeCompare(cur.medName) >= 0 &&
        newNode.time >= cur.time
      ) {
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
  }

  clearMed() {
    this.myHead = null;
    this.size = 0;
  }

  fixMedication(med) {
    const firstLetter = med.charAt(0).toUpperCase() + med.slice(1).toLowerCase();
    return firstLetter;
  }

  fixTime(time) {
    if (time >= 1440) {
      time = time % 1440;
    }

    return time;
  }

  deleteMed(med, time) {
    let count = 0;
    let cur = this.myHead;

    med = this.fixMedication(med);
    time = this.fixTime(time);

    while (cur !== null) {
      if (cur.medName === med && cur.time === time) {
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
  }

  deleteMedByName(med) {
    let count = 0;
    let cur = this.myHead;

    while (cur !== null) {
      if (cur.medName === med) {
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
  }

  getSize() {
    return this.size;
  }

  toString() {
    let output = "";
    let cur = this.myHead;
    for (let i = 1; i <= this.size; i++) {
      // Format and append to the output string as needed
      // ...

      cur = cur.next;
    }

    return output;
  }
}
