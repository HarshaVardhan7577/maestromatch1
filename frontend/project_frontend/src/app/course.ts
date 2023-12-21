export class Course {
courseId:number=0;
teacherId:number=0;
courseName: string='';
instrument: string='';
courseDesc: string='';
videoUrl: string='';
constructor(courseId:number,teacherId:number,courseName:string,instrument:string,courseDesc:string,videoUrl:string){
    this.courseId=courseId;
    this.teacherId=teacherId;
    this.instrument=instrument;
    this.courseName=courseName;
    this.courseDesc=courseDesc;
    this.videoUrl=videoUrl;
}

}
