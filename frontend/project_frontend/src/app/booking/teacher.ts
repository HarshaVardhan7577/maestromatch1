export class Teacher {
    id:number=0;
    userId:number=0;
	firstName: String="";
	lastName: String ="";
	location: String ="";
	instrument: String="" ;
	experience: String="" ;
	description: String="" ;

    constructor(){
        this.description="";
        this.experience="";
        this.firstName="";
        this.id=0;
        this.userId=0;
        this.instrument="";
        this.lastName="";
        this.location="";
    }
}
