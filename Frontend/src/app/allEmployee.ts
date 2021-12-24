
export class AllEmployees {
    empId!:number;
	emp_name!:string;
	emp_designation!:number;
	emp_doj!:Date;
    emp_mobile!:string;
	emp_email!:string;

constructor(empId:number,
	emp_name:string,
	emp_designation:number,
	emp_doj:Date,
    emp_mobile:string,
	emp_email:string){

    this.empId=empId,
	this.emp_name=emp_name,
	this.emp_designation=emp_designation,
	this.emp_doj=emp_doj,
    this.emp_mobile=emp_mobile,
	this.emp_email=emp_email
}

}