import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { Departementt } from '../departementt';

@Component({
  selector: 'app-create-equipe',
  templateUrl: './create-equipe.component.html',
  styleUrls: ['./create-equipe.component.css']
})
export class CreateEquipeComponent implements OnInit {


  nom:String;
  submitted = false;
  departement: Departementt;
  departements:Departementt[];
  echec=true
 
  
  constructor(private employeeService: EmployeeService, private router: Router) { }
  ngOnInit() {
    this.reloadData();
  }
  creationequipe(){
    this.employeeService.creation(this.nom).subscribe(
    data=>{
    console.log(data);
    this.departement=data;
    },
        err=>{
        console.log(err);
        });

   // this.gotoList();
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

  onSubmit(){
    this.submitted = true;
    if(this.nom!=null){this.creationequipe();this.echec=false;}
    
    this.reloadData();
    

  }
   
  gotoList(){
    this.router.navigate(['employees']);
  }

}
