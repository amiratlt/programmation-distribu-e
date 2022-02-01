import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../services/employee.service';
import { Observable } from 'rxjs';

import { Router } from '@angular/router';
@Component({
  selector: 'app-chercher-employee',
  templateUrl: './chercher-employee.component.html',
  styleUrls: ['./chercher-employee.component.css']
})
export class ChercherEmployeeComponent implements OnInit {
  motcle:string;
  cherche=false;
  champ:'';

  employees: Employee[];
  constructor(private employeeService: EmployeeService,private router: Router) { }

  ngOnInit() {
    //this.chercherEmploye(this.champ);
  }

  
    employeeUpdate(id:number){
    this.router.navigate(['update',id]);}

    //deficir la méthode de delete
    deleteEmployee(id:number){
      this.employeeService.deleteEmployee(id).subscribe(
      data=>{console.log(data);this.gotoList();},
      error=>console.log(error));
      
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

  

}
