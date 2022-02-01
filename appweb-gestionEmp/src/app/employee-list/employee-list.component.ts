import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../employee';
import { Departementt } from '../departementt';

import { Router } from '@angular/router';
import{Observable}from'rxjs';
@Component({
selector: 'app-employee-list',
templateUrl: './employee-list.component.html',
styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{
    champ:'';
    employees: Employee[];
    champ2:number;
    cherche=false;
    cherche2=false;
    submitted=false;

constructor(private employeeService: EmployeeService,private router: Router){}
ngOnInit(){
this.reloadData();
}
reloadData(){
    this.employeeService.getEmployeesList().subscribe(
    data=>{
    console.log(data);
    this.employees=data;
    },
        err=>{
        console.log(err);
        });
}

deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(
    data=>{console.log(data); this.reloadData(); },
    error=>console.log(error));
}
employeeUpdate(id:number){
    this.router.navigate(['update',id]);
}

getEmployee(id:number){
    this.router.navigate(['details',id]);
}
gotoList(){
    this.router.navigate(['/employees']);
  }

chercherEmploye(champ:string){
    this.employeeService.chercherEmployee(champ).subscribe(
      data=>{
      console.log(data);
      this.employees=data;
      },
          err=>{
          console.log(err);
          });
  }

  chercherEmployeContains(champ:string){
      
    this.employeeService.chercherEmployeeContains(champ).subscribe(
      data=>{
      console.log(data);
      this.employees=data;
      },
          err=>{
          console.log(err);
          });
  }

  chercherParIdDepart(motcle:number){
    this.employeeService.EmpParIdDept(motcle).subscribe(
        data=>{
        console.log(data);
        this.employees=data;
        },
            err=>{
            console.log(err);
            });

  }


  chercherParNomDepart(motcle:number){
    this.employeeService.EmpParNomDept(motcle.toString()).subscribe(
        data=>{
        console.log(data);
        this.employees=data;
        },
            err=>{
            console.log(err);
            });

  }

  

}