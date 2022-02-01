import { Component, OnInit } from '@angular/core';
import { Employee } from'../employee';
import { EmployeeService } from'../services/employee.service';
import { EmployeeListComponent } from '../employee-list/employee-list.component';
import { ActivatedRoute, Router } from'@angular/router';

@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrls: ['./detail-employee.component.css']
})
export class DetailEmployeeComponent implements OnInit {

  
  id:number;
  employee:Employee;
  constructor(private route:ActivatedRoute, private router:Router,
    private employeeService:EmployeeService) { }

  ngOnInit() {
    this.employee= new Employee();
    this.id=this.route.snapshot.params['id'];
    this.employeeService.getEmployee(this.id)
      .subscribe(data=>{
        console.log(data)
      this.employee=data;
    },error=>console.log(error));
    //this.reloadData();
  }

   
  gotoList(){
    this.router.navigate(['employees']);
  }

}
