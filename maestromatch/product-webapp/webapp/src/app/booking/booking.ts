// booking.model.ts

export class Booking {
    bookingId: number;
    teacherId: number;
    studentId: number;
    date: string; // You can use a Date type if the date is stored as a Date object
    time: string;
    status: string;
    teacherName: string; // Add this property to store teacher's name
    studentName: string; // Add this property to store student's name
  
    constructor(
      bookingId: number,
      teacherId: number,
      studentId: number,
      date: string,
      time: string,
      status: string,
      teacherName: string,
      studentName: string
    ) {
      this.bookingId = bookingId;
      this.teacherId = teacherId;
      this.studentId = studentId;
      this.date = date;
      this.time = time;
      this.status = status;
      this.teacherName = teacherName;
      this.studentName = studentName;
    }
  }