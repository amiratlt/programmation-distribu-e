import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Router } from '@angular/router';
import { EmployeeService } from '../services/employee.service';
import { Departementt } from '../departementt';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  submitted = false;
  departements!:Departementt[]
  constructor(private employeeService: EmployeeService, private router: Router){}

  selectedDepart:number;
//event handler for the select element's change event
selectChangeHandler (event: any) {
  //update the ui
  this.selectedDepart= event.target.value;
}



  ngOnInit(){
    this.reloadData();
  } 
  reloadData(){
      this.employeeService.getDepList().subscribe(
      data=>{
      console.log(data);
      this.departements=data;
      },
        err=>{
        console.log(err);
      });
  }
 
  newEmployee():void{
    this.submitted = false;
    this.employee = new Employee();
  }
  save(){
    this.employeeService.saveEmployee(this.employee).subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    
    this.employee = new Employee();
    //this.gotoList();
  }
 

  onSubmit(){
    this.submitted = true;


    //this.d=this.employeeService.getDep(this.iddep).subscribe(val => console.log(val),
    //error=> console.log("error"),
    //);
    
    this.save();
  }
  gotoList(){
    this.router.navigate(['/employees']);
  }}